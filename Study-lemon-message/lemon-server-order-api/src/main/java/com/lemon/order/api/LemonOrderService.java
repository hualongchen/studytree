package com.lemon.order.api;

import com.lemon.core.vo.ResultVO;
import com.lemon.order.entiry.LemonOrderServiceDTO;
import com.lemon.order.exception.OrderBizException;

/**
 * @author :chenhualong
 * @Date : created in 16:20 2018/1/30
 * @Description :
 */
public interface LemonOrderService {


    /**
     * 创建一个订单
     * @return
     * @throws OrderBizException
     */
    public ResultVO createLemonOrder()throws OrderBizException;


    /**
     * 查找一个订单
     * @param orderId
     * @return
     * @throws OrderBizException
     */
    public ResultVO   findLemonOrderById(String orderId)throws OrderBizException;


    /**
     * 修改一个订单状态
     * @throws OrderBizException
     */
    public void  updateLemonOrder(String orderId)throws OrderBizException;



}
