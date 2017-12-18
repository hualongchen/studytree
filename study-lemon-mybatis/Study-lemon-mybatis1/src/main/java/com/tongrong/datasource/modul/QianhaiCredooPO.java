package com.tongrong.datasource.modul;

import java.util.Date;
import javax.persistence.*;

@Table(name = "datasource_qianhai_credoo")
public class QianhaiCredooPO {
    /**
     * 主键自增ID
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

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
     * 卡号
     */
    @Column(name = "card_no")
    private String cardNo;

    /**
     * 手机号
     */
    @Column(name = "mobile_no")
    private String mobileNo;

    /**
     * 序列号，本次唯一
     */
    @Column(name = "seq_no")
    private String seqNo;

    /**
     * 来源代码：1-金融机构
     */
    @Column(name = "source_id")
    private String sourceId;

    /**
     * 综合评分
     */
    @Column(name = "credoo_score")
    private String credooScore;

    /**
     * 身份特征
     */
    @Column(name = "bse_info_score")
    private String bseInfoScore;

    /**
     * 履约能力
     */
    @Column(name = "fin_require_score")
    private String finRequireScore;

    /**
     * 失信风险
     */
    @Column(name = "pay_ability_score")
    private String payAbilityScore;

    /**
     * 消费偏好
     */
    @Column(name = "perform_score")
    private String performScore;

    /**
     * 行为特征
     */
    @Column(name = "action_score")
    private String actionScore;

    /**
     * 社交信用
     */
    @Column(name = "vir_asset_score")
    private String virAssetScore;

    /**
     * 成长潜力
     */
    @Column(name = "trend_score")
    private String trendScore;

    /**
     * 业务发生时间yyyy-MM-dd hh:mm:ss
     */
    @Column(name = "data_buildtime")
    private String dataBuildtime;

    /**
     * 错误类型
     */
    @Column(name = "er_code")
    private String erCode;

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
     * 邮箱
     */
    private String email;

    /**
     * 微博号
     */
    @Column(name = "weibo_no")
    private String weiboNo;

    /**
     * 微信号
     */
    @Column(name = "weixin_no")
    private String weixinNo;

    /**
     * QQ号
     */
    @Column(name = "qq_no")
    private String qqNo;

    /**
     * 淘宝号
     */
    @Column(name = "taobao_no")
    private String taobaoNo;

    /**
     * 京东号
     */
    @Column(name = "jd_no")
    private String jdNo;

    /**
     * 亚马逊号
     */
    @Column(name = "amazon_no")
    private String amazonNo;

    /**
     * 一号店号
     */
    @Column(name = "yhd_no")
    private String yhdNo;

    /**
     * 获取主键自增ID
     *
     * @return id - 主键自增ID
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置主键自增ID
     *
     * @param id 主键自增ID
     */
    public void setId(Integer id) {
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
     * 获取卡号
     *
     * @return card_no - 卡号
     */
    public String getCardNo() {
        return cardNo;
    }

    /**
     * 设置卡号
     *
     * @param cardNo 卡号
     */
    public void setCardNo(String cardNo) {
        this.cardNo = cardNo == null ? null : cardNo.trim();
    }

    /**
     * 获取手机号
     *
     * @return mobile_no - 手机号
     */
    public String getMobileNo() {
        return mobileNo;
    }

    /**
     * 设置手机号
     *
     * @param mobileNo 手机号
     */
    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo == null ? null : mobileNo.trim();
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
     * 获取来源代码：1-金融机构
     *
     * @return source_id - 来源代码：1-金融机构
     */
    public String getSourceId() {
        return sourceId;
    }

    /**
     * 设置来源代码：1-金融机构
     *
     * @param sourceId 来源代码：1-金融机构
     */
    public void setSourceId(String sourceId) {
        this.sourceId = sourceId == null ? null : sourceId.trim();
    }

    /**
     * 获取综合评分
     *
     * @return credoo_score - 综合评分
     */
    public String getCredooScore() {
        return credooScore;
    }

    /**
     * 设置综合评分
     *
     * @param credooScore 综合评分
     */
    public void setCredooScore(String credooScore) {
        this.credooScore = credooScore == null ? null : credooScore.trim();
    }

    /**
     * 获取身份特征
     *
     * @return bse_info_score - 身份特征
     */
    public String getBseInfoScore() {
        return bseInfoScore;
    }

    /**
     * 设置身份特征
     *
     * @param bseInfoScore 身份特征
     */
    public void setBseInfoScore(String bseInfoScore) {
        this.bseInfoScore = bseInfoScore == null ? null : bseInfoScore.trim();
    }

    /**
     * 获取履约能力
     *
     * @return fin_require_score - 履约能力
     */
    public String getFinRequireScore() {
        return finRequireScore;
    }

    /**
     * 设置履约能力
     *
     * @param finRequireScore 履约能力
     */
    public void setFinRequireScore(String finRequireScore) {
        this.finRequireScore = finRequireScore == null ? null : finRequireScore.trim();
    }

    /**
     * 获取失信风险
     *
     * @return pay_ability_score - 失信风险
     */
    public String getPayAbilityScore() {
        return payAbilityScore;
    }

    /**
     * 设置失信风险
     *
     * @param payAbilityScore 失信风险
     */
    public void setPayAbilityScore(String payAbilityScore) {
        this.payAbilityScore = payAbilityScore == null ? null : payAbilityScore.trim();
    }

    /**
     * 获取消费偏好
     *
     * @return perform_score - 消费偏好
     */
    public String getPerformScore() {
        return performScore;
    }

    /**
     * 设置消费偏好
     *
     * @param performScore 消费偏好
     */
    public void setPerformScore(String performScore) {
        this.performScore = performScore == null ? null : performScore.trim();
    }

    /**
     * 获取行为特征
     *
     * @return action_score - 行为特征
     */
    public String getActionScore() {
        return actionScore;
    }

    /**
     * 设置行为特征
     *
     * @param actionScore 行为特征
     */
    public void setActionScore(String actionScore) {
        this.actionScore = actionScore == null ? null : actionScore.trim();
    }

    /**
     * 获取社交信用
     *
     * @return vir_asset_score - 社交信用
     */
    public String getVirAssetScore() {
        return virAssetScore;
    }

    /**
     * 设置社交信用
     *
     * @param virAssetScore 社交信用
     */
    public void setVirAssetScore(String virAssetScore) {
        this.virAssetScore = virAssetScore == null ? null : virAssetScore.trim();
    }

    /**
     * 获取成长潜力
     *
     * @return trend_score - 成长潜力
     */
    public String getTrendScore() {
        return trendScore;
    }

    /**
     * 设置成长潜力
     *
     * @param trendScore 成长潜力
     */
    public void setTrendScore(String trendScore) {
        this.trendScore = trendScore == null ? null : trendScore.trim();
    }

    /**
     * 获取业务发生时间yyyy-MM-dd hh:mm:ss
     *
     * @return data_buildtime - 业务发生时间yyyy-MM-dd hh:mm:ss
     */
    public String getDataBuildtime() {
        return dataBuildtime;
    }

    /**
     * 设置业务发生时间yyyy-MM-dd hh:mm:ss
     *
     * @param dataBuildtime 业务发生时间yyyy-MM-dd hh:mm:ss
     */
    public void setDataBuildtime(String dataBuildtime) {
        this.dataBuildtime = dataBuildtime == null ? null : dataBuildtime.trim();
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
     * @return er_msg
     */
    public String getErMsg() {
        return erMsg;
    }

    /**
     * @param erMsg
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

    /**
     * 获取邮箱
     *
     * @return email - 邮箱
     */
    public String getEmail() {
        return email;
    }

    /**
     * 设置邮箱
     *
     * @param email 邮箱
     */
    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    /**
     * 获取微博号
     *
     * @return weibo_no - 微博号
     */
    public String getWeiboNo() {
        return weiboNo;
    }

    /**
     * 设置微博号
     *
     * @param weiboNo 微博号
     */
    public void setWeiboNo(String weiboNo) {
        this.weiboNo = weiboNo == null ? null : weiboNo.trim();
    }

    /**
     * 获取微信号
     *
     * @return weixin_no - 微信号
     */
    public String getWeixinNo() {
        return weixinNo;
    }

    /**
     * 设置微信号
     *
     * @param weixinNo 微信号
     */
    public void setWeixinNo(String weixinNo) {
        this.weixinNo = weixinNo == null ? null : weixinNo.trim();
    }

    /**
     * 获取QQ号
     *
     * @return qq_no - QQ号
     */
    public String getQqNo() {
        return qqNo;
    }

    /**
     * 设置QQ号
     *
     * @param qqNo QQ号
     */
    public void setQqNo(String qqNo) {
        this.qqNo = qqNo == null ? null : qqNo.trim();
    }

    /**
     * 获取淘宝号
     *
     * @return taobao_no - 淘宝号
     */
    public String getTaobaoNo() {
        return taobaoNo;
    }

    /**
     * 设置淘宝号
     *
     * @param taobaoNo 淘宝号
     */
    public void setTaobaoNo(String taobaoNo) {
        this.taobaoNo = taobaoNo == null ? null : taobaoNo.trim();
    }

    /**
     * 获取京东号
     *
     * @return jd_no - 京东号
     */
    public String getJdNo() {
        return jdNo;
    }

    /**
     * 设置京东号
     *
     * @param jdNo 京东号
     */
    public void setJdNo(String jdNo) {
        this.jdNo = jdNo == null ? null : jdNo.trim();
    }

    /**
     * 获取亚马逊号
     *
     * @return amazon_no - 亚马逊号
     */
    public String getAmazonNo() {
        return amazonNo;
    }

    /**
     * 设置亚马逊号
     *
     * @param amazonNo 亚马逊号
     */
    public void setAmazonNo(String amazonNo) {
        this.amazonNo = amazonNo == null ? null : amazonNo.trim();
    }

    /**
     * 获取一号店号
     *
     * @return yhd_no - 一号店号
     */
    public String getYhdNo() {
        return yhdNo;
    }

    /**
     * 设置一号店号
     *
     * @param yhdNo 一号店号
     */
    public void setYhdNo(String yhdNo) {
        this.yhdNo = yhdNo == null ? null : yhdNo.trim();
    }
}