package com.tongrong.order.form;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author :chenhualong
 * @Date : created in 15:00 2018/1/11
 * @Description :
 */

@Data
public class OrderInfoForm implements Serializable {


    /**
     * 订单号
     */
    private String orderId;

    /**
     * 用户的ID
     */
    private Long userId;

    /**
     * 申请贷款金额
     */
    private String account;

    /**
     * 申请期限12期，24期等
     */
    private String termNo;

    /**
     * 贷款用途
     */
    private String purpose;

    /**
     * 子产品
     */
    private String childProduct;

    /**
     * 来源
     */
    private String source;

    /**
     * 贷款利率
     */
    private String rate;

    /**
     * 还款方式
     */
    private String repayment;

    /**
     * 批准贷款金额
     */
    private String riskAccount;

    /**
     * 批准贷款期限
     */
    private String riskTerm;

    /**
     * 最终贷款金额
     */
    private String finalAccount;

    /**
     * 订单贷款金额
     */
    private String orderAccount;

    /**
     * 绑定的银行卡
     */
    private String bankCardNo;

    /**
     * 银行卡银行名称
     */
    private String bankCardName;

    /**
     * 订单的大状态，已提交，审批中，待放款，还款中，已完成
     */
    private int orderStatus;

    /**
     * 订单的小状态，运营审批，风险审批，风险初审，财务审批，放款
     */
    private int insideOrderStatus;

    /**
     * 用户姓名
     */
    private String name;

    /**
     * 身份证号码
     */
    private String idNo;

    /**
     * 注册的手机号
     */
    private String mobileNo;

    /**
     * 婚姻状况，已婚，未婚，离异等
     */
    private String marry;

    /**
     * 所在城市
     */
    private String city;

    /**
     * 详细城市区县
     */
    private String region;

    /**
     * 住房性质
     */
    private String houseType;

    /**
     * 单位类型
     */
    private String companyType;

    /**
     * 职业类型
     */
    private String workType;

    /**
     * 是否有社保信息
     */
    private String hasSocialSecurity;

    /**
     * 开户年月
     */
    private String socialSecurityOpenYear;

    /**
     * 社保当前状态
     */
    private String socialSecurityNowStatus;

    /**
     * 社保月缴存金额
     */
    private String socialSecurityMonthMoney;

    /**
     * 缴存单位
     */
    private String socialSecurityDepositUnits;

    /**
     * 是否有公积金
     */
    private String hasAccumulationFund;

    /**
     * 公积金开户年月
     */
    private String accumulationFundOpenYear;

    /**
     * 公积金当前状态
     */
    private String accumulationFundNowStatus;

    /**
     * 公积金月缴存金额
     */
    private String accumulationFundMonthMoney;

    /**
     * 公积金缴存单位
     */
    private String accumulationFundDepositUnits;

    /**
     * 是否有房产
     */
    private String hasHouse;

    /**
     * 住房地址
     */
    private String houseAddress;

    /**
     * 住房面积
     */
    private String houseArea;

    /**
     * 住房估值，30.00万
     */
    private String houseValue;

    /**
     * 用户配偶姓名
     */
    private String friendName1;

    /**
     * 配偶的手机号
     */
    private String friendMobileNo1;

    /**
     * 关系1
     */
    private String friendShip1;

    /**
     * 关联人姓名
     */
    private String friendName2;

    /**
     * 关联人的手机号
     */
    private String friendMobileNo2;

    /**
     * 关系2
     */
    private String friendShip2;

    /**
     * 插入时间
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

    /**
     * 消费合同金额
     */
    private String contract ;

    /**
     * 操作者
     */
    private String operateName;

    /**
     * 产品名称
     */
    private String product ;


}
