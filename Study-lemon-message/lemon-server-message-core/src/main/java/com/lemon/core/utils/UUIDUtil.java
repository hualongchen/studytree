package com.lemon.core.utils;

import java.util.UUID;

/**
 * @author :chenhualong
 * @Date : created in 17:11 2018/1/30
 * @Description :
 */
public class UUIDUtil {


    /**
     * UUID生成全局唯一号
     * @return
     */
    public static String  returnUUID(){

        String uuid = UUID.randomUUID().toString();

        return uuid.replaceAll("-", "");
    }
}
