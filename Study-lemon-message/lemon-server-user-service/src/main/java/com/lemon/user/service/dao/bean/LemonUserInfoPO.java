package com.lemon.user.service.dao.bean;

import java.util.Date;
import javax.persistence.*;

@Table(name = "lemon_user_info")
public class LemonUserInfoPO {
    /**
     * 主键自增ID
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 用户的ID
     */
    @Column(name = "user_id")
    private String userId;

    /**
     * 积分项
     */
    private Integer point;

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
     * 获取用户的ID
     *
     * @return user_id - 用户的ID
     */
    public String getUserId() {
        return userId;
    }

    /**
     * 设置用户的ID
     *
     * @param userId 用户的ID
     */
    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    /**
     * 获取积分项
     *
     * @return point - 积分项
     */
    public Integer getPoint() {
        return point;
    }

    /**
     * 设置积分项
     *
     * @param point 积分项
     */
    public void setPoint(Integer point) {
        this.point = point;
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