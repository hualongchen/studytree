package com.lemon.chen.dao.mapper;

import com.lemon.chen.dao.bean.AppUserProfilePO;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface AppUserProfilePOMapper extends Mapper<AppUserProfilePO> {


    /**
     * 使用了通用mapper,没有实现连表查询
     */


    /*@Select("select * from app_user_user_profile where user_profile_id=#{id} ")
    @Results({
            @Result(column="user_profile_id",property="userProfileId"),
            @Result(column="user_id",property="userId",
                    many=@Many(
                            select="com.lemon.chen.dao.mapper.AppUserPOMapper.findUserById",
                            fetchType= FetchType.EAGER))})
    public List<AppUserProfilePO> findById(@Param("id") int id);
*/

}