package com.example.actuator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class redisController {
    @Autowired
    RedisTemplate redisTemplate;
    @GetMapping("/hello")
    public String hello(){
        redisTemplate.opsForValue().set("hello","zyr郑永荣");
        return "hello:"+redisTemplate.opsForValue().get("hello");
    }
}
