package com.example.demodruid.controller;

import com.example.demodruid.Handler.PasswordMistakeException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
public class HelloController{

    @GetMapping("/login")
    public void login(String passwd) throws PasswordMistakeException {

        if(!passwd.equals("123456")){
            throw new PasswordMistakeException("对不起,您的密码错误!");
        }
    }

    @GetMapping("/zero")
    public int zero() throws ArithmeticException {

        int j = 100 /0;
        return j ;
    }

}