package com.lemon.chen.dao.mapper;

import com.lemon.chen.dao.bean.AppUserPO;
import com.lemon.chen.dao.bean.AppUserProfilePO;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface AppUserPOMapper extends Mapper<AppUserPO> {



    //使用通用mapper，没有完全将数据返回回来。   @Select("select * from app_user where id=#{id}")
    public AppUserPO  findUserById(int id);


    @Select("select *from app_user where id=#{id}")
    public AppUserPO retrieveUserByIdAndName(@Param("id")int id);


    @Select("select *from app_user where id=#{id}")
    public AppUserPO retrieveUserByIdAndName2(AppUserPO  po);



}