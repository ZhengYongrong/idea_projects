package com.example.demodruid;

import com.alibaba.druid.support.http.util.IPAddress;
import com.example.demodruid.Utils.JsonUtils;
import com.example.demodruid.bean.Department;
import com.example.demodruid.bean.Employee;
import com.example.demodruid.mapper.EmployeeMapper;
import com.example.demodruid.service.EmployeeService;
import com.example.demodruid.service.departmentService;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;

import javax.sql.DataSource;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.concurrent.TimeUnit;

@SpringBootTest
class DemodruidApplicationTests {

    @Autowired
    DataSource dataSource;

    Logger logger= LoggerFactory.getLogger(getClass());

    @Autowired
    StringRedisTemplate stringRedisTemplate;  //操作k-v都是字符串的

    @Autowired
    RedisTemplate redisTemplate;  //k-v都是对象的

    @Autowired
    EmployeeService employeeService;
    @Autowired
    departmentService departmentService;

    /**
     * Redis常见的五大数据类型
     *  String（字符串）、List（列表）、Set（集合）、Hash（散列）、ZSet（有序集合）
     *  stringRedisTemplate.opsForValue()[String（字符串）]
     *  stringRedisTemplate.opsForList()[List（列表）]
     *  stringRedisTemplate.opsForSet()[Set（集合）]
     *  stringRedisTemplate.opsForHash()[Hash（散列）]
     *  stringRedisTemplate.opsForZSet()[ZSet（有序集合）]
     */
    @Test
    public void test01(){
//        给redis中保存数据
//        stringRedisTemplate.opsForValue().append("msg","hello");
//		String msg = stringRedisTemplate.opsForValue().get("msg");
//		System.out.println(msg);
//
//		stringRedisTemplate.opsForList().leftPush("mylist","1");
//        stringRedisTemplate.opsForList().leftPush("mylist","2");
//        stringRedisTemplate.opsForList().leftPush("mylist","zyr");
//        stringRedisTemplate.opsForList().leftPush("mylist","郑永荣");
//        System.out.println(stringRedisTemplate.opsForList().leftPop("mylist"));
//        System.out.println(stringRedisTemplate.opsForList().rightPop("mylist"));
        try {
            String ip = InetAddress.getLocalHost().getHostAddress();
            stringRedisTemplate.opsForValue().set(ip,"0",30,TimeUnit.SECONDS);
            //stringRedisTemplate.expire(ip,30, TimeUnit.SECONDS);
            System.out.println(ip+":"+stringRedisTemplate.opsForValue().get(ip));
            stringRedisTemplate.opsForValue().increment(ip);
            stringRedisTemplate.opsForValue().increment(ip);
            stringRedisTemplate.opsForValue().increment(ip);
            System.out.println(ip+":"+stringRedisTemplate.opsForValue().get(ip));
            if(Integer.parseInt(stringRedisTemplate.opsForValue().get(ip))>2){
                System.out.println("拒绝访问");
            }
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test04(){
        String ip="0:0:0:0:0:0:0:1";
        if(stringRedisTemplate.hasKey("IP:"+ip)){
            stringRedisTemplate.opsForValue().increment("IP:"+ip);
            if(Integer.parseInt(stringRedisTemplate.opsForValue().get("IP:"+ip))>=3){
                System.out.println("IP访问次数超过，防止洪水攻击！！！");
            }
        }else {
            stringRedisTemplate.opsForValue().set("IP:"+ip,"0");
        }

    }

    //测试保存对象
    @Test
    public void test02(){
        Employee empById = employeeService.getEmpById(1);
        Department department=departmentService.getBYid(2);
        //默认如果保存对象，使用jdk序列化机制，序列化后的数据保存到redis中
        //edisTemplate.opsForValue().set("emp-01",empById);
        //1、将数据以json的方式保存
        //(1)自己将对象转为json
        //(2)redisTemplate默认的序列化规则；改变默认的序列化规则；
        //empRedisTemplate.opsForValue().set("emp-01",empById);
        //deptRedisTemplate.opsForValue().set("dept-2",department);
        redisTemplate.opsForValue().set("emp-01",empById);
        redisTemplate.opsForValue().set("dept-2",department);

    }
    @Test
    public void testJson(){
        Employee empById = employeeService.getEmpById(1);
//        stringRedisTemplate.opsForValue().set("json-user", JsonUtils.objectToJson(user));
//        User user1 = JsonUtils.jsonToPojo(stringRedisTemplate.opsForValue().get("json-user"),User.class);
//        log.info("【stringTemplate存取对象】user={}",user1.toString());
        stringRedisTemplate.opsForValue().set("json-emp-01-new",JsonUtils.objectToJson(empById));
        System.out.println(JsonUtils.jsonToPojo(stringRedisTemplate.opsForValue().get("json-emp-01-new"),Employee.class).toString());
        logger.info(JsonUtils.jsonToPojo(stringRedisTemplate.opsForValue().get("json-emp-01-new"),Employee.class).toString());
    }
    @Test
    void contextLoads02() {
        //日志的级别；
        //由低到高   trace<debug<info<warn<error
        //可以调整输出的日志级别；日志就只会在这个级别以以后的高级别生效
        logger.trace("这是trace日志...");
        logger.debug("这是debug日志...");
        //SpringBoot默认给我们使用的是info级别的，没有指定级别的就用SpringBoot默认规定的级别；root级别
        logger.info("这是info日志...");
        logger.warn("这是warn日志...");
        logger.error("这是error日志...");
    }
    @Test
    public void contextLoads() throws SQLException {
        //org.apache.tomcat.jdbc.pool.DataSource
        System.out.println(dataSource.getClass());

        Connection connection = dataSource.getConnection();
        System.out.println(connection);
        connection.close();
    }

    @Test
    public void testLog(){
        try {
            int i=1/0;

        }catch (Exception ex){
            logger.info("1/0",ex);
        }
    }
}
