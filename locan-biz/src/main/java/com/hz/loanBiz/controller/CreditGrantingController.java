package com.hz.loanBiz.controller;

import com.hz.loanBiz.service.CreditGrantingService;
import com.hz.loanBiz.vo.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 授信相关
 */
@RequestMapping("/credit")
@RestController
public class CreditGrantingController {

    private static final Logger logger = LoggerFactory.getLogger(CreditGrantingController.class);

    @Autowired
    private CreditGrantingService grantingService;

    /**
     * 生成授信流水
     * @return
     */

    @RequestMapping("/getQuota")
    public Result createCreditQuota(@RequestParam("userId")String userId ){
        logger.info("接受到用户id：{}获取授信额度的请求");



        return null;
    }

    /**
     * 获取授信额度，把数据推送给风控系统
     * @return
     */
    @RequestMapping("/getQuota")
    public Result getCreditQuota(@RequestParam("userId")String userId ){
        logger.info("接受到用户id：{}获取授信额度的请求");

        return null;
    }


}
