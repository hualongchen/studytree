package com.lemon.user.service.dao.bean;

import java.util.Date;
import javax.persistence.*;

@Table(name = "datasource_qianhai_echkpkgscard")
public class QianhaiBankCardPO {
    /**
     * 主键自增ID
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 交易流水号-只能用一次
     */
    @Column(name = "trans_no")
    private String transNo;

    /**
     * 批次号
     */
    @Column(name = "batch_no")
    private String batchNo;

    /**
     * 序列号，本次唯一
     */
    @Column(name = "seq_no")
    private String seqNo;

    /**
     * 银行卡号
     */
    @Column(name = "bank_card_no")
    private String bankCardNo;

    /**
     * 鉴权A3,A4,A6
     */
    @Column(name = "auth_type")
    private String authType;

    /**
     * 开户手机号
     */
    @Column(name = "mobile_no")
    private String mobileNo;

    /**
     * 开户人证件号码
     */
    @Column(name = "id_no")
    private String idNo;

    /**
     * 证件类型I-居民身份证
     P-外国护照
     M-军官证
     S-港澳通行证或台胞证
     C-中国护照
     L-中国临时身份证
     H-户口本编号
     B-士兵证
     J-警官证
     R-外国公民永久居留证
     O-其他
     */
    @Column(name = "id_type")
    private String idType;

    /**
     * 主体姓名
     */
    private String name;

    /**
     * 原因代码
     */
    @Column(name = "reason_code")
    private String reasonCode;

    /**
     * 有效期年
     */
    @Column(name = "expires_year")
    private String expiresYear;

    /**
     * 有效期月
     */
    @Column(name = "expires_month")
    private String expiresMonth;

    /**
     * 信用卡CVN码
     */
    @Column(name = "credit_card_cvn")
    private String creditCardCvn;

    /**
     * 复用天数，默认365
     */
    @Column(name = "reuse_days")
    private String reuseDays;

    /**
     * 业务描述
     */
    @Column(name = "busi_desc")
    private String busiDesc;

    /**
     * 鉴权结果，1通过，2不通过，3未覆盖
     */
    @Column(name = "auth_result")
    private String authResult;

    /**
     * 发卡行
     */
    @Column(name = "bank_name")
    private String bankName;

    /**
     * 卡类型：贷记卡，准贷记卡，借记卡， 预付费卡
     */
    @Column(name = "card_type")
    private String cardType;

    /**
     * 错误类型
     */
    @Column(name = "er_code")
    private String erCode;

    /**
     * 错误信息
     */
    @Column(name = "er_msg")
    private String erMsg;

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
     * 获取交易流水号-只能用一次
     *
     * @return trans_no - 交易流水号-只能用一次
     */
    public String getTransNo() {
        return transNo;
    }

    /**
     * 设置交易流水号-只能用一次
     *
     * @param transNo 交易流水号-只能用一次
     */
    public void setTransNo(String transNo) {
        this.transNo = transNo == null ? null : transNo.trim();
    }

    /**
     * 获取批次号
     *
     * @return batch_no - 批次号
     */
    public String getBatchNo() {
        return batchNo;
    }

    /**
     * 设置批次号
     *
     * @param batchNo 批次号
     */
    public void setBatchNo(String batchNo) {
        this.batchNo = batchNo == null ? null : batchNo.trim();
    }

    /**
     * 获取序列号，本次唯一
     *
     * @return seq_no - 序列号，本次唯一
     */
    public String getSeqNo() {
        return seqNo;
    }

    /**
     * 设置序列号，本次唯一
     *
     * @param seqNo 序列号，本次唯一
     */
    public void setSeqNo(String seqNo) {
        this.seqNo = seqNo == null ? null : seqNo.trim();
    }

    /**
     * 获取银行卡号
     *
     * @return bank_card_no - 银行卡号
     */
    public String getBankCardNo() {
        return bankCardNo;
    }

    /**
     * 设置银行卡号
     *
     * @param bankCardNo 银行卡号
     */
    public void setBankCardNo(String bankCardNo) {
        this.bankCardNo = bankCardNo == null ? null : bankCardNo.trim();
    }

    /**
     * 获取鉴权A3,A4,A6
     *
     * @return auth_type - 鉴权A3,A4,A6
     */
    public String getAuthType() {
        return authType;
    }

    /**
     * 设置鉴权A3,A4,A6
     *
     * @param authType 鉴权A3,A4,A6
     */
    public void setAuthType(String authType) {
        this.authType = authType == null ? null : authType.trim();
    }

    /**
     * 获取开户手机号
     *
     * @return mobile_no - 开户手机号
     */
    public String getMobileNo() {
        return mobileNo;
    }

    /**
     * 设置开户手机号
     *
     * @param mobileNo 开户手机号
     */
    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo == null ? null : mobileNo.trim();
    }

    /**
     * 获取开户人证件号码
     *
     * @return id_no - 开户人证件号码
     */
    public String getIdNo() {
        return idNo;
    }

    /**
     * 设置开户人证件号码
     *
     * @param idNo 开户人证件号码
     */
    public void setIdNo(String idNo) {
        this.idNo = idNo == null ? null : idNo.trim();
    }

    /**
     * 获取证件类型I-居民身份证
     P-外国护照
     M-军官证
     S-港澳通行证或台胞证
     C-中国护照
     L-中国临时身份证
     H-户口本编号
     B-士兵证
     J-警官证
     R-外国公民永久居留证
     O-其他
     *
     * @return id_type - 证件类型I-居民身份证
     P-外国护照
     M-军官证
     S-港澳通行证或台胞证
     C-中国护照
     L-中国临时身份证
     H-户口本编号
     B-士兵证
     J-警官证
     R-外国公民永久居留证
     O-其他
     */
    public String getIdType() {
        return idType;
    }

    /**
     * 设置证件类型I-居民身份证
     P-外国护照
     M-军官证
     S-港澳通行证或台胞证
     C-中国护照
     L-中国临时身份证
     H-户口本编号
     B-士兵证
     J-警官证
     R-外国公民永久居留证
     O-其他
     *
     * @param idType 证件类型I-居民身份证
     P-外国护照
     M-军官证
     S-港澳通行证或台胞证
     C-中国护照
     L-中国临时身份证
     H-户口本编号
     B-士兵证
     J-警官证
     R-外国公民永久居留证
     O-其他
     */
    public void setIdType(String idType) {
        this.idType = idType == null ? null : idType.trim();
    }

    /**
     * 获取主体姓名
     *
     * @return name - 主体姓名
     */
    public String getName() {
        return name;
    }

    /**
     * 设置主体姓名
     *
     * @param name 主体姓名
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * 获取原因代码
     *
     * @return reason_code - 原因代码
     */
    public String getReasonCode() {
        return reasonCode;
    }

    /**
     * 设置原因代码
     *
     * @param reasonCode 原因代码
     */
    public void setReasonCode(String reasonCode) {
        this.reasonCode = reasonCode == null ? null : reasonCode.trim();
    }

    /**
     * 获取有效期年
     *
     * @return expires_year - 有效期年
     */
    public String getExpiresYear() {
        return expiresYear;
    }

    /**
     * 设置有效期年
     *
     * @param expiresYear 有效期年
     */
    public void setExpiresYear(String expiresYear) {
        this.expiresYear = expiresYear == null ? null : expiresYear.trim();
    }

    /**
     * 获取有效期月
     *
     * @return expires_month - 有效期月
     */
    public String getExpiresMonth() {
        return expiresMonth;
    }

    /**
     * 设置有效期月
     *
     * @param expiresMonth 有效期月
     */
    public void setExpiresMonth(String expiresMonth) {
        this.expiresMonth = expiresMonth == null ? null : expiresMonth.trim();
    }

    /**
     * 获取信用卡CVN码
     *
     * @return credit_card_cvn - 信用卡CVN码
     */
    public String getCreditCardCvn() {
        return creditCardCvn;
    }

    /**
     * 设置信用卡CVN码
     *
     * @param creditCardCvn 信用卡CVN码
     */
    public void setCreditCardCvn(String creditCardCvn) {
        this.creditCardCvn = creditCardCvn == null ? null : creditCardCvn.trim();
    }

    /**
     * 获取复用天数，默认365
     *
     * @return reuse_days - 复用天数，默认365
     */
    public String getReuseDays() {
        return reuseDays;
    }

    /**
     * 设置复用天数，默认365
     *
     * @param reuseDays 复用天数，默认365
     */
    public void setReuseDays(String reuseDays) {
        this.reuseDays = reuseDays == null ? null : reuseDays.trim();
    }

    /**
     * 获取业务描述
     *
     * @return busi_desc - 业务描述
     */
    public String getBusiDesc() {
        return busiDesc;
    }

    /**
     * 设置业务描述
     *
     * @param busiDesc 业务描述
     */
    public void setBusiDesc(String busiDesc) {
        this.busiDesc = busiDesc == null ? null : busiDesc.trim();
    }

    /**
     * 获取鉴权结果，1通过，2不通过，3未覆盖
     *
     * @return auth_result - 鉴权结果，1通过，2不通过，3未覆盖
     */
    public String getAuthResult() {
        return authResult;
    }

    /**
     * 设置鉴权结果，1通过，2不通过，3未覆盖
     *
     * @param authResult 鉴权结果，1通过，2不通过，3未覆盖
     */
    public void setAuthResult(String authResult) {
        this.authResult = authResult == null ? null : authResult.trim();
    }

    /**
     * 获取发卡行
     *
     * @return bank_name - 发卡行
     */
    public String getBankName() {
        return bankName;
    }

    /**
     * 设置发卡行
     *
     * @param bankName 发卡行
     */
    public void setBankName(String bankName) {
        this.bankName = bankName == null ? null : bankName.trim();
    }

    /**
     * 获取卡类型：贷记卡，准贷记卡，借记卡， 预付费卡
     *
     * @return card_type - 卡类型：贷记卡，准贷记卡，借记卡， 预付费卡
     */
    public String getCardType() {
        return cardType;
    }

    /**
     * 设置卡类型：贷记卡，准贷记卡，借记卡， 预付费卡
     *
     * @param cardType 卡类型：贷记卡，准贷记卡，借记卡， 预付费卡
     */
    public void setCardType(String cardType) {
        this.cardType = cardType == null ? null : cardType.trim();
    }

    /**
     * 获取错误类型
     *
     * @return er_code - 错误类型
     */
    public String getErCode() {
        return erCode;
    }

    /**
     * 设置错误类型
     *
     * @param erCode 错误类型
     */
    public void setErCode(String erCode) {
        this.erCode = erCode == null ? null : erCode.trim();
    }

    /**
     * 获取错误信息
     *
     * @return er_msg - 错误信息
     */
    public String getErMsg() {
        return erMsg;
    }

    /**
     * 设置错误信息
     *
     * @param erMsg 错误信息
     */
    public void setErMsg(String erMsg) {
        this.erMsg = erMsg == null ? null : erMsg.trim();
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
}