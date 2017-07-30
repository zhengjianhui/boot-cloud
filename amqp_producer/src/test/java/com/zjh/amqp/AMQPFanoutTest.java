package com.zjh.amqp;

import com.zjh.AmqpProducerApplication;
import com.zjh.procuder.FanoutSender;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by zhengjianhui on 17/7/29.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = AmqpProducerApplication.class)
public class AMQPFanoutTest {

    @Autowired
    private FanoutSender fanoutSender;

    @Test
    public void send() {
        fanoutSender.send();

    }


}
