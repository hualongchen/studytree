package com.lemon.user.service.impl;

import com.lemon.user.api.LemonUserService;
import com.lemon.user.service.dao.bean.LemonUserInfoPO;
import com.lemon.user.service.dao.bean.LemonUserMessagePO;
import com.lemon.user.service.dao.mapper.LemonUserInfoPOMapper;
import com.lemon.user.service.dao.mapper.LemonUserMessagePOMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author :chenhualong
 * @Date : created in 14:52 2018/1/31
 * @Description :
 */

@Service
public class LemonUserServiceImpl implements LemonUserService {


    @Resource
    private LemonUserInfoPOMapper lemonUserInfoPOMapper;

    @Resource
    private LemonUserMessagePOMapper  lemonUserMessagePOMapper ;



    @Override
    @Transactional
    public void adduserPoint(String userId,String messageId) {


        //查询是否有这个消费日志

        if(null != messageId ){

            LemonUserMessagePO  lemonUserMessagePO = new LemonUserMessagePO();
            lemonUserMessagePO.setMessageId(messageId);

            int k = lemonUserMessagePOMapper.selectCount(lemonUserMessagePO);

            if(k>0){

                return;
            }
        }

        //增加积分
        LemonUserInfoPO  lemonUserInfoPO = new LemonUserInfoPO();

        lemonUserInfoPO.setUserId(userId);

        List<LemonUserInfoPO>  list=lemonUserInfoPOMapper.select(lemonUserInfoPO);

        if(null == list  || list.size()==0){

            lemonUserInfoPO.setPoint(10);
            lemonUserInfoPOMapper.insertSelective(lemonUserInfoPO);

        }else{

            lemonUserInfoPO =  list.get(0);
            LemonUserInfoPO  lemonUserInfoPO2 = new LemonUserInfoPO();
            lemonUserInfoPO2.setPoint(lemonUserInfoPO.getPoint()+10);

            Example example  = new Example(LemonUserInfoPO.class);

            example.createCriteria().andEqualTo("userId",lemonUserInfoPO.getUserId());

            lemonUserInfoPOMapper.updateByExampleSelective(lemonUserInfoPO2,example);


        }


        //增加消费日志
        LemonUserMessagePO  lemonUserMessagePO = new LemonUserMessagePO();
        lemonUserMessagePO.setMessageId(messageId);
        lemonUserMessagePOMapper.insertSelective(lemonUserMessagePO);

    }
}
