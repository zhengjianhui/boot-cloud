package com.zjh.remote;

import com.zjh.dto.UserDTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by zhengjianhui on 17/7/9.
 */
@Service
public class RemoteTestService {

    @Autowired
    private RestTemplate restTemplate;

    public String remoteTest() {
        return restTemplate.getForEntity("http://RIBBON-PROVIDER/hello", String.class).getBody();
    }


    public UserDTO user() {
        return restTemplate.getForEntity("http://RIBBON-PROVIDER/user/1", UserDTO.class).getBody();
    }


    public UserDTO user2() {
        Map<String, String> params = new HashMap<String, String>(1);
        params.put("id", "2");

        return restTemplate.getForEntity("http://RIBBON-PROVIDER/user2?id={id}", UserDTO.class, params).getBody();
    }

}
