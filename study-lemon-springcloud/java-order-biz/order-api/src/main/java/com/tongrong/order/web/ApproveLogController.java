package com.tongrong.order.web;

import com.tongrong.order.form.ApproveLogForm;
import com.tongrong.order.po.ApproveLogPO;
import com.tongrong.order.service.ApproveLogService;
import com.tongrong.order.util.CheckFormUtil;
import com.tongrong.order.util.ErrorContent;
import com.tongrong.order.util.ResultVO;
import com.tongrong.order.util.exception.BusinessException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author :chenhualong
 * @Date : created in 9:23 2018/1/16
 * @Description :
 */

@RequestMapping("/risk")
@RestController
public class ApproveLogController {


    @Resource
    private ApproveLogService approveLogService;


    /**
     * 增加审批记录
     *
     * @param form
     * @return
     */

    @PostMapping("add")
    public ResultVO addApproveLog(ApproveLogForm form) {
        /**
         * 基本属性检查
         */
        CheckFormUtil.checkAddApproveLog(form);

        return approveLogService.addApproveLog(form);
    }


    //查询审批记录


    @PostMapping("list")
    public ResultVO<List<ApproveLogPO>>  findApproveLog(String orderId){


        if(null == orderId || orderId.trim().length()==0 ){

            throw new BusinessException(ErrorContent.ORDER_SAVE_ORDERID_ERROR_CODE,ErrorContent.ORDER_SAVE_ORDERID_ERROR_MESSAGE);

        }
        return  approveLogService.findApproveLog(orderId);
    }
}

