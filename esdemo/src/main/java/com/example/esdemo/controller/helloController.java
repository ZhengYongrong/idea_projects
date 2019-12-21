package com.example.esdemo.controller;

import com.example.esdemo.service.AsynService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class helloController {

    @Autowired
    AsynService asynService;

    @GetMapping("/hello01")
    public String hello(){
        asynService.helloService();
        return "123";
    }
}
