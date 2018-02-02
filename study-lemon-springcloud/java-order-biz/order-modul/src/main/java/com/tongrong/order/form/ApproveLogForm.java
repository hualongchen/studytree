package com.tongrong.order.form;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author :chenhualong
 * @Date : created in 9:22 2018/1/16
 * @Description :
 */

@Data
public class ApproveLogForm implements Serializable {


    private Long id;

    /**
     * 订单号
     */
    private String orderId;

    /**
     * 环节
     */
    private String link;

    /**
     * 操作者
     */
    private String operateName;

    /**
     * 操作
     */
    private String operate;

    /**
     * 处理意见
     */
    private String result;

    /**
     * 注册时间
     */
    private Date createTime;

    /**
     * 更新时间
     */
    private Date updateTime;

    /**
     * 扩容字段1
     */
    private String field1;

    /**
     * 扩容字段2
     */
    private String field2;

    /**
     * 扩容字段3
     */
    private String field3;
}
