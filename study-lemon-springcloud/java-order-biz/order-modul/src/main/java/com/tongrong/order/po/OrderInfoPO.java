package com.tongrong.order.po;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Table(name = "order_info")
public class OrderInfoPO  implements Serializable{
    /**
     * 主键自增ID
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 订单号
     */
    @Column(name = "order_id")
    private String orderId;

    /**
     * 用户的ID
     */
    @Column(name = "user_id")
    private Long userId;

    /**
     * 申请贷款金额
     */
    private String account;

    /**
     * 申请期限12期，24期等
     */
    @Column(name = "term_no")
    private String termNo;

    /**
     * 贷款用途
     */
    private String purpose;

    /**
     * 子产品
     */
    @Column(name = "child_product")
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
    @Column(name = "risk_account")
    private String riskAccount;

    /**
     * 批准贷款期限
     */
    @Column(name = "risk_term")
    private String riskTerm;

    /**
     * 最终贷款金额
     */
    @Column(name = "final_account")
    private String finalAccount;

    /**
     * 订单贷款金额
     */
    @Column(name = "order_account")
    private String orderAccount;

    /**
     * 绑定的银行卡
     */
    @Column(name = "bank_card_no")
    private String bankCardNo;

    /**
     * 银行卡银行名称
     */
    @Column(name = "bank_card_name")
    private String bankCardName;

    /**
     * 订单的大状态，已提交，审批中，待放款，还款中，已完成
     */
    @Column(name = "order_status")
    private Integer orderStatus;

    /**
     * 订单的小状态，运营审批，风险审批，风险初审，财务审批，放款
     */
    @Column(name = "inside_order_status")
    private Integer insideOrderStatus;

    /**
     * 用户姓名
     */
    private String name;

    /**
     * 身份证号码
     */
    @Column(name = "id_no")
    private String idNo;

    /**
     * 注册的手机号
     */
    @Column(name = "mobile_no")
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
    @Column(name = "house_type")
    private String houseType;

    /**
     * 单位类型
     */
    @Column(name = "company_type")
    private String companyType;

    /**
     * 职业类型
     */
    @Column(name = "work_type")
    private String workType;

    /**
     * 是否有社保信息
     */
    @Column(name = "has_social_security")
    private String hasSocialSecurity;

    /**
     * 开户年月
     */
    @Column(name = "social_security_open_year")
    private String socialSecurityOpenYear;

    /**
     * 社保当前状态
     */
    @Column(name = "social_security_now_status")
    private String socialSecurityNowStatus;

    /**
     * 社保月缴存金额
     */
    @Column(name = "social_security_month_money")
    private String socialSecurityMonthMoney;

    /**
     * 缴存单位
     */
    @Column(name = "social_security_deposit_units")
    private String socialSecurityDepositUnits;

    /**
     * 是否有公积金
     */
    @Column(name = "has_accumulation_fund")
    private String hasAccumulationFund;

    /**
     * 公积金开户年月
     */
    @Column(name = "accumulation_fund_open_year")
    private String accumulationFundOpenYear;

    /**
     * 公积金当前状态
     */
    @Column(name = "accumulation_fund_now_status")
    private String accumulationFundNowStatus;

    /**
     * 公积金月缴存金额
     */
    @Column(name = "accumulation_fund_month_money")
    private String accumulationFundMonthMoney;

    /**
     * 公积金缴存单位
     */
    @Column(name = "accumulation_fund_deposit_units")
    private String accumulationFundDepositUnits;

    /**
     * 是否有房产
     */
    @Column(name = "has_house")
    private String hasHouse;

    /**
     * 住房地址
     */
    @Column(name = "house_address")
    private String houseAddress;

    /**
     * 住房面积
     */
    @Column(name = "house_area")
    private String houseArea;

    /**
     * 住房估值，30.00万
     */
    @Column(name = "house_value")
    private String houseValue;

    /**
     * 用户配偶姓名
     */
    @Column(name = "friend_name1")
    private String friendName1;

    /**
     * 配偶的手机号
     */
    @Column(name = "friend_mobile_no1")
    private String friendMobileNo1;

    /**
     * 关系1
     */
    @Column(name = "friend_ship1")
    private String friendShip1;

    /**
     * 关联人姓名
     */
    @Column(name = "friend_name2")
    private String friendName2;

    /**
     * 关联人的手机号
     */
    @Column(name = "friend_mobile_no2")
    private String friendMobileNo2;

    /**
     * 关系2
     */
    @Column(name = "friend_ship2")
    private String friendShip2;

    /**
     * 插入时间
     */
    @Column(name = "create_time")
    private Date createTime;

    /**
     * 更新时间
     */
    @Column(name = "update_time")
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
     * 获取主键自增ID
     *
     * @return id - 主键自增ID
     */
    public Long getId() {
        return id;
    }

    /**
     * 设置主键自增ID
     *
     * @param id 主键自增ID
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取订单号
     *
     * @return order_id - 订单号
     */
    public String getOrderId() {
        return orderId;
    }

    /**
     * 设置订单号
     *
     * @param orderId 订单号
     */
    public void setOrderId(String orderId) {
        this.orderId = orderId == null ? null : orderId.trim();
    }

    /**
     * 获取用户的ID
     *
     * @return user_id - 用户的ID
     */
    public Long getUserId() {
        return userId;
    }

    /**
     * 设置用户的ID
     *
     * @param userId 用户的ID
     */
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    /**
     * 获取申请贷款金额
     *
     * @return account - 申请贷款金额
     */
    public String getAccount() {
        return account;
    }

    /**
     * 设置申请贷款金额
     *
     * @param account 申请贷款金额
     */
    public void setAccount(String account) {
        this.account = account == null ? null : account.trim();
    }

    /**
     * 获取申请期限12期，24期等
     *
     * @return term_no - 申请期限12期，24期等
     */
    public String getTermNo() {
        return termNo;
    }

    /**
     * 设置申请期限12期，24期等
     *
     * @param termNo 申请期限12期，24期等
     */
    public void setTermNo(String termNo) {
        this.termNo = termNo;
    }

    /**
     * 获取贷款用途
     *
     * @return purpose - 贷款用途
     */
    public String getPurpose() {
        return purpose;
    }

    /**
     * 设置贷款用途
     *
     * @param purpose 贷款用途
     */
    public void setPurpose(String purpose) {
        this.purpose = purpose == null ? null : purpose.trim();
    }

    /**
     * 获取子产品
     *
     * @return child_product - 子产品
     */
    public String getChildProduct() {
        return childProduct;
    }

    /**
     * 设置子产品
     *
     * @param childProduct 子产品
     */
    public void setChildProduct(String childProduct) {
        this.childProduct = childProduct == null ? null : childProduct.trim();
    }

    /**
     * 获取来源
     *
     * @return source - 来源
     */
    public String getSource() {
        return source;
    }

    /**
     * 设置来源
     *
     * @param source 来源
     */
    public void setSource(String source) {
        this.source = source == null ? null : source.trim();
    }

    /**
     * 获取贷款利率
     *
     * @return rate - 贷款利率
     */
    public String getRate() {
        return rate;
    }

    /**
     * 设置贷款利率
     *
     * @param rate 贷款利率
     */
    public void setRate(String rate) {
        this.rate = rate == null ? null : rate.trim();
    }

    /**
     * 获取还款方式
     *
     * @return repayment - 还款方式
     */
    public String getRepayment() {
        return repayment;
    }

    /**
     * 设置还款方式
     *
     * @param repayment 还款方式
     */
    public void setRepayment(String repayment) {
        this.repayment = repayment == null ? null : repayment.trim();
    }

    /**
     * 获取批准贷款金额
     *
     * @return risk_account - 批准贷款金额
     */
    public String getRiskAccount() {
        return riskAccount;
    }

    /**
     * 设置批准贷款金额
     *
     * @param riskAccount 批准贷款金额
     */
    public void setRiskAccount(String riskAccount) {
        this.riskAccount = riskAccount == null ? null : riskAccount.trim();
    }

    /**
     * 获取批准贷款期限
     *
     * @return risk_term - 批准贷款期限
     */
    public String getRiskTerm() {
        return riskTerm;
    }

    /**
     * 设置批准贷款期限
     *
     * @param riskTerm 批准贷款期限
     */
    public void setRiskTerm(String riskTerm) {
        this.riskTerm = riskTerm;
    }

    /**
     * 获取最终贷款金额
     *
     * @return final_account - 最终贷款金额
     */
    public String getFinalAccount() {
        return finalAccount;
    }

    /**
     * 设置最终贷款金额
     *
     * @param finalAccount 最终贷款金额
     */
    public void setFinalAccount(String finalAccount) {
        this.finalAccount = finalAccount == null ? null : finalAccount.trim();
    }

    /**
     * 获取订单贷款金额
     *
     * @return order_account - 订单贷款金额
     */
    public String getOrderAccount() {
        return orderAccount;
    }

    /**
     * 设置订单贷款金额
     *
     * @param orderAccount 订单贷款金额
     */
    public void setOrderAccount(String orderAccount) {
        this.orderAccount = orderAccount == null ? null : orderAccount.trim();
    }

    /**
     * 获取绑定的银行卡
     *
     * @return bank_card_no - 绑定的银行卡
     */
    public String getBankCardNo() {
        return bankCardNo;
    }

    /**
     * 设置绑定的银行卡
     *
     * @param bankCardNo 绑定的银行卡
     */
    public void setBankCardNo(String bankCardNo) {
        this.bankCardNo = bankCardNo == null ? null : bankCardNo.trim();
    }

    /**
     * 获取银行卡银行名称
     *
     * @return bank_card_name - 银行卡银行名称
     */
    public String getBankCardName() {
        return bankCardName;
    }

    /**
     * 设置银行卡银行名称
     *
     * @param bankCardName 银行卡银行名称
     */
    public void setBankCardName(String bankCardName) {
        this.bankCardName = bankCardName == null ? null : bankCardName.trim();
    }

    /**
     * 获取订单的大状态，已提交，审批中，待放款，还款中，已完成
     *
     * @return order_status - 订单的大状态，已提交，审批中，待放款，还款中，已完成
     */
    public Integer getOrderStatus() {
        return orderStatus;
    }

    /**
     * 设置订单的大状态，已提交，审批中，待放款，还款中，已完成
     *
     * @param orderStatus 订单的大状态，已提交，审批中，待放款，还款中，已完成
     */
    public void setOrderStatus(Integer orderStatus) {
        this.orderStatus = orderStatus;
    }

    /**
     * 获取订单的小状态，运营审批，风险审批，风险初审，财务审批，放款
     *
     * @return inside_order_status - 订单的小状态，运营审批，风险审批，风险初审，财务审批，放款
     */
    public Integer getInsideOrderStatus() {
        return insideOrderStatus;
    }

    /**
     * 设置订单的小状态，运营审批，风险审批，风险初审，财务审批，放款
     *
     * @param insideOrderStatus 订单的小状态，运营审批，风险审批，风险初审，财务审批，放款
     */
    public void setInsideOrderStatus(Integer insideOrderStatus) {
        this.insideOrderStatus = insideOrderStatus;
    }

    /**
     * 获取用户姓名
     *
     * @return name - 用户姓名
     */
    public String getName() {
        return name;
    }

    /**
     * 设置用户姓名
     *
     * @param name 用户姓名
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * 获取身份证号码
     *
     * @return id_no - 身份证号码
     */
    public String getIdNo() {
        return idNo;
    }

    /**
     * 设置身份证号码
     *
     * @param idNo 身份证号码
     */
    public void setIdNo(String idNo) {
        this.idNo = idNo == null ? null : idNo.trim();
    }

    /**
     * 获取注册的手机号
     *
     * @return mobile_no - 注册的手机号
     */
    public String getMobileNo() {
        return mobileNo;
    }

    /**
     * 设置注册的手机号
     *
     * @param mobileNo 注册的手机号
     */
    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo == null ? null : mobileNo.trim();
    }

    /**
     * 获取婚姻状况，已婚，未婚，离异等
     *
     * @return marry - 婚姻状况，已婚，未婚，离异等
     */
    public String getMarry() {
        return marry;
    }

    /**
     * 设置婚姻状况，已婚，未婚，离异等
     *
     * @param marry 婚姻状况，已婚，未婚，离异等
     */
    public void setMarry(String marry) {
        this.marry = marry == null ? null : marry.trim();
    }

    /**
     * 获取所在城市
     *
     * @return city - 所在城市
     */
    public String getCity() {
        return city;
    }

    /**
     * 设置所在城市
     *
     * @param city 所在城市
     */
    public void setCity(String city) {
        this.city = city == null ? null : city.trim();
    }

    /**
     * 获取详细城市区县
     *
     * @return region - 详细城市区县
     */
    public String getRegion() {
        return region;
    }

    /**
     * 设置详细城市区县
     *
     * @param region 详细城市区县
     */
    public void setRegion(String region) {
        this.region = region == null ? null : region.trim();
    }

    /**
     * 获取住房性质
     *
     * @return house_type - 住房性质
     */
    public String getHouseType() {
        return houseType;
    }

    /**
     * 设置住房性质
     *
     * @param houseType 住房性质
     */
    public void setHouseType(String houseType) {
        this.houseType = houseType == null ? null : houseType.trim();
    }

    /**
     * 获取单位类型
     *
     * @return company_type - 单位类型
     */
    public String getCompanyType() {
        return companyType;
    }

    /**
     * 设置单位类型
     *
     * @param companyType 单位类型
     */
    public void setCompanyType(String companyType) {
        this.companyType = companyType == null ? null : companyType.trim();
    }

    /**
     * 获取职业类型
     *
     * @return work_type - 职业类型
     */
    public String getWorkType() {
        return workType;
    }

    /**
     * 设置职业类型
     *
     * @param workType 职业类型
     */
    public void setWorkType(String workType) {
        this.workType = workType == null ? null : workType.trim();
    }

    /**
     * 获取是否有社保信息
     *
     * @return has_social_security - 是否有社保信息
     */
    public String getHasSocialSecurity() {
        return hasSocialSecurity;
    }

    /**
     * 设置是否有社保信息
     *
     * @param hasSocialSecurity 是否有社保信息
     */
    public void setHasSocialSecurity(String hasSocialSecurity) {
        this.hasSocialSecurity = hasSocialSecurity == null ? null : hasSocialSecurity.trim();
    }

    /**
     * 获取开户年月
     *
     * @return social_security_open_year - 开户年月
     */
    public String getSocialSecurityOpenYear() {
        return socialSecurityOpenYear;
    }

    /**
     * 设置开户年月
     *
     * @param socialSecurityOpenYear 开户年月
     */
    public void setSocialSecurityOpenYear(String socialSecurityOpenYear) {
        this.socialSecurityOpenYear = socialSecurityOpenYear == null ? null : socialSecurityOpenYear.trim();
    }

    /**
     * 获取社保当前状态
     *
     * @return social_security_now_status - 社保当前状态
     */
    public String getSocialSecurityNowStatus() {
        return socialSecurityNowStatus;
    }

    /**
     * 设置社保当前状态
     *
     * @param socialSecurityNowStatus 社保当前状态
     */
    public void setSocialSecurityNowStatus(String socialSecurityNowStatus) {
        this.socialSecurityNowStatus = socialSecurityNowStatus == null ? null : socialSecurityNowStatus.trim();
    }

    /**
     * 获取社保月缴存金额
     *
     * @return social_security_month_money - 社保月缴存金额
     */
    public String getSocialSecurityMonthMoney() {
        return socialSecurityMonthMoney;
    }

    /**
     * 设置社保月缴存金额
     *
     * @param socialSecurityMonthMoney 社保月缴存金额
     */
    public void setSocialSecurityMonthMoney(String socialSecurityMonthMoney) {
        this.socialSecurityMonthMoney = socialSecurityMonthMoney == null ? null : socialSecurityMonthMoney.trim();
    }

    /**
     * 获取缴存单位
     *
     * @return social_security_deposit_units - 缴存单位
     */
    public String getSocialSecurityDepositUnits() {
        return socialSecurityDepositUnits;
    }

    /**
     * 设置缴存单位
     *
     * @param socialSecurityDepositUnits 缴存单位
     */
    public void setSocialSecurityDepositUnits(String socialSecurityDepositUnits) {
        this.socialSecurityDepositUnits = socialSecurityDepositUnits == null ? null : socialSecurityDepositUnits.trim();
    }

    /**
     * 获取是否有公积金
     *
     * @return has_accumulation_fund - 是否有公积金
     */
    public String getHasAccumulationFund() {
        return hasAccumulationFund;
    }

    /**
     * 设置是否有公积金
     *
     * @param hasAccumulationFund 是否有公积金
     */
    public void setHasAccumulationFund(String hasAccumulationFund) {
        this.hasAccumulationFund = hasAccumulationFund == null ? null : hasAccumulationFund.trim();
    }

    /**
     * 获取公积金开户年月
     *
     * @return accumulation_fund_open_year - 公积金开户年月
     */
    public String getAccumulationFundOpenYear() {
        return accumulationFundOpenYear;
    }

    /**
     * 设置公积金开户年月
     *
     * @param accumulationFundOpenYear 公积金开户年月
     */
    public void setAccumulationFundOpenYear(String accumulationFundOpenYear) {
        this.accumulationFundOpenYear = accumulationFundOpenYear == null ? null : accumulationFundOpenYear.trim();
    }

    /**
     * 获取公积金当前状态
     *
     * @return accumulation_fund_now_status - 公积金当前状态
     */
    public String getAccumulationFundNowStatus() {
        return accumulationFundNowStatus;
    }

    /**
     * 设置公积金当前状态
     *
     * @param accumulationFundNowStatus 公积金当前状态
     */
    public void setAccumulationFundNowStatus(String accumulationFundNowStatus) {
        this.accumulationFundNowStatus = accumulationFundNowStatus == null ? null : accumulationFundNowStatus.trim();
    }

    /**
     * 获取公积金月缴存金额
     *
     * @return accumulation_fund_month_money - 公积金月缴存金额
     */
    public String getAccumulationFundMonthMoney() {
        return accumulationFundMonthMoney;
    }

    /**
     * 设置公积金月缴存金额
     *
     * @param accumulationFundMonthMoney 公积金月缴存金额
     */
    public void setAccumulationFundMonthMoney(String accumulationFundMonthMoney) {
        this.accumulationFundMonthMoney = accumulationFundMonthMoney == null ? null : accumulationFundMonthMoney.trim();
    }

    /**
     * 获取公积金缴存单位
     *
     * @return accumulation_fund_deposit_units - 公积金缴存单位
     */
    public String getAccumulationFundDepositUnits() {
        return accumulationFundDepositUnits;
    }

    /**
     * 设置公积金缴存单位
     *
     * @param accumulationFundDepositUnits 公积金缴存单位
     */
    public void setAccumulationFundDepositUnits(String accumulationFundDepositUnits) {
        this.accumulationFundDepositUnits = accumulationFundDepositUnits == null ? null : accumulationFundDepositUnits.trim();
    }

    /**
     * 获取是否有房产
     *
     * @return has_house - 是否有房产
     */
    public String getHasHouse() {
        return hasHouse;
    }

    /**
     * 设置是否有房产
     *
     * @param hasHouse 是否有房产
     */
    public void setHasHouse(String hasHouse) {
        this.hasHouse = hasHouse == null ? null : hasHouse.trim();
    }

    /**
     * 获取住房地址
     *
     * @return house_address - 住房地址
     */
    public String getHouseAddress() {
        return houseAddress;
    }

    /**
     * 设置住房地址
     *
     * @param houseAddress 住房地址
     */
    public void setHouseAddress(String houseAddress) {
        this.houseAddress = houseAddress == null ? null : houseAddress.trim();
    }

    /**
     * 获取住房面积
     *
     * @return house_area - 住房面积
     */
    public String getHouseArea() {
        return houseArea;
    }

    /**
     * 设置住房面积
     *
     * @param houseArea 住房面积
     */
    public void setHouseArea(String houseArea) {
        this.houseArea = houseArea == null ? null : houseArea.trim();
    }

    /**
     * 获取住房估值，30.00万
     *
     * @return house_value - 住房估值，30.00万
     */
    public String getHouseValue() {
        return houseValue;
    }

    /**
     * 设置住房估值，30.00万
     *
     * @param houseValue 住房估值，30.00万
     */
    public void setHouseValue(String houseValue) {
        this.houseValue = houseValue == null ? null : houseValue.trim();
    }

    /**
     * 获取用户配偶姓名
     *
     * @return friend_name1 - 用户配偶姓名
     */
    public String getFriendName1() {
        return friendName1;
    }

    /**
     * 设置用户配偶姓名
     *
     * @param friendName1 用户配偶姓名
     */
    public void setFriendName1(String friendName1) {
        this.friendName1 = friendName1 == null ? null : friendName1.trim();
    }

    /**
     * 获取配偶的手机号
     *
     * @return friend_mobile_no1 - 配偶的手机号
     */
    public String getFriendMobileNo1() {
        return friendMobileNo1;
    }

    /**
     * 设置配偶的手机号
     *
     * @param friendMobileNo1 配偶的手机号
     */
    public void setFriendMobileNo1(String friendMobileNo1) {
        this.friendMobileNo1 = friendMobileNo1 == null ? null : friendMobileNo1.trim();
    }

    /**
     * 获取关系1
     *
     * @return friend_ship1 - 关系1
     */
    public String getFriendShip1() {
        return friendShip1;
    }

    /**
     * 设置关系1
     *
     * @param friendShip1 关系1
     */
    public void setFriendShip1(String friendShip1) {
        this.friendShip1 = friendShip1 == null ? null : friendShip1.trim();
    }

    /**
     * 获取关联人姓名
     *
     * @return friend_name2 - 关联人姓名
     */
    public String getFriendName2() {
        return friendName2;
    }

    /**
     * 设置关联人姓名
     *
     * @param friendName2 关联人姓名
     */
    public void setFriendName2(String friendName2) {
        this.friendName2 = friendName2 == null ? null : friendName2.trim();
    }

    /**
     * 获取关联人的手机号
     *
     * @return friend_mobile_no2 - 关联人的手机号
     */
    public String getFriendMobileNo2() {
        return friendMobileNo2;
    }

    /**
     * 设置关联人的手机号
     *
     * @param friendMobileNo2 关联人的手机号
     */
    public void setFriendMobileNo2(String friendMobileNo2) {
        this.friendMobileNo2 = friendMobileNo2 == null ? null : friendMobileNo2.trim();
    }

    /**
     * 获取关系2
     *
     * @return friend_ship2 - 关系2
     */
    public String getFriendShip2() {
        return friendShip2;
    }

    /**
     * 设置关系2
     *
     * @param friendShip2 关系2
     */
    public void setFriendShip2(String friendShip2) {
        this.friendShip2 = friendShip2 == null ? null : friendShip2.trim();
    }

    /**
     * 获取插入时间
     *
     * @return create_time - 插入时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 设置插入时间
     *
     * @param createTime 插入时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 获取更新时间
     *
     * @return update_time - 更新时间
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * 设置更新时间
     *
     * @param updateTime 更新时间
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * 获取扩容字段1
     *
     * @return field1 - 扩容字段1
     */
    public String getField1() {
        return field1;
    }

    /**
     * 设置扩容字段1
     *
     * @param field1 扩容字段1
     */
    public void setField1(String field1) {
        this.field1 = field1 == null ? null : field1.trim();
    }

    /**
     * 获取扩容字段2
     *
     * @return field2 - 扩容字段2
     */
    public String getField2() {
        return field2;
    }

    /**
     * 设置扩容字段2
     *
     * @param field2 扩容字段2
     */
    public void setField2(String field2) {
        this.field2 = field2 == null ? null : field2.trim();
    }

    /**
     * 获取扩容字段3
     *
     * @return field3 - 扩容字段3
     */
    public String getField3() {
        return field3;
    }

    /**
     * 设置扩容字段3
     *
     * @param field3 扩容字段3
     */
    public void setField3(String field3) {
        this.field3 = field3 == null ? null : field3.trim();
    }


    @Override
    public String toString() {
        return "OrderInfoPO{" +
                "id=" + id +
                ", orderId='" + orderId + '\'' +
                ", userId=" + userId +
                ", account='" + account + '\'' +
                ", termNo='" + termNo + '\'' +
                ", purpose='" + purpose + '\'' +
                ", childProduct='" + childProduct + '\'' +
                ", source='" + source + '\'' +
                ", rate='" + rate + '\'' +
                ", repayment='" + repayment + '\'' +
                ", riskAccount='" + riskAccount + '\'' +
                ", riskTerm=" + riskTerm +
                ", finalAccount='" + finalAccount + '\'' +
                ", orderAccount='" + orderAccount + '\'' +
                ", bankCardNo='" + bankCardNo + '\'' +
                ", bankCardName='" + bankCardName + '\'' +
                ", orderStatus=" + orderStatus +
                ", insideOrderStatus=" + insideOrderStatus +
                ", name='" + name + '\'' +
                ", idNo='" + idNo + '\'' +
                ", mobileNo='" + mobileNo + '\'' +
                ", marry='" + marry + '\'' +
                ", city='" + city + '\'' +
                ", region='" + region + '\'' +
                ", houseType='" + houseType + '\'' +
                ", companyType='" + companyType + '\'' +
                ", workType='" + workType + '\'' +
                ", hasSocialSecurity='" + hasSocialSecurity + '\'' +
                ", socialSecurityOpenYear='" + socialSecurityOpenYear + '\'' +
                ", socialSecurityNowStatus='" + socialSecurityNowStatus + '\'' +
                ", socialSecurityMonthMoney='" + socialSecurityMonthMoney + '\'' +
                ", socialSecurityDepositUnits='" + socialSecurityDepositUnits + '\'' +
                ", hasAccumulationFund='" + hasAccumulationFund + '\'' +
                ", accumulationFundOpenYear='" + accumulationFundOpenYear + '\'' +
                ", accumulationFundNowStatus='" + accumulationFundNowStatus + '\'' +
                ", accumulationFundMonthMoney='" + accumulationFundMonthMoney + '\'' +
                ", accumulationFundDepositUnits='" + accumulationFundDepositUnits + '\'' +
                ", hasHouse='" + hasHouse + '\'' +
                ", houseAddress='" + houseAddress + '\'' +
                ", houseArea='" + houseArea + '\'' +
                ", houseValue='" + houseValue + '\'' +
                ", friendName1='" + friendName1 + '\'' +
                ", friendMobileNo1='" + friendMobileNo1 + '\'' +
                ", friendShip1='" + friendShip1 + '\'' +
                ", friendName2='" + friendName2 + '\'' +
                ", friendMobileNo2='" + friendMobileNo2 + '\'' +
                ", friendShip2='" + friendShip2 + '\'' +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                ", field1='" + field1 + '\'' +
                ", field2='" + field2 + '\'' +
                ", field3='" + field3 + '\'' +
                '}';
    }
}