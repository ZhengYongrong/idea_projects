package com.example.demodruid.Handler;

import com.alibaba.fastjson.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
@ResponseBody
public class GlobalExceptionHandler {

    Logger log= LoggerFactory.getLogger(getClass());

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(PasswordMistakeException.class)
    public String passwordMistake(PasswordMistakeException e){
        log.error("错误信息："+e.getMessage());
        JSONObject result = new JSONObject();
        result.put("code","1201");
        result.put("msg",e.getMessage());
        return result.toJSONString();
    }

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(ArithmeticException.class)
    public String passwordMistake(ArithmeticException e){
        log.error("错误信息："+e.getMessage());
        JSONObject result = new JSONObject();
        result.put("code","500");
        result.put("msg",e.getMessage());
        return result.toJSONString();
    }

}
