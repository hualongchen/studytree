/*
 * ====================================================================
 * 龙果学院： www.roncoo.com （微信公众号：RonCoo_com）
 * 超级教程系列：《微服务架构的分布式事务解决方案》视频教程
 * 讲师：吴水成（水到渠成），840765167@qq.com
 * 课程地址：http://www.roncoo.com/course/view/7ae3d7eddc4742f78b0548aa8bd9ccdb
 * ====================================================================
 */
package com.lemon.queue.listener;

import javax.jms.Message;
import javax.jms.Session;

import com.lemon.core.exception.BizException;
import com.lemon.message.api.RpTransactionMessageService;
import com.lemon.order.entiry.LemonOrderServiceDTO;
import com.lemon.user.api.LemonUserService;
import org.apache.activemq.command.ActiveMQTextMessage;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.listener.SessionAwareMessageListener;

import com.alibaba.fastjson.JSONObject;
import org.springframework.stereotype.Component;


@Component("accountingMessageListener")
public class AccountingMessageListener implements SessionAwareMessageListener<Message> {

	private static final Log LOG = LogFactory.getLog(AccountingMessageListener.class);

	/**
	 * 积分队列模板(由Spring创建并注入进来)
	 */
	@Autowired
	private JmsTemplate notifyJmsTemplate;
	@Autowired
	private LemonUserService  lemonUserService ;
	@Autowired
	private RpTransactionMessageService rpTransactionMessageService;


	public synchronized void onMessage(Message message, Session session) {


		LemonOrderServiceDTO  lemonOrderServiceDTO = null;
		String strMessage = null;

		try {
			ActiveMQTextMessage objectMessage = (ActiveMQTextMessage) message;
			strMessage = objectMessage.getText();
			LOG.info("strMessage1 user:" + strMessage);
			lemonOrderServiceDTO = JSONObject.parseObject(strMessage, LemonOrderServiceDTO.class); // 这里转换成相应的对象还有问题
			if (lemonOrderServiceDTO == null) {
				LOG.info("lemonOrderServiceDTO参数为空");
				return;
			}


			/**
			 * 校验  dto里面的所有属性。 然后入库
			 */

            lemonUserService.adduserPoint(lemonOrderServiceDTO.getUserId(),lemonOrderServiceDTO.getMessageId());


			System.out.println("-------------开始删除消息----------------"   + lemonOrderServiceDTO.getMessageId());

			//删除消息
			rpTransactionMessageService.deleteMessageByMessageId(lemonOrderServiceDTO.getMessageId());

		} catch (BizException e) {
			// 业务异常，不再写会队列
			LOG.error("==>BizException", e);
		} catch (Exception e) {
			// 不明异常不再写会队列
			LOG.error("==>Exception", e);
		}
	}


	public JmsTemplate getNotifyJmsTemplate() {
		return notifyJmsTemplate;
	}


	public void setNotifyJmsTemplate(JmsTemplate notifyJmsTemplate) {
		this.notifyJmsTemplate = notifyJmsTemplate;
	}


	public LemonUserService getLemonUserService() {
		return lemonUserService;
	}

	public void setLemonUserService(LemonUserService lemonUserService) {
		this.lemonUserService = lemonUserService;
	}

	public RpTransactionMessageService getRpTransactionMessageService() {
		return rpTransactionMessageService;
	}

	public void setRpTransactionMessageService(RpTransactionMessageService rpTransactionMessageService) {
		this.rpTransactionMessageService = rpTransactionMessageService;
	}
}
