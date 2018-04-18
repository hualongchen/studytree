package com.lemon.chen.lemonstudyactiviti.service;

import java.util.HashMap;

/**
 * @author :chenhualong
 * @Date : created in 11:18 2018/4/17
 * @Description :
 */
public interface WorkFlowService {


    //############################################  RepositoryService   ###################################

    /**
     * 根据路径部署流程
     *
     * @throws Exception
     */
    public void deploymentProcessDefinitionByClassPath(String name, String bpmn, String png) throws Exception;


    /**
     * 根据ZIP文件流进行部署流程
     *
     * @throws Exception
     */
    public void deploymentProcessDefinitionByZip(String name, String zip) throws Exception;


    /**
     * 查询流程定义
     *
     * @throws Exception
     */
    public void findProcessDefinition() throws Exception;


    /**
     * 查询最新版本的流程定义
     *
     * @throws Exception
     */
    public void findLastVersionProcessDefinition() throws Exception;

    /**
     * 删除流程定义
     *
     * @throws Exception
     */
    public void deleteProcessDefinition(String deploymentId) throws Exception;


    /**
     * 删除流程定义（删除key相同的所有不同版本的流程定义）
     *
     * @throws Exception
     */
    public void deleteProcessDefinitionByKey(String processDefinitionKey) throws Exception;

    /**
     * 查看流程图
     *
     * @throws Exception
     */
    public void findProcessPic(String deploymentId) throws Exception;


    //############################################  RunTimeService   ###################################

    /**
     * 启动流程
     *
     * @throws Exception
     */
    public void startProcessDefinition(String key) throws Exception;


    /**
     * 查看流程状态
     * @param processInstanceId
     * @throws Exception
     */
    public void isProcessEnd(String processInstanceId)throws Exception;


    //############################################  TaskService   ###################################

    /**
     * 查看个人任务
     *
     * @param userName
     * @throws Exception
     */
    public void findMyPersonalTask(String userName) throws Exception;


    /**
     * 完成自己的任务
     * @param taskId
     * @throws Exception
     */
    public void completeMyPersonalTask(String taskId)throws Exception;


    /**
     * 设置流程变量
     * @param taskId
     * @param variables
     * @throws Exception
     */
    public void setVariables(String taskId, HashMap variables)throws Exception;


    /**
     * 获取流程变量
     * @param taskId
     * @param variables
     * @throws Exception
     */
    public void getVariables(String taskId,HashMap variables)throws Exception;


    /**
     * 启动流程实例+设置流程变量+获取流程变量+向后执行一步
     * @param activityId
     * @throws Exception
     */
    public void receiveTask(String key,String activityId)throws Exception;

    //############################################  HistroyService   #################################

    /**
     * 查找历史个人任务
     * @param userName
     * @throws Exception
     */
    public void findHistoryTask(String userName)throws Exception;


    /**
     * 查找历史流程
     * @param processInstanceId
     * @throws Exception
     */
    public void findHistoryProcessInstance(String processInstanceId)throws Exception;

    /**
     * 查询流程变量的历史表
     * @param variableName
     * @throws Exception
     */
    public void findHistoryProcessVariables(String variableName)throws Exception;


    /**
     * 查询历史活动
     * @param processInstanceId
     * @throws Exception
     */
    public void findHistoryActiviti(String processInstanceId)throws Exception;


    /**
     * 查询历史任务
     * @throws Exception
     */
    public void findHistoryTask2(String processInstanceId)throws Exception;


}
