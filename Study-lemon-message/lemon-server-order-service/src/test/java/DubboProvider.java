/*
 * ====================================================================
 * 龙果学院： www.roncoo.com （微信公众号：RonCoo_com）
 * 超级教程系列：《微服务架构的分布式事务解决方案》视频教程
 * 讲师：吴水成（水到渠成），840765167@qq.com
 * 课程地址：http://www.roncoo.com/details/7ae3d7eddc4742f78b0548aa8bd9ccdb
 * ====================================================================
 */



import com.alibaba.fastjson.JSONObject;
import com.lemon.core.utils.UUIDUtil;
import com.lemon.core.vo.ResultVO;
import com.lemon.message.api.RpTransactionMessageService;
import com.lemon.message.entity.RpTransactionMessage;
import com.lemon.order.api.LemonOrderService;
import com.lemon.order.entiry.LemonOrderServiceDTO;
import com.lemon.order.service.dao.bean.LemonOrderInfoPO;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Date;


/**
 * 
 * @描述: 启动Dubbo服务用的MainClass.
 * @作者: WuShuicheng .
 * @创建时间: 2016-06-22,下午9:47:55 .
 * @版本: 1.0 .
 */
public class DubboProvider {
	private static final Log log = LogFactory.getLog(DubboProvider.class);

	public static void main(String[] args) {

		try {
			ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:spring/spring-context.xml");
			context.start();


			// 1.  建立订单，待支付状态

			// 2.  预发信息， 准备扣钱。

			// 3.  操作扣钱，并修改订单，为支付成功状态。

			// 4.  确认发送信息

			// 5.  增加用户积分

			// 6.  删除消息


			System.out.println("==================订单系统启动完毕=========================");

			for (int i = 0; i <30000 ; i++) {

				//1.建立订单
				LemonOrderService lemonOrderService =(LemonOrderService)context.getBean("lemonOrderServiceImpl");


				ResultVO  resultVO =lemonOrderService.createLemonOrder();

				System.out.println("========================1. 建立订单成功==================");

				//获取订单
				LemonOrderServiceDTO lemonOrderServiceDTO = (LemonOrderServiceDTO)resultVO.getData();

				System.out.println("========================2. 获取订单成功==================");

				//2. 发送信息

				RpTransactionMessageService  messageService =(RpTransactionMessageService)context.getBean("rpTransactionMessageService");

				RpTransactionMessage  rpTransactionMessage = new RpTransactionMessage();

				String messageId= UUIDUtil.returnUUID();

				lemonOrderServiceDTO.setMessageId(messageId);
				rpTransactionMessage.setMessageId(messageId);
				rpTransactionMessage.setMessageBody(JSONObject.toJSONString(lemonOrderServiceDTO));
				rpTransactionMessage.setConsumerQueue("积分队列");
				rpTransactionMessage.setVersion(0);
				rpTransactionMessage.setId(UUIDUtil.returnUUID());
				rpTransactionMessage.setCreater("lemon");
				rpTransactionMessage.setStatus("WAIT_PAY");
				rpTransactionMessage.setCreateTime(new Date());
				rpTransactionMessage.setField1(lemonOrderServiceDTO.getOrderId());

				messageService.saveMessageWaitingConfirm(rpTransactionMessage);


				System.out.println("========================3. 预发送信息成功==================");

				//3.默认去支付成功
				Thread.sleep(1000);

				//3.1 假装几个单子异常


				//4. 修改订单成功状态

				lemonOrderService.updateLemonOrder(lemonOrderServiceDTO.getOrderId());

				System.out.println("========================4. 本地事务成功==================");

				//5. 发送成功信息

				messageService.confirmAndSendMessage(messageId);

				//6. 监听调用信息，进行修改和删除

				System.out.println("=======================6. 发送成功消息成功==================");

			}

		} catch (Exception e) {
			log.error("== DubboProvider context start error:", e);
		}

		synchronized (DubboProvider.class) {
			while (true) {
				try {
					DubboProvider.class.wait();
				} catch (InterruptedException e) {
					log.error("== synchronized error:", e);
				}
			}
		}
	}

}