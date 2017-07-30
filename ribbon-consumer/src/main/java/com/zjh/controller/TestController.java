package com.zjh.controller;

import com.zjh.dto.UserDTO;
import com.zjh.remote.RemoteTestService;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by zhengjianhui on 17/7/9.
 */
@RestController()
public class TestController {

    @Autowired
    private RemoteTestService remoteTestService;

    @GetMapping(value = "/test1", produces = {"application/json"})
    public String test1() {
        return remoteTestService.remoteTest();
    }


    @GetMapping(value = "/test2", produces = {"application/json"})
    public UserVO test2() {
        UserDTO userDTO = remoteTestService.user();
        UserVO result = new UserVO();
        BeanUtils.copyProperties(userDTO, result);
        return result;
    }

    @GetMapping(value = "/test3", produces = {"application/json"})
    public UserVO test3() {
        UserDTO userDTO = remoteTestService.user2();
        UserVO result = new UserVO();
        BeanUtils.copyProperties(userDTO, result);
        return result;
    }

    private class UserVO {
        private String id;

        private String name;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

}
