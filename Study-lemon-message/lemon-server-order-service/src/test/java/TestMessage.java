import com.alibaba.fastjson.JSONObject;
import com.lemon.core.utils.UUIDUtil;
import com.lemon.core.vo.ResultVO;
import com.lemon.message.api.RpTransactionMessageService;
import com.lemon.message.entity.RpTransactionMessage;
import com.lemon.order.api.LemonOrderService;
import com.lemon.order.entiry.LemonOrderServiceDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Date;

/**
 * @author :chenhualong
 * @Date : created in 11:14 2018/2/1
 * @Description :
 */

@Slf4j
public class TestMessage {


    public static void main(String[] args) {



        try {
            ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:spring/spring-context.xml");



            // 1.  建立订单，待支付状态

            // 2.  预发信息， 准备扣钱。

            // 3.  操作扣钱，并修改订单，为支付成功状态。

            // 4.  确认发送信息

            // 5.  增加用户积分

            // 6.  删除消息


            for (int i = 0; i <30000 ; i++) {

                //1.建立订单
                LemonOrderService lemonOrderService =(LemonOrderService)context.getBean("lemonOrderServiceImpl");

                ResultVO resultVO =lemonOrderService.createLemonOrder();

                //获取订单
                LemonOrderServiceDTO lemonOrderServiceDTO = (LemonOrderServiceDTO)resultVO.getData();

                //2. 发送信息

                RpTransactionMessageService messageService =(RpTransactionMessageService)context.getBean("rpTransactionMessageService");

                RpTransactionMessage rpTransactionMessage = new RpTransactionMessage();

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

                //3.默认去支付成功
                Thread.sleep(2000);

                //3.1 假装几个单子异常

                if(i>5 && i<7){

                    continue;
                }

                //4. 修改订单成功状态

                lemonOrderService.updateLemonOrder(lemonOrderServiceDTO.getOrderId());

                //5. 发送成功信息

                messageService.confirmAndSendMessage(messageId);

                //6. 监听调用信息，进行修改和删除

                System.out.println("I 为： " + i+"__ 的工程已经完成");

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
