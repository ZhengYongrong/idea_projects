package com.example.music.controller;

import com.example.music.bean.AccessLimit;
import com.example.music.utils.IpUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.servlet.http.HttpServletRequest;

@RestController
public class IpController {

    @Autowired
    IpUtils ipUtils;
    @AccessLimit(seconds = 5, maxCount = 20, needLogin = true)
    @GetMapping("/IP")
    public String getIP(HttpServletRequest httpServletRequest){
        if(ipUtils.redisIP(httpServletRequest)){
            return "访问正常";
        }else {
            return "拒绝访问，防止DOSS攻击！";
        }
    }
}
