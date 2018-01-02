package user.test;

import com.alibaba.dubbo.rpc.RpcException;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import user.api.UserInfoService;
import user.modul.UserInfoServiceDTO;
import user.modul.UserInfoServiceRequest;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.io.IOException;
import java.util.Date;
import java.util.Set;

/**
 * @author :chenhualong
 * @Date : created in 17:16 2017/12/28
 * @Description :
 */
public class ConsumerTest {


    public static void main(String[] args) {


        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext(new String[]{"dubbo-consumer.xml"});

        context.start();


        UserInfoService api = (UserInfoService)context.getBean("userService");

        UserInfoServiceRequest  request = new UserInfoServiceRequest();


        /*8
        测试数据
         */
        request.setAge(1);
        request.setBoy(true);
        request.setEmail("526769352@qq.com");
        request.setFutureTime(new Date(System.currentTimeMillis()+10000));
        request.setGirl(false);
        request.setMobilePhone("18696728764");
        request.setPastTime(new Date(System.currentTimeMillis()-10000));
        request.setUserId(2);


         try{

          UserInfoServiceDTO  dto = api.findUserByMobilePhone(request);

             System.out.println(dto.toString());

         }catch (RpcException e){

             e.printStackTrace();

             ConstraintViolationException ve = (ConstraintViolationException) e.getCause(); // 里面嵌了一个ConstraintViolationException
             Set<ConstraintViolation<?>> violations = ve.getConstraintViolations(); // 可以拿到一个验证错误详细信息的集合
             System.out.println(violations+"=====");
         }

    }
}
