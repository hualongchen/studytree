package com.lemon.chen.lemonstudyactiviti;

import com.lemon.chen.lemonstudyactiviti.service.WorkFlowService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

/**
 * @author :chenhualong
 * @Date : created in 14:16 2018/4/17
 * @Description :
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class WorkFlowServiceTest {


    @Resource
    private WorkFlowService  workFlowService ;


    @Test
    public void  test()throws Exception{


        //部署流程
       // workFlowService.deploymentProcessDefinitionByClassPath("排他网关","bpmn/exclusiveGateWay.bpmn","bpmn/exclusiveGateWay.png");

        //查询流程
       // workFlowService.findProcessDefinition();
       //  workFlowService.findLastVersionProcessDefinition();


        //删除流程
       // workFlowService.deleteProcessDefinition("7501");

        //下载流程图片
       // workFlowService.findProcessPic("7501");

//#######################################################################################################################

        //   启动流程定义
       // workFlowService.startProcessDefinition("exclusiveGateWay");

        //查看流程是否结束
        workFlowService.isProcessEnd("32504");

//#######################################################################################################################

        //查找个人任务
       // workFlowService.findMyPersonalTask("李四");

        //完成任务
       // workFlowService.completeMyPersonalTask("32504");


//#######################################################################################################################

        //查询历史任务
       // workFlowService.findHistoryTask("张三");

        //查询历史流程
       // workFlowService.findHistoryProcessInstance("17501");


    }
}
