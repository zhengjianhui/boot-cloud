package com.zjh.service;

import org.springframework.cloud.netflix.feign.FeignClient;

/**
 * Created by zhengjianhui on 17/7/10.
 */
@FeignClient("hello-server")
public interface HelloService2 extends com.zjh.api.HelloService {
}
