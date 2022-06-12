package com.springcloud.notification.service;

import com.springcloud.notification.configuration.RabbitMQConfiguration;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class DepositMessageHandler {


    private final JavaMailSender javaMailSender;

    @Autowired
    public DepositMessageHandler(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }


    @RabbitListener(queues = RabbitMQConfiguration.QUEUE_DEPOSIT)
    public void recieve(Message message){
        byte[] body = message.getBody();
        String jsonBody = new String(body);
    }



}
