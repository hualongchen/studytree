package com.lemon.chen.lemonstudyactiviti.service;

import com.lemon.chen.lemonstudyactiviti.bean.Person;
import org.activiti.engine.*;
import org.activiti.engine.history.HistoricActivityInstance;
import org.activiti.engine.history.HistoricProcessInstance;
import org.activiti.engine.history.HistoricTaskInstance;
import org.activiti.engine.history.HistoricVariableInstance;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.repository.ProcessDefinition;
import org.activiti.engine.runtime.Execution;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.File;
import java.io.InputStream;
import java.util.*;
import java.util.zip.ZipInputStream;

/**
 * @author :chenhualong
 * @Date : created in 11:48 2018/4/17
 * @Description :
 */

@Service
public class WorkFolwServiceImpl implements WorkFlowService {


    //管理流程定义
    @Resource
    private RepositoryService  repositoryService ;

    //执行管理，启动，推进删除流程实例等
    @Resource
    private RuntimeService  runtimeService ;

    //任务管理
    @Resource
    private TaskService  taskService ;

    //历史管理（执行完后的数据管理）
    @Resource
    private HistoryService  historyService ;

    //组织机构，角色等管理
    @Resource
    private IdentityService  identityService ;

    //可选服务，任务表单管理
    @Resource
    private FormService  formService ;

    @Resource
    private ManagementService  managementService ;



    /** 部署流程定义（从classpath）
     *
     * 使用的表： act_ge_bytearray  /存储bpmn文件和图片
     *          act_re_deployment   /流程定义部署表
     *           act_re_procdef     /流程定义数据表
     *
     * */
    @Override
    public void deploymentProcessDefinitionByClassPath(String name,String bpmn,String png) throws Exception {

        Deployment deployment = repositoryService.createDeployment()
                .name(name)
                .addClasspathResource(bpmn)
                .addClasspathResource(png)
                .deploy();

        System.out.println("完成部署，部署id:"+ deployment.getId());
        System.out.println("完成部署，部署名称:"+deployment.getName());
    }



    @Override
    public void deploymentProcessDefinitionByZip(String name ,String zip) throws Exception {

        InputStream in = this.getClass().getClassLoader().getResourceAsStream(zip);

        ZipInputStream  zipInputStream = new ZipInputStream(in);
        Deployment deployment  = repositoryService.createDeployment()
                .name(name)
                .addZipInputStream(zipInputStream)
                .deploy();

        System.out.println("完成部署，部署id:"+ deployment.getId());
        System.out.println("完成部署，部署名称:"+deployment.getName());
    }

    @Override
    public void findProcessDefinition() throws Exception {

        List<ProcessDefinition>  list = repositoryService.createProcessDefinitionQuery()
               // .deploymentId("7501")
                .orderByProcessDefinitionVersion().asc()
                .list();


        /**
         * API使用方法
         */


        /** 指定查询条件,where条件 */
        // .deploymentId(deploymentId)//使用部署对象ID查询
        // .processDefinitionId(processDefinitionId)//使用流程定义ID查询
        // .processDefinitionKey(processDefinitionKey)//使用流程定义的key查询
        // .processDefinitionNameLike(processDefinitionNameLike)//使用流程定义的名称模糊查询

        /** 排序 */
				//.orderByProcessDefinitionVersion().asc()// 按照版本的升序排列
                // .orderByProcessDefinitionName().desc()//按照流程定义的名称降序排列

                /** 返回的结果集 */
              //  .list();// 返回一个集合列表，封装流程定义
        // .singleResult();//返回惟一结果集
        // .count();//返回结果集数量
        // .listPage(firstResult, maxResults);//分页查询

        if (list != null && list.size() > 0) {
            for (ProcessDefinition pd : list) {
                System.out.println("流程定义ID:" + pd.getId());// 流程定义的key+版本+随机生成数
                System.out.println("流程定义的名称:" + pd.getName());// 对应helloworld.bpmn文件中的name属性值
                System.out.println("流程定义的key:" + pd.getKey());// 对应helloworld.bpmn文件中的id属性值
                System.out.println("流程定义的版本:" + pd.getVersion());// 当流程定义的key值相同的相同下，版本升级，默认1
                System.out.println("资源名称bpmn文件:" + pd.getResourceName());
                System.out.println("资源名称png文件:" + pd.getDiagramResourceName());
                System.out.println("部署对象ID：" + pd.getDeploymentId());
                System.out.println("#########################################################");
            }
        }


    }

    @Override
    public void findLastVersionProcessDefinition() throws Exception {

        List<ProcessDefinition> list = repositoryService.createProcessDefinitionQuery()
                .orderByProcessDefinitionVersion()
                .asc()
                .list();
        /**
         * Map<String,ProcessDefinition> map集合的key：流程定义的key map集合的value：流程定义的对象
         * map集合的特点：当map集合key值相同的情况下，后一次的值将替换前一次的值
         */
        Map<String, ProcessDefinition> map = new LinkedHashMap<String, ProcessDefinition>();
        if (list != null && list.size() > 0) {
            for (ProcessDefinition pd : list) {
                map.put(pd.getKey(), pd);
            }
        }
        List<ProcessDefinition> pdList = new ArrayList<ProcessDefinition>(map.values());
        if (pdList != null && pdList.size() > 0) {
            for (ProcessDefinition pd : pdList) {
                System.out.println("流程定义ID:" + pd.getId());// 流程定义的key+版本+随机生成数
                System.out.println("流程定义的名称:" + pd.getName());// 对应helloworld.bpmn文件中的name属性值
                System.out.println("流程定义的key:" + pd.getKey());// 对应helloworld.bpmn文件中的id属性值
                System.out.println("流程定义的版本:" + pd.getVersion());// 当流程定义的key值相同的相同下，版本升级，默认1
                System.out.println("资源名称bpmn文件:" + pd.getResourceName());
                System.out.println("资源名称png文件:" + pd.getDiagramResourceName());
                System.out.println("部署对象ID：" + pd.getDeploymentId());
                System.out.println("#########################################################");
            }
        }

    }

    @Override
    public void deleteProcessDefinition(String deploymentId) throws Exception {

        // 使用部署ID，完成删除

        //不带级联的删除 只能删除没有启动的流程，如果流程启动，就会抛出异常
       // repositoryService.deleteDeployment(deploymentId);

        //级联删除 不管流程是否启动，都能可以删除
      repositoryService.deleteDeployment(deploymentId,true);

        System.out.println("删除成功！");
    }

    @Override
    public void deleteProcessDefinitionByKey(String processDefinitionKey) throws Exception {

        // 先使用流程定义的key查询流程定义，查询出所有的版本
        List<ProcessDefinition> list = repositoryService
                .createProcessDefinitionQuery()//
                .processDefinitionKey(processDefinitionKey)// 使用流程定义的key查询
                .list();
        // 遍历，获取每个流程定义的部署ID
        if (list != null && list.size() > 0) {
            for (ProcessDefinition pd : list) {
                // 获取部署ID
                String deploymentId = pd.getDeploymentId();
               repositoryService.deleteDeployment(deploymentId,true);
            }
        }

    }

    @Override
    public void findProcessPic(String deploymentId) throws Exception {


        // 获取图片资源名称
        List<String> list = repositoryService.getDeploymentResourceNames(deploymentId);
        // 定义图片资源的名称
        String resourceName = "";
        if (list != null && list.size() > 0) {
            for (String name : list) {
                if (name.indexOf(".png") >= 0) {
                    resourceName = name;
                }
            }
        }

        // 获取图片的输入流
        InputStream in =repositoryService.getResourceAsStream(deploymentId, resourceName);

        // 将图片生成到D盘的目录下
        File file = new File("D:/" + resourceName);
        // 将输入流的图片写到D盘下
        FileUtils.copyInputStreamToFile(in, file);

        System.out.println("生成图片成功");
    }


/////////////////////////////////  以下是runtimeService///////////////////////////////////////////////////////////////

    /**
     * 使用表： act_hi_actinst
     *         act_hi_identitylink
     *         act_hi_procinst
     *         act_hi_taskinst
     *         act_ru_execution
     *         act_ru_identitylink
     *         act_ru_task
     * @param key
     * @throws Exception
     */
    @Override
    public void startProcessDefinition(String key) throws Exception {


        //默认启动最新版本的流程定义
        ProcessInstance processInstance = runtimeService.startProcessInstanceByKey(key);

        System.out.println("流程实例ID:"+processInstance.getId());//流程实例ID    101
        System.out.println("流程定义ID:"+processInstance.getProcessDefinitionId());//流程定义ID   helloworld:1:4

    }

    @Override
    public void isProcessEnd(String processInstanceId) throws Exception {

        ProcessInstance pi =runtimeService.createProcessInstanceQuery().processDefinitionId(processInstanceId).singleResult();

        if(pi==null){
            System.out.println("流程已经结束");
        }
        else{
            System.out.println("流程没有结束");
        }

    }


    /////////////////////////////////  以下是TaskService///////////////////////////////////////////////////////////////


    @Override
    public void findMyPersonalTask(String assignee) throws Exception {

        List<Task> list = taskService//与正在执行的任务管理相关的Service
                .createTaskQuery()//创建任务查询对象
                /**查询条件（where部分）*/
                .taskAssignee(assignee)//指定个人任务查询，指定办理人
//						.taskCandidateUser(candidateUser)//组任务的办理人查询
//						.processDefinitionId(processDefinitionId)//使用流程定义ID查询
//						.processInstanceId(processInstanceId)//使用流程实例ID查询
//						.executionId(executionId)//使用执行对象ID查询
                /**排序*/
                .orderByTaskCreateTime().asc()//使用创建时间的升序排列
                /**返回结果集*/
//						.singleResult()//返回惟一结果集
//						.count()//返回结果集的数量
//						.listPage(firstResult, maxResults);//分页查询
                .list();//返回列表
        if(list!=null && list.size()>0){
            for(Task task:list){
                System.out.println("任务ID:"+task.getId());
                System.out.println("任务名称:"+task.getName());
                System.out.println("任务的创建时间:"+task.getCreateTime());
                System.out.println("任务的办理人:"+task.getAssignee());
                System.out.println("流程实例ID："+task.getProcessInstanceId());
                System.out.println("执行对象ID:"+task.getExecutionId());
                System.out.println("流程定义ID:"+task.getProcessDefinitionId());
                System.out.println("########################################################");
            }
        }

    }

    @Override
    public void completeMyPersonalTask(String taskId) throws Exception {


        //完成任务的同时，设置流程变量，使用流程变量用来指定完成任务后，下一个连线，对应sequenceFlow.bpmn文件中${message=='不重要'}
        Map<String, Object> variables = new HashMap<String, Object>();
        variables.put("money", "9000");
        taskService.complete(taskId,variables);

       // taskService.complete(taskId);

        System.out.println("完成任务：任务ID："+taskId);


    }

    @Override
    public void setVariables(String taskId, HashMap variables) throws Exception {
        //任务ID
        /**一：设置流程变量，使用基本数据类型*/
//		taskService.setVariableLocal(taskId, "请假天数", 5);//与任务ID绑定
//		taskService.setVariable(taskId, "请假日期", new Date());
//		taskService.setVariable(taskId, "请假原因", "回家探亲，一起吃个饭");
        /**二：设置流程变量，使用javabean类型*/
        /**
         * 当一个javabean（实现序列号）放置到流程变量中，要求javabean的属性不能再发生变化
         *    * 如果发生变化，再获取的时候，抛出异常
         *
         * 解决方案：在Person对象中添加：
         * 		private static final long serialVersionUID = 6757393795687480331L;
         *      同时实现Serializable
         * */
        Person p = new Person();
        p.setId(20);
        p.setName("翠花");
        taskService.setVariable(taskId, "人员信息(添加固定版本)", p);

        System.out.println("设置流程变量成功！");
    }

    @Override
    public void getVariables(String taskId, HashMap variables) throws Exception {


        /**设置流程变量*/
//		runtimeService.setVariable(executionId, variableName, value)//表示使用执行对象ID，和流程变量的名称，设置流程变量的值（一次只能设置一个值）
//		runtimeService.setVariables(executionId, variables)//表示使用执行对象ID，和Map集合设置流程变量，map集合的key就是流程变量的名称，map集合的value就是流程变量的值（一次设置多个值）

//		taskService.setVariable(taskId, variableName, value)//表示使用任务ID，和流程变量的名称，设置流程变量的值（一次只能设置一个值）
//		taskService.setVariables(taskId, variables)//表示使用任务ID，和Map集合设置流程变量，map集合的key就是流程变量的名称，map集合的value就是流程变量的值（一次设置多个值）

//		runtimeService.startProcessInstanceByKey(processDefinitionKey, variables);//启动流程实例的同时，可以设置流程变量，用Map集合
//		taskService.complete(taskId, variables)//完成任务的同时，设置流程变量，用Map集合

        /**获取流程变量*/
//		runtimeService.getVariable(executionId, variableName);//使用执行对象ID和流程变量的名称，获取流程变量的值
//		runtimeService.getVariables(executionId);//使用执行对象ID，获取所有的流程变量，将流程变量放置到Map集合中，map集合的key就是流程变量的名称，map集合的value就是流程变量的值
//		runtimeService.getVariables(executionId, variableNames);//使用执行对象ID，获取流程变量的值，通过设置流程变量的名称存放到集合中，获取指定流程变量名称的流程变量的值，值存放到Map集合中

//		taskService.getVariable(taskId, variableName);//使用任务ID和流程变量的名称，获取流程变量的值
//		taskService.getVariables(taskId);//使用任务ID，获取所有的流程变量，将流程变量放置到Map集合中，map集合的key就是流程变量的名称，map集合的value就是流程变量的值
//		taskService.getVariables(taskId, variableNames);//使用任务ID，获取流程变量的值，通过设置流程变量的名称存放到集合中，获取指定流程变量名称的流程变量的值，值存放到Map集合中



        /**一：获取流程变量，使用基本数据类型*/
//		Integer days = (Integer) taskService.getVariable(taskId, "请假天数");
//		Date date = (Date) taskService.getVariable(taskId, "请假日期");
//		String resean = (String) taskService.getVariable(taskId, "请假原因");
//		System.out.println("请假天数："+days);
//		System.out.println("请假日期："+date);
//		System.out.println("请假原因："+resean);
        /**二：获取流程变量，使用javabean类型*/
        Person p = (Person)taskService.getVariable(taskId, "人员信息(添加固定版本)");
        System.out.println(p.getId()+"        "+p.getName());



    }

    @Override
    public void receiveTask(String key,String activityId) throws Exception {
        ProcessInstance pi = runtimeService.startProcessInstanceByKey(key);

        System.out.println("流程实例ID:"+pi.getId());//流程实例ID    101
        System.out.println("流程定义ID:"+pi.getProcessDefinitionId());//流程定义ID


        /**查询执行对象ID*/
        Execution execution1 =runtimeService.createExecutionQuery()
                .processInstanceId(pi.getId())//使用流程实例ID查询
                .activityId("receivetask1")//当前活动的id，对应receiveTask.bpmn文件中的活动节点id的属性值
                .singleResult();

        /**使用流程变量设置当日销售额，用来传递业务参数*/
        runtimeService.setVariable(execution1.getId(), "汇总当日销售额", 21000);

        /**向后执行一步，如果流程处于等待状态，使得流程继续执行*/
        runtimeService.signal(execution1.getId());

        /**查询执行对象ID*/
        Execution execution2 = runtimeService
                .createExecutionQuery()//创建执行对象查询
                .processInstanceId(pi.getId())//使用流程实例ID查询
                .activityId("receivetask2")//当前活动的id，对应receiveTask.bpmn文件中的活动节点id的属性值
                .singleResult();


        /**从流程变量中获取汇总当日销售额的值*/
        Integer value = (Integer)runtimeService
                .getVariable(execution2.getId(), "汇总当日销售额");
        System.out.println("给老板发送短信：金额是："+value);

        /**向后执行一步，如果流程处于等待状态，使得流程继续执行*/
        runtimeService.signal(execution2.getId());

    }


    /////////////////////////////////  以下是HistoryService///////////////////////////////////////////////////////////////
    @Override
    public void findHistoryTask(String userName) throws Exception {

        List<HistoricTaskInstance> list = historyService.createHistoricTaskInstanceQuery()
                 .taskAssignee(userName).list();

        if(list!=null && list.size()>0){
            for(HistoricTaskInstance hti:list){
                System.out.println(hti.getId()+"    "+hti.getName()+"    "+hti.getProcessInstanceId()+"   "+hti.getStartTime()+"   "+hti.getEndTime()+"   "+hti.getDurationInMillis());
                System.out.println("################################");
            }
        }


    }

    @Override
    public void findHistoryProcessInstance(String processInstanceId) throws Exception {
        HistoricProcessInstance hpi = historyService.createHistoricProcessInstanceQuery()
                .processDefinitionId(processInstanceId)
                .singleResult();

        if(null == hpi){
            System.out.println("没有查到历史记录");
        }else{

            System.out.println(hpi.getId()+"    "+hpi.getProcessDefinitionId()+"    "+hpi.getStartTime()+"    "+hpi.getEndTime()+"     "+hpi.getDurationInMillis());

        }
    }

    @Override
    public void findHistoryProcessVariables(String variableName) throws Exception {

        List<HistoricVariableInstance> list =  historyService.createHistoricVariableInstanceQuery()
                .variableName(variableName)
                .list();


        if(list!=null && list.size()>0){
            for(HistoricVariableInstance hvi:list){
                System.out.println(hvi.getId()+"   "+hvi.getProcessInstanceId()+"   "+hvi.getVariableName()+"   "+hvi.getVariableTypeName()+"    "+hvi.getValue());
                System.out.println("###############################################");
            }
        }
    }

    @Override
    public void findHistoryActiviti(String processInstanceId) throws Exception {

        List<HistoricActivityInstance> list =historyService.createHistoricActivityInstanceQuery()
                .processDefinitionId(processInstanceId)
                .orderByHistoricActivityInstanceStartTime()
                .asc()
                .list();

        if(list!=null && list.size()>0){
            for(HistoricActivityInstance hai:list){
                System.out.println(hai.getId()+"   "+hai.getProcessInstanceId()+"   "+hai.getActivityType()+"  "+hai.getStartTime()+"   "+hai.getEndTime()+"   "+hai.getDurationInMillis());
                System.out.println("#####################");
            }
        }


    }

    @Override
    public void findHistoryTask2(String processInstanceId) throws Exception {

        List<HistoricTaskInstance> list = historyService.createHistoricTaskInstanceQuery()
                .processInstanceId(processInstanceId)
                .orderByHistoricActivityInstanceId()
                .asc()
                .list();


        if(list!=null && list.size()>0){
            for(HistoricTaskInstance hti:list){
                System.out.println(hti.getId()+"    "+hti.getName()+"    "+hti.getProcessInstanceId()+"   "+hti.getStartTime()+"   "+hti.getEndTime()+"   "+hti.getDurationInMillis());
                System.out.println("################################");
            }
        }

    }


}
