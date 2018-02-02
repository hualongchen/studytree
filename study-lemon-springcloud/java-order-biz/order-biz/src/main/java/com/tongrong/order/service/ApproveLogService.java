package com.tongrong.order.service;

import com.tongrong.order.dao.mapper.ApproveLogPOMapper;
import com.tongrong.order.form.ApproveLogForm;
import com.tongrong.order.po.ApproveLogPO;
import com.tongrong.order.util.ErrorContent;
import com.tongrong.order.util.ResultVO;
import com.tongrong.order.util.exception.BusinessException;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author :chenhualong
 * @Date : created in 9:24 2018/1/16
 * @Description :
 */
@Service
public class ApproveLogService {


    @Autowired
    private ApproveLogPOMapper  approveLogPOMapper ;

    /**
     * 增加审批记录
     * @param form
     * @return
     */

    @Transactional
    public ResultVO addApproveLog(ApproveLogForm form){

        ApproveLogPO  approveLogPO = new ApproveLogPO();

        BeanUtils.copyProperties(form,approveLogPO);

        approveLogPOMapper.insertSelective(approveLogPO);

        return new ResultVO();
    }


    /**
     * 查询审批记录
     * @param orderId
     * @return
     */
    public ResultVO<List<ApproveLogPO>>  findApproveLog(String orderId){


        ApproveLogPO  approveLogPO   = new ApproveLogPO();

        approveLogPO.setOrderId(orderId);

        List<ApproveLogPO>  list = approveLogPOMapper.select(approveLogPO);

        if(null == list || list.size()==0){

            throw new BusinessException(ErrorContent.RISK_LIST_ERROR_CODE,ErrorContent.RISK_LIST_ERROR_MESSAGE);
        }
        ResultVO<List<ApproveLogPO>>  resultVO = new ResultVO<>();

        resultVO.setData(list);

        return resultVO;

    }

}
