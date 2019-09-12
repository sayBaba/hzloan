package com.hz.userLoan.enums;

import lombok.Data;

/**
 * 学历枚举类
 */
public enum  Education {

    CZ("初中及以下", 0),
    GZ("高中", 1),
    DZ("大专", 2),
    BK("本科", 3),
    SS("硕士", 4);

    // 成员变量
    private String name;
    private int code;

    /**
     * 构造函数
     * @param name
     * @param code
     */
    private Education(String name, int code) {
        this.name = name;
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    /**
     * 根据code获取值
     * @param code
     * @return
     */
    public static String getName(int code) {
        for (Education c : Education.values()) {
            if (c.getCode() == code) {
                return c.name;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        System.err.println(Education.getName(0));
    }
}
