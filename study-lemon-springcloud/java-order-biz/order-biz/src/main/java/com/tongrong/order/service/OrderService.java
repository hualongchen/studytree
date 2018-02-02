package com.tongrong.order.service;

import com.github.pagehelper.PageHelper;
import com.tongrong.order.dao.mapper.OrderInfoPOMapper;
import com.tongrong.order.dao.mapper.OrderOperatePOMapper;
import com.tongrong.order.dto.OrderInfoDTO;
import com.tongrong.order.dto.OrderResultDTO;
import com.tongrong.order.form.OrderFindForm;
import com.tongrong.order.form.OrderInfoForm;
import com.tongrong.order.po.OrderInfoPO;
import com.tongrong.order.po.OrderOperatePO;
import com.tongrong.order.util.CheckFormUtil;
import com.tongrong.order.util.ErrorContent;
import com.tongrong.order.util.ResultVO;
import com.tongrong.order.util.exception.BusinessException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import java.util.List;
import java.util.UUID;

/**
 * @author :chenhualong
 * @Date : created in 15:10 2018/1/16
 * @Description :
 */

@Slf4j
@Service
public class OrderService {


    @Resource
    private OrderInfoPOMapper orderInfoPOMapper;

    @Resource
    private OrderOperatePOMapper orderOperatePOMapper;

    /**
     * 保存订单
     *
     * @param form
     * @return
     */

    @Transactional
    public ResultVO<OrderResultDTO> saveOrder(OrderInfoForm form) {

        OrderResultDTO orderResultDTO = new OrderResultDTO();
        //新增订单
        if (null == form.getOrderId()) {

            CheckFormUtil.checkSaveOrder(form);
            //看是否有完结的订单
            OrderInfoPO orderInfoPO = new OrderInfoPO();
            Example example = new Example(OrderInfoPO.class);

            example.createCriteria().andEqualTo("userId",form.getUserId()).andLessThan("orderStatus", 6);

            List<OrderInfoPO> list = orderInfoPOMapper.selectByExample(example);

            if (null == list || list.size() == 0) {
                //增加订单
                orderInfoPO = new OrderInfoPO();
                //生成订单ID
                String orderId = UUID.randomUUID().toString().replaceAll("-", "");
                form.setOrderId(orderId);
                BeanUtils.copyProperties(form, orderInfoPO);
                orderInfoPOMapper.insertSelective(orderInfoPO);

                //增加日志
                orderResultDTO.setOrderId(orderId);
                addOrderLog(orderId,form.getOperateName(),"【增加订单】:"+orderInfoPO.toString());


            } else {

                //有未完成的订单，不允许再申请
                throw new BusinessException(ErrorContent.ORDER_SAVE_HASORDER_ERROR_CODE,ErrorContent.ORDER_SAVE_HASORDER_ERROR_MESSAGE);
            }


        } else {

            //修改订单
            CheckFormUtil.checkUpdateOrder(form);
            OrderInfoPO orderInfoPO = new OrderInfoPO();
            BeanUtils.copyProperties(form, orderInfoPO);
            Example example = new Example(OrderInfoPO.class);

            example.createCriteria().andEqualTo("orderId", form.getOrderId());

            orderInfoPOMapper.updateByExampleSelective(orderInfoPO, example);

            //增加日志
            orderResultDTO.setOrderId(form.getOrderId());
            addOrderLog(form.getOrderId(),form.getOperateName(),"【修改订单】:"+orderInfoPO.toString());

        }

        ResultVO<OrderResultDTO> resultVO = new ResultVO<>();

        resultVO.setData(orderResultDTO);

        return resultVO;
    }


    /**
     * 通过订单ID查询订单
     *
     * @param orderId
     * @return
     */
    public ResultVO<OrderInfoPO> findOrderById(String orderId) {

        OrderInfoPO orderInfoPO = new OrderInfoPO();

        orderInfoPO.setOrderId(orderId);

        List<OrderInfoPO> list = orderInfoPOMapper.select(orderInfoPO);

        if (null == list || list.size() == 0) {

            throw new BusinessException(ErrorContent.ORDER_SAVE_LIST_ERROR_CODE,ErrorContent.ORDER_SAVE_LIST_ERROR_MESSAGE);
        }

        ResultVO<OrderInfoPO> resultVO = new ResultVO<>();
        resultVO.setData(list.get(0));

        return resultVO;

    }


    //倒序查询订单列表
    public ResultVO<OrderInfoDTO> findOrderByUserId(OrderFindForm form) {


        //根据条件查询

        Example  example = new Example(OrderInfoPO.class);

        example.setOrderByClause("id desc");

         Example.Criteria  criteria= example.createCriteria();

         //用户ID
        if(null !=form.getUserId() && form.getUserId()!=0){

            criteria.andEqualTo("userId",form.getUserId());
        }

        //用户姓名
        if(null != form.getName() && form.getName().trim().length()>0){

            criteria.andEqualTo("name",form.getName());
        }
        //订单大状态
        if(form.getOrderStatus()>0){

            criteria.andEqualTo("orderStatus",form.getOrderStatus());

        }
        //小状态
        if(form.getInsideOrderStatus()>0){
            criteria.andEqualTo("insideOrderStatus",form.getInsideOrderStatus());
        }

        //总数
        int count = orderInfoPOMapper.selectCountByExample(example);


        //必须分页

        int totalPage= 0;

        if(count%form.getLimit()==0 ){

            totalPage=count / form.getLimit();
        }else{

            totalPage=count / form.getLimit() +1 ;
        }

        if(form.getPage()>=totalPage){

            form.setPage(totalPage);
        }

        int offset =(form.getPage() - 1) * form.getLimit();

        PageHelper.offsetPage(offset, form.getLimit());

        List<OrderInfoPO>  list = orderInfoPOMapper.selectByExample(example);


        ResultVO<OrderInfoDTO>  resultVO = new ResultVO<>();

        OrderInfoDTO  orderInfoDTO = new OrderInfoDTO();

        orderInfoDTO.setList(list);
        orderInfoDTO.setPage(form.getPage());
        orderInfoDTO.setCount(count);

        if(form.getPage()>=totalPage){

            orderInfoDTO.setNextPage(totalPage);
        }else{
            orderInfoDTO.setNextPage(form.getPage()+1);
        }

        resultVO.setData(orderInfoDTO);

        return resultVO;
    }


    /**
     * 增加订单的日志
     * @param orderId
     * @param operateName
     * @param text
     */

    @Transactional
    public void addOrderLog(String orderId,String operateName,String text){


        try {

            OrderOperatePO   orderOperatePO  = new OrderOperatePO();

            orderOperatePO.setOrderId(orderId);
            orderOperatePO.setOperateName(operateName);
            orderOperatePO.setOperateText(text);

            orderOperatePOMapper.insertSelective(orderOperatePO);

        }catch (Exception  ex){
            ex.printStackTrace();
            log.error(ex.getMessage());
        }
    }



}
