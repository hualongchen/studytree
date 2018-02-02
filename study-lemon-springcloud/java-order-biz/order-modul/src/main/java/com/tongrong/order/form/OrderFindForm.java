package com.tongrong.order.form;

import lombok.Data;

import java.io.Serializable;

/**
 * @author :chenhualong
 * @Date : created in 10:51 2018/1/12
 * @Description :
 */

@Data
public class OrderFindForm implements Serializable {


    /**
     * 用户的ID
     */
    private Long userId;

    /**
     * 用户姓名
     */
    private String name;


    /**
     * 订单的小状态，运营审批，风险审批，风险初审，财务审批，放款
     */
    private int insideOrderStatus;


    /**
     * 订单的大状态，1审批中，2审批通过，3审批拒绝，4待放款，5还款中，6已结清
     */
    private int orderStatus;


    /**
     * 当前第几页
     */
    private int page ;


    /**
     * 每页多少条数据
     */
    private int limit ;

    /**
     * 1代表正序， 2代表倒序。 默认1
     */
   // private int orderBy;



}
