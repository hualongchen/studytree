package com.lemon.chen.lemonstudyrabbit;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author :chenhualong
 * @Date : created in 10:48 2018/3/30
 * @Description :
 */

@Configuration
public class RabbitMQConfig {

    @Bean
    public Queue helloQueue() {
        return new Queue("hello");
    }
}
