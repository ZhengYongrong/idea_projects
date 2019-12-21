package com.example.music.controller;

import com.example.music.bean.AccessLimit;
import com.example.music.bean.Detail;
import com.example.music.service.SongListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
public class SongListController {
    @Autowired
    SongListService songListService;

    //获取歌单的细目（歌曲）
    @GetMapping("/song/songListDetail")
    @AccessLimit(seconds = 5, maxCount = 20, needLogin = true)
    public Detail getSongListDetail(){
        return songListService.getSongListDetail();
    }
    //获取歌单列表
    @AccessLimit(seconds = 5, maxCount = 20, needLogin = true)
    @GetMapping("/song/songList")
    public Detail getSongList(int pageNum, int pageSize){
        return songListService.getSongList(pageNum,pageSize);
    }

    //根据歌单名字查找歌单
    @AccessLimit(seconds = 5, maxCount = 20, needLogin = true)
    @GetMapping("/song/songListByName")
    public Detail getSongListByName(String songListName){
        return songListService.getSongListByName(songListName);
    }
}
