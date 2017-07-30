package com.zjh.procuder;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * Created by zhengjianhui on 17/7/29.
 */
@Component
public class Sender {

    public static final String EXCHANGE = "boot_exchange";

    private static final String ROUTING_KEY = "hello";

    private static final String ROUTING_KEY2 = "hello2";

    @Autowired
    @Qualifier("helloTemplate")
    private RabbitTemplate helloTemplate;

    public void send() {
        String context = "hello" + new Date();
        System.out.println("sender: " + context);

        // 发送到指定队列
        this.helloTemplate.convertAndSend(EXCHANGE, ROUTING_KEY, context);
    }


    public void send2() {
        String context = "hello2" + new Date();
        System.out.println("sender: " + context);

        // 发送到指定队列
        this.helloTemplate.convertAndSend(EXCHANGE, ROUTING_KEY2, context);
    }
}
