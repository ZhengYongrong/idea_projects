package com.example.demodruid.controller;

import com.example.demodruid.Utils.IpUtils;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.concurrent.TimeUnit;

@RestController
@Slf4j
public class IpController {

    @Autowired
    IpUtils ipUtils;
    @PostMapping("/IP")
    public String getIP(HttpServletRequest httpServletRequest){
        String IP=IpUtils.getIpAddr(httpServletRequest);
        log.info("controller::"+IP);
        String msg=ipUtils.redisIP(IP);
        System.out.println(IP+msg);
        return IP+msg;
    }
}
