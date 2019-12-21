package com.example.music.controller;

import com.example.music.bean.AccessLimit;
import com.example.music.bean.Detail;
import com.example.music.service.SongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
public class SongController {
    @Autowired
    SongService songService;

    //根据歌名查找歌曲
    @AccessLimit(seconds = 5, maxCount = 20, needLogin = true)
    @GetMapping("/song/songName")
    public Detail getSongByName(String songName){
        return songService.getSongByName(songName);
    }
    //根据歌手姓名查找歌曲
    @AccessLimit(seconds = 5, maxCount = 20, needLogin = true)
    @GetMapping("/song/singer")
    public Detail getSongBySinger(String singer){
        return songService.getSongBySinger(singer);
    }
    //分页查找排行版
    @AccessLimit(seconds = 5, maxCount = 20, needLogin = true)
    @GetMapping("/song/ranking")
    public Detail getSongByRanking(int pageNum, int pageSize){
        return songService.getSongByRanking(pageNum,pageSize);
    }
}
