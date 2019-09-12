package com.hz.appLoan.utils;

import com.google.gson.Gson;
import com.qiniu.common.QiniuException;
import com.qiniu.common.Zone;
import com.qiniu.http.Response;
import com.qiniu.storage.UploadManager;
import com.qiniu.storage.model.DefaultPutRet;
import com.qiniu.util.Auth;
import com.qiniu.util.Base64;
import com.qiniu.util.StringMap;
import com.qiniu.util.UrlSafeBase64;
import javafx.scene.layout.Region;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import java.util.UUID;

/**
 * 上传图片到七牛云
 */
@Component
public class QiniuUtil {

    private static final Logger logger = LoggerFactory.getLogger(QiniuUtil.class);

    private static final String domain = "http://ppsp7z038.bkt.clouddn.com/";
    // 账号里面可以找到  进入 个人面板->个人中心->密钥管理可找到
    // 设置好账号的ACCESS_KEY和SECRET_KEY
    private static final String ACCESS_KEY = "MVpid4cKwKe4d8wt5PmJH5yO2c0ayhBxfcexkLJD"; // 这两个登录七牛
    private static final String SECRET_KEY = "dseEH3RV3FyVgQCyTGiynPOJWl1I6soGk49zNr-Z";//
    // 要上传的空间
    private static final String BUCKET_NAME = "bettle"; // 填写新建的那个存储空间对象的名称

    // 密钥
    private static final Auth auth = Auth.create(ACCESS_KEY, SECRET_KEY);


    /**
     * 字节上传
     * @return
     * @throws Exception
     */
    public  String byteUpLoad (byte[] uploadBytes) throws Exception{
//      构造一个带指定 Region 对象的配置类
//      Configuration cfg = new Configuration(Region.region0());

        UploadManager uploadManager = new UploadManager();
//      默认不指定key的情况下，以文件内容的hash值作为文件名
        String key = UUID.randomUUID().toString();

        try {
            Auth auth = Auth.create(ACCESS_KEY, SECRET_KEY);
            String upToken = auth.uploadToken(BUCKET_NAME);
            logger.info("==========upToken=="+ upToken);

            Response response = uploadManager.put(uploadBytes, key, upToken);
            System.err.println("============"+response.bodyString());
            if (response.isOK()){
                return domain+key;
            }
            //解析上传成功的结果
            DefaultPutRet putRet = new Gson().fromJson(response.bodyString(), DefaultPutRet.class);
            System.out.println(putRet.key);
            System.out.println(putRet.hash);
        } catch (Exception ex) {
            logger.error("UnsupportedEncodingException",ex);
        }
        return null;
    }




}
