package com.lemon.user.api;

/**
 * @author :chenhualong
 * @Date : created in 11:47 2018/1/31
 * @Description :
 */
public interface LemonUserService {


    /**
     * 增加积分        需要实现幂等
     * @param userId
     * @param messageId
     */
    public void  adduserPoint(String userId,String messageId);




}
