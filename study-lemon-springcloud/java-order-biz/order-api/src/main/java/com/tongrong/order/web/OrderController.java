package com.tongrong.order.web;

import com.tongrong.order.dto.OrderInfoDTO;
import com.tongrong.order.dto.OrderResultDTO;
import com.tongrong.order.form.OrderFindForm;
import com.tongrong.order.form.OrderInfoForm;
import com.tongrong.order.po.OrderInfoPO;
import com.tongrong.order.service.OrderService;
import com.tongrong.order.util.CheckFormUtil;
import com.tongrong.order.util.ErrorContent;
import com.tongrong.order.util.ResultVO;
import com.tongrong.order.util.exception.BusinessException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @author :chenhualong
 * @Date : created in 11:47 2018/1/11
 * @Description :
 */

@RequestMapping("/order")
@RestController
public class OrderController {



    @Resource
    private OrderService orderService ;


    /**
     * 生成订单 /修改订单
     * @return
     */

    @PostMapping("/saveOrder")
    public ResultVO<OrderResultDTO>  saveOrder(OrderInfoForm form){

        return orderService.saveOrder(form);
    }


    /**
     * 通过订单号查询订单
     * @param orderId
     * @return
     */
    @PostMapping("/findOrderById")
    public ResultVO<OrderInfoPO>  findOrderById(String orderId){


        if(null == orderId || orderId.trim().length()==0 ){

            throw new BusinessException(ErrorContent.ORDER_SAVE_ORDERID_ERROR_CODE,ErrorContent.ORDER_SAVE_ORDERID_ERROR_MESSAGE);

        }

        return orderService.findOrderById(orderId);
    }


    /**
     * 通过条件查询订单号,设计到分页
     * @param
     * @return
     */
    @PostMapping("/findOrder")
    public ResultVO<OrderInfoDTO>  findOrderByUserId(OrderFindForm form){

        /**
         * 基础校验
         */
        CheckFormUtil.checkFindOrderByUserId(form);


        return orderService.findOrderByUserId(form);
    }



}
