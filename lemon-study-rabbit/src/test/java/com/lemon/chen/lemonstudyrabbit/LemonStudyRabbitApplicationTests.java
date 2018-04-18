package com.lemon.chen.lemonstudyrabbit;


import com.lemon.chen.lemonstudyrabbit.fanout.FanoutSender;
import com.lemon.chen.lemonstudyrabbit.hello.HelloSender;
import com.lemon.chen.lemonstudyrabbit.topic.TopicSender;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class LemonStudyRabbitApplicationTests {



	@Autowired
	private HelloSender  helloSender ;

	@Autowired
	private TopicSender  topicSender ;

	@Autowired
	private FanoutSender  fanoutSender ;


	@Test
	public void contextLoads() throws Exception{

		for (int i = 0; i <100 ; i++) {


			//helloSender.send();
			//topicSender.send();

			//topicSender.send1();
			//topicSender.send2();

			fanoutSender.send();
			Thread.sleep(500);
		}
	}

}
