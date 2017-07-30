package com.zjh.api;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by zhengjianhui on 17/7/9.
 */
@RequestMapping("/refactor")
public interface HelloService {

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    String hello();


}
