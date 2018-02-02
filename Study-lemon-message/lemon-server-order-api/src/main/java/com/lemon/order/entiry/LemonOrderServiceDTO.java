package com.lemon.order.entiry;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author :chenhualong
 * @Date : created in 16:23 2018/1/30
 * @Description :
 */


@Data
public class LemonOrderServiceDTO implements Serializable {



    private Long id;

    /**
     * 订单号
     */
    private String orderId;

    /**
     * 用户的ID
     */
    private String userId;

    /**
     * 申请贷款金额
     */
    private String account;

    /**
     * 状态：  待支付，支付成功，支付失败
     */
    private String status;

    /**
     * 插入时间
     */
    private Date createTime;


    /**
     * 负责消息传输
     */
    private String messageId ;



}
