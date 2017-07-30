package com.zjh.feign;

import com.zjh.api.HelloService;

import org.springframework.web.bind.annotation.RestController;

/**
 * Created by zhengjianhui on 17/7/10.
 */
@RestController
public class RefactorHelloService implements HelloService {


    public String hello() {
        return "hello";
    }
}
