package com.zjh.service;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by zhengjianhui on 17/7/10.
 */
@FeignClient("hello-server")
public interface HelloService1 {

    @RequestMapping("/hello")
    String hello();
}
