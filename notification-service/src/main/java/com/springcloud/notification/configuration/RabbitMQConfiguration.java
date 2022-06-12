package com.springcloud.notification.configuration;

import org.springframework.amqp.core.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfiguration {


    public static final String QUEUE_DEPOSIT = "js.deposit.notify";
    private static final String TOPIC_EXCHANGE_DEPOSIT = "js.deposit.notify.exchange";
    private static final String ROUTING_KEY_DEPOSIT = "js.ke.deposit";

    @Autowired
    private AmqpAdmin amqpAdmin;


    @Bean
    public TopicExchange topicExchange(){
        return new TopicExchange(TOPIC_EXCHANGE_DEPOSIT);
    }

    @Bean
    public Queue queueDeposit(){
        return new Queue(QUEUE_DEPOSIT);
    }

    @Bean
    public Binding depositBinding(){
        return BindingBuilder
                .bind(queueDeposit())
                .to(topicExchange())
                .with(ROUTING_KEY_DEPOSIT);
    }


}
