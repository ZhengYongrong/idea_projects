package com.example.music;

import com.example.music.bean.Song;
import com.example.music.mapper.SongListMapper;
import com.example.music.mapper.SongMapper;
import com.example.music.utils.JsonUtils;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;

@SpringBootTest
class MusicApplicationTests {

    @Autowired
    StringRedisTemplate stringRedisTemplate;  //操作k-v都是字符串的
    @Autowired
    RedisTemplate redisTemplate;  //k-v都是对象的
    @Autowired
    SongMapper songMapper;
    @Autowired
    SongListMapper songListMapper;

    //记录器
    Logger logger = LoggerFactory.getLogger(getClass());
    @Test
    void testRedis() {
        //给redis中保存数据
        stringRedisTemplate.opsForValue().append("msg","hello");
		String msg = stringRedisTemplate.opsForValue().get("msg");
		System.out.println(msg);

        Song song=songMapper.getSongById(1);
        //1.使用redisTemplate保存对象
//        redisTemplate.opsForValue().set("song-new",song);
//        System.out.println(redisTemplate.opsForValue().get("song-new"));
        //2.使用JsonUtils保存对象
        stringRedisTemplate.opsForValue().set("zyr-new",JsonUtils.objectToJson(song));
        System.out.println(JsonUtils.jsonToPojo(stringRedisTemplate.opsForValue().get("zyr-new"),Song.class));
        stringRedisTemplate.delete("zyr-new");
        //3.使用stringRedisTemplate保存字符串，数组
//		  stringRedisTemplate.opsForList().leftPush("mylist","1");
//        stringRedisTemplate.opsForList().leftPush("mylist","2");
//        stringRedisTemplate.opsForList().leftPush("mylist","zyr");
//        stringRedisTemplate.opsForList().leftPush("mylist","郑永荣");
//        System.out.println(stringRedisTemplate.opsForList().leftPop("mylist"));
//        System.out.println(stringRedisTemplate.opsForList().rightPop("mylist"));
    }


    @Test
    public void testLog() {
        //System.out.println();

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
    public void testMapper(){
        Song song=songMapper.getSongById(1);
        System.out.println(song);
        logger.info(song.toString());
    }

    @Test
    public void testResultMap(){
        System.out.println(songListMapper.getSongList());
    }
}
