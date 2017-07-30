package com.zjh.consumer;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * Created by zhengjianhui on 17/7/29.
 * @RabbitListener(queues = "hello") 指定监听队列
 */
@Component
public class FanoutReceiver {

    private static final String ROUTING_KEY1 = "a.fanout";

    private static final String ROUTING_KEY2 = "b.fanout";

    private static final String ROUTING_KEY3 = "c.fanout";

    @RabbitListener(queues = ROUTING_KEY1)
    public void processA(String hello) {
        System.out.println("ReceiverA: " + hello);
    }

    @RabbitListener(queues = ROUTING_KEY2)
    public void processB(String hello) {
        System.out.println("ReceiverB: " + hello);
    }

    @RabbitListener(queues = ROUTING_KEY3)
    public void processC(String hello) {
        System.out.println("ReceiverC: " + hello);
    }
}
