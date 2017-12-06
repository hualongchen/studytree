package com.lemon.chen.service;


import com.lemon.chen.dao.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;


@Service("customUserDetailsService")
public class CustomUserDetailsService implements UserDetailsService {


    @Autowired
    private AppUserPOMapper appUserPOMapper;

    @Autowired
    private AppUserProfilePOMapper appUserProfilePOMapper;

    @Autowired
    private UserProfilePOMapper  userProfilePOMapper ;


    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String ssoId)
            throws UsernameNotFoundException {

        AppUserPO userPO = new AppUserPO();

        userPO.setSsoId(ssoId);

        List<AppUserPO> list = appUserPOMapper.select(userPO);

        if (list.size() <= 0) {

            System.out.println("User not found");
            throw new UsernameNotFoundException("Username not found");
        }

        AppUserPO user = list.get(0);
        return new org.springframework.security.core.userdetails.User(user.getSsoId(), user.getPassword(),
                user.getState().equals("Active"), true, true, true, getGrantedAuthorities(user));
    }


    private List<GrantedAuthority> getGrantedAuthorities(AppUserPO user) {
        List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();

        //找对应的权限
        AppUserProfilePO   appUserProfilePO = new AppUserProfilePO();
        appUserProfilePO.setUserId(user.getId());

        //1个用户，找出多个权限。
        List<AppUserProfilePO>   list = appUserProfilePOMapper.select(appUserProfilePO);

        //查询出权限名称
        UserProfilePO  userProfilePO = new UserProfilePO();
        userProfilePO.setId(list.get(0).getUserProfileId());


        List<UserProfilePO>  userProfilePOList  = userProfilePOMapper.select(userProfilePO);


        for (UserProfilePO userProfile : userProfilePOList) {
            System.out.println("UserProfile : " + userProfile);
            authorities.add(new SimpleGrantedAuthority("ROLE_" + userProfile.getType()));
        }
        System.out.print("authorities :" + authorities);
        return authorities;
    }
}
