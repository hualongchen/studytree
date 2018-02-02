package com.tongrong.order.po;

import javax.persistence.*;
import java.util.Date;

@Table(name = "approve_log_info")
public class ApproveLogPO {
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
     * 环节
     */
    private String link;

    /**
     * 操作者
     */
    @Column(name = "operate_name")
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
     * 获取环节
     *
     * @return link - 环节
     */
    public String getLink() {
        return link;
    }

    /**
     * 设置环节
     *
     * @param link 环节
     */
    public void setLink(String link) {
        this.link = link == null ? null : link.trim();
    }

    /**
     * 获取操作者
     *
     * @return operate_name - 操作者
     */
    public String getOperateName() {
        return operateName;
    }

    /**
     * 设置操作者
     *
     * @param operateName 操作者
     */
    public void setOperateName(String operateName) {
        this.operateName = operateName == null ? null : operateName.trim();
    }

    /**
     * 获取操作
     *
     * @return operate - 操作
     */
    public String getOperate() {
        return operate;
    }

    /**
     * 设置操作
     *
     * @param operate 操作
     */
    public void setOperate(String operate) {
        this.operate = operate == null ? null : operate.trim();
    }

    /**
     * 获取处理意见
     *
     * @return result - 处理意见
     */
    public String getResult() {
        return result;
    }

    /**
     * 设置处理意见
     *
     * @param result 处理意见
     */
    public void setResult(String result) {
        this.result = result == null ? null : result.trim();
    }

    /**
     * 获取注册时间
     *
     * @return create_time - 注册时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 设置注册时间
     *
     * @param createTime 注册时间
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
        return "ApproveLogPO{" +
                "id=" + id +
                ", orderId='" + orderId + '\'' +
                ", link='" + link + '\'' +
                ", operateName='" + operateName + '\'' +
                ", operate='" + operate + '\'' +
                ", result='" + result + '\'' +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                ", field1='" + field1 + '\'' +
                ", field2='" + field2 + '\'' +
                ", field3='" + field3 + '\'' +
                '}';
    }
}