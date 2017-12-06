package com.lemon.chen.dao;

import javax.persistence.*;

@Table(name = "app_user_user_profile")
public class AppUserProfilePO {
    @Id
    @Column(name = "user_id")
    private Long userId;

    @Id
    @Column(name = "user_profile_id")
    private Long userProfileId;

    /**
     * @return user_id
     */
    public Long getUserId() {
        return userId;
    }

    /**
     * @param userId
     */
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    /**
     * @return user_profile_id
     */
    public Long getUserProfileId() {
        return userProfileId;
    }

    /**
     * @param userProfileId
     */
    public void setUserProfileId(Long userProfileId) {
        this.userProfileId = userProfileId;
    }
}