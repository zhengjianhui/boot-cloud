package com.zjh.controller;

import com.zjh.service.HelloService1;
import com.zjh.service.HelloService2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by zhengjianhui on 17/7/10.
 */
@RestController
public class HelloFeignController {

    @Autowired
    private HelloService1 helloServeice;

    @Autowired
    private HelloService2 helloService2;

    @RequestMapping(value = "/feign-consumer", method = RequestMethod.GET)
    public String hello() {
        return helloServeice.hello();

    }


    @RequestMapping(value = "/feign2-consumer", method = RequestMethod.GET)
    public String hello2() {
        return helloService2.hello();

    }
}
