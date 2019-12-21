package com.example.demodruid.Utils;

import javafx.beans.binding.When;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.view.tiles3.SpringBeanPreparerFactory;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.net.*;
import java.util.Enumeration;
import java.util.concurrent.TimeUnit;

@Slf4j
@Component
public class IpUtils {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;  //操作k-v都是字符串的
    // @description: 如果通过了多级反向代理的话， 
    // X-Forwarded-For的值并不止一个， 而是一串IP值， 
    // 究竟哪个才是真正的用户端的真实IP呢？ 
    // 答案是取 X-Forwarded-For中第一个非unknown的有效IP字符串。
    public static String getIpAddr(HttpServletRequest request) {
        String ipAddress = null;
        try {
            ipAddress = request.getHeader("x-forwarded-for");
            if (ipAddress == null || ipAddress.length() == 0 || "unknown".equalsIgnoreCase(ipAddress)) {
                ipAddress = request.getHeader("Proxy-Client-IP");
            }
            if (ipAddress == null || ipAddress.length() == 0 || "unknown".equalsIgnoreCase(ipAddress)) {
                ipAddress = request.getHeader("WL-Proxy-Client-IP");
            }
            if (ipAddress == null || ipAddress.length() == 0 || "unknown".equalsIgnoreCase(ipAddress)) {
                ipAddress = request.getRemoteAddr();
                if (ipAddress.equals("127.0.0.1")) {
                    // 根据网卡取本机配置的IP
                    InetAddress inet = null;
                    try {
                        inet = InetAddress.getLocalHost();
                    } catch (UnknownHostException e) {
                        e.printStackTrace();
                    }
                    ipAddress = inet.getHostAddress();
                }
            }
            // 对于通过多个代理的情况，第一个IP为客户端真实IP,多个IP按照','分割
            if (ipAddress != null && ipAddress.length() > 15) { // "***.***.***.***".length()
                // = 15
                if (ipAddress.indexOf(",") > 0) {
                    ipAddress = ipAddress.substring(0, ipAddress.indexOf(","));
                }
            }
        } catch (Exception e) {
            log.info("bug:", e);
            ipAddress = "";
        }
        log.info(ipAddress);
        return ipAddress;
    }
    public  String redisIP(String ip){
        if(stringRedisTemplate.hasKey("IP:"+ip)){
            stringRedisTemplate.opsForValue().increment("IP:"+ip);
            if(Integer.parseInt(stringRedisTemplate.opsForValue().get("IP:"+ip))>=3){
                System.out.println("IP访问次数超过，防止洪水攻击！！！");
                log.info("----IP访问次数超过，防止洪水攻击！！！----");
                return "IP访问次数超过，防止洪水攻击！！！";
            }
        }else {
            stringRedisTemplate.opsForValue().set("IP:"+ip,"0");
            stringRedisTemplate.expire("IP:"+ip,30L, TimeUnit.SECONDS);
        }
        return "正常访问！";
    }
}
