package com.zjh.config;


import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


/**
 * Created by zhengjianhui on 17/7/29.
 */
@Configuration
public class RabbitFanoutConfig {

    private static final String FUNOUT_EXCHANGE = "boot_fanout_exchange";

    private static final String ROUTING_KEY1 = "a.fanout";

    private static final String ROUTING_KEY2 = "b.fanout";

    private static final String ROUTING_KEY3 = "c.fanout";

    private static final Boolean PERSISTENCE = Boolean.TRUE;

    @Autowired
    private RabbitMQProperties rabbitMQProperties;

    /**
     * 连接工厂基本配置
     *
     * @return ConnectionFactory 连接工厂
     */
    @Bean
    public ConnectionFactory connectionFactory() {
        CachingConnectionFactory factory = new CachingConnectionFactory();
        factory.setHost(rabbitMQProperties.getHost());
        factory.setPort(rabbitMQProperties.getPort());
        factory.setUsername(rabbitMQProperties.getUsername());
        factory.setPassword(rabbitMQProperties.getPassword());
//        factory.setVirtualHost(rabbitMQProperties.getVirtualHost());

        return factory;

    }

    /**
     * 模板类
     *
     * @return RabbitTemplate rabbitmq模板
     */
    @Bean(name = "fanoutTemplate")
    public RabbitTemplate rabbitTemplate() {
        RabbitTemplate template = new RabbitTemplate(connectionFactory());
        return template;
    }




    /**
     * 针对消费者配置
     * 1. 设置交换机类型
     * 2. 将队列绑定到交换机
     *
     *
     * FanoutExchange: 将消息分发到所有的绑定队列，无routingkey的概念
     * HeadersExchange ：通过添加属性key-value匹配
     * DirectExchange:按照routingkey分发到指定队列
     * TopicExchange:多关键字匹配
     */
    @Bean
    public FanoutExchange fanoutExchange() {
        return new FanoutExchange(FUNOUT_EXCHANGE);
    }


    @Bean
    public Queue fanoutQueue1() {
        return new Queue(ROUTING_KEY1, PERSISTENCE);
    }

    @Bean
    public Queue fanoutQueue2() {
        return new Queue(ROUTING_KEY2, PERSISTENCE);
    }

    @Bean
    public Queue fanoutQueue3() {
        return new Queue(ROUTING_KEY3, PERSISTENCE);
    }



    @Bean
    public Binding binding() {
        return BindingBuilder.bind(fanoutQueue1()).to(fanoutExchange());
    }

    @Bean
    public Binding binding2() {
        return BindingBuilder.bind(fanoutQueue2()).to(fanoutExchange());
    }

    @Bean
    public Binding binding3() {
        return BindingBuilder.bind(fanoutQueue3()).to(fanoutExchange());
    }
}
