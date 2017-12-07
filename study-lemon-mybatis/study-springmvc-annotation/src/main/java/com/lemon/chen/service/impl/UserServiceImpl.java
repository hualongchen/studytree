package com.lemon.chen.service.impl;

import com.github.pagehelper.PageHelper;
import com.lemon.chen.dao.bean.AppUserPO;
import com.lemon.chen.dao.mapper.AppUserPOMapper;
import com.lemon.chen.dao.mapper.AppUserProfilePOMapper;
import com.lemon.chen.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;
import tk.mybatis.mapper.entity.Example.Criteria;

import java.util.List;


@Service
public class UserServiceImpl implements UserService {


    @Autowired
    private AppUserPOMapper appUserPOMapper;

    @Autowired
    private AppUserProfilePOMapper  appUserProfilePOMapper ;


    /**
     * 单表查询
     */
    @Override
    public Object findUser() {


         //  简单使用bean进行查询
        AppUserPO  appUserPO = new AppUserPO();

        appUserPO.setId(1L);

        List<AppUserPO> list =appUserPOMapper.select(appUserPO);

        System.out.println(list.get(0).toString());

        //使用帮助类查询，排序等操作

        Example  example = new Example(AppUserPO.class);


        //排重
        example.setDistinct(true);

        //排序
        example.setOrderByClause("'id' DESC");

        Criteria criteria =example.createCriteria();

        if(appUserPO.getId()>= 0){

            criteria.andEqualTo("id",appUserPO.getId());
        }

        System.out.println("通过example查询："+appUserPOMapper.selectByExample(example));


        //分页

        PageHelper.offsetPage(1,3);

        System.out.println("通过分页查询"+ appUserPOMapper.selectAll().size());


        //尝试调用注解类

        System.out.println("调用注解1："+ appUserPOMapper.findUserById(1));

        System.out.println("掉用注解2：" +appUserPOMapper.retrieveUserByIdAndName(1));

        System.out.println("调用注解3："+appUserPOMapper.retrieveUserByIdAndName2(appUserPO));

        return  list.get(0);

    }

    @Override
    public Object findUserAndProfile() {


        //联合查询

        return  null ;//appUserProfilePOMapper.findById(1) ;
    }
}
