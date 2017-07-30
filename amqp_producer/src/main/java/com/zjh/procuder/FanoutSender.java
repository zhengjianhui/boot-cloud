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
public class FanoutSender {


    private static final String FUNOUT_EXCHANGE = "boot_fanout_exchange";


    @Autowired
    @Qualifier("fanoutTemplate")
    private RabbitTemplate helloTemplate;

    public void send() {
        String context = "hello" + new Date();
        System.out.println("sender: " + context);

        // 发送到指定Exchange
        this.helloTemplate.convertAndSend(FUNOUT_EXCHANGE, null, context);
    }


}
