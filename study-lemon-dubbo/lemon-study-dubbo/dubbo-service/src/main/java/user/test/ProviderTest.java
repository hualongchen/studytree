package user.test;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author :chenhualong
 * @Date : created in 17:02 2017/12/28
 * @Description :
 */
public class ProviderTest {


    public static void main(String[] args) throws Throwable{

        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext(new String[]{"spring-context.xml"});

        context.start();

        //阻塞住---------
        System.in.read();
    }
}
