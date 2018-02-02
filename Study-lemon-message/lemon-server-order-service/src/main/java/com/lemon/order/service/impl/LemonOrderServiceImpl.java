package com.lemon.order.service.impl;

import com.lemon.core.utils.UUIDUtil;
import com.lemon.core.vo.ResultVO;
import com.lemon.order.api.LemonOrderService;
import com.lemon.order.entiry.LemonOrderServiceDTO;
import com.lemon.order.exception.OrderBizException;
import com.lemon.order.service.dao.bean.LemonOrderInfoPO;
import com.lemon.order.service.dao.mapper.LemonOrderInfoPOMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author :chenhualong
 * @Date : created in 16:47 2018/1/30
 * @Description :
 */
@Service
public class LemonOrderServiceImpl implements LemonOrderService {



    @Resource
    private LemonOrderInfoPOMapper   lemonOrderInfoPOMapper ;



    @Override
    @Transactional
    public ResultVO<LemonOrderServiceDTO> createLemonOrder() throws OrderBizException {

        LemonOrderInfoPO  lemonOrderInfoPO  = new LemonOrderInfoPO();

        lemonOrderInfoPO.setAccount("10000");
        lemonOrderInfoPO.setOrderId(UUIDUtil.returnUUID());
        lemonOrderInfoPO.setStatus("WAIT_PAY");
        lemonOrderInfoPO.setUserId("1001");

        lemonOrderInfoPOMapper.insertSelective(lemonOrderInfoPO);

        ResultVO  resultVO = new ResultVO();

        LemonOrderInfoPO lemonOrderInfoPO2  = lemonOrderInfoPOMapper.select(lemonOrderInfoPO).get(0);

        LemonOrderServiceDTO  lemonOrderServiceDTO = new LemonOrderServiceDTO();

        BeanUtils.copyProperties(lemonOrderInfoPO2,lemonOrderServiceDTO);

        resultVO.setData(lemonOrderServiceDTO);

        return resultVO ;

    }


    @Override
    public ResultVO findLemonOrderById(String orderId) throws OrderBizException {

        LemonOrderInfoPO  lemonOrderInfoPO  = new LemonOrderInfoPO();

        lemonOrderInfoPO.setOrderId(orderId);


        List<LemonOrderInfoPO>  list  = lemonOrderInfoPOMapper.select(lemonOrderInfoPO);

        LemonOrderInfoPO  lemonOrderInfoPO2 = new LemonOrderInfoPO();
        if(null == list || list.size()==0){

                  throw new OrderBizException(1001,"没有数据");
        }

        lemonOrderInfoPO2  = lemonOrderInfoPOMapper.select(lemonOrderInfoPO).get(0);

        LemonOrderServiceDTO  lemonOrderServiceDTO = new LemonOrderServiceDTO();

        BeanUtils.copyProperties(lemonOrderInfoPO2,lemonOrderServiceDTO);

        ResultVO  resultVO = new ResultVO();

        resultVO.setData(lemonOrderServiceDTO);

        return resultVO ;
    }



    @Override
    @Transactional
    public void updateLemonOrder(String orderId) throws OrderBizException {

        //失败改成成功
        LemonOrderInfoPO  lemonOrderInfoPO  = new LemonOrderInfoPO();

        lemonOrderInfoPO.setStatus("SUCCESS_PAY");

        Example  example = new Example(LemonOrderInfoPO.class);

        example.createCriteria().andEqualTo("orderId",orderId);

        lemonOrderInfoPOMapper.updateByExampleSelective(lemonOrderInfoPO,example);

    }
}
