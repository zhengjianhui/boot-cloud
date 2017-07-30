package com.zjh.server;

import com.zjh.dto.UserDTO;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by zhengjianhui on 17/7/9.
 */
@RestController
public class TestService {

    @GetMapping(value = "/hello")
    public String sayHello() {
        return "hello";
    }


    @GetMapping(value = "/user/{id}")
    public UserDTO user(@PathVariable("id") String id) {
        UserDTO user = new UserDTO();
        user.setId(id);
        user.setName("asdas");

        return user;
    }


    @GetMapping(value = "/user2")
    public UserDTO user2(@RequestParam(value = "id", required = true) String id) {
        UserDTO user = new UserDTO();
        user.setId(id);
        user.setName("asdas");

        return user;
    }
}
