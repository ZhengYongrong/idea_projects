package com.example.music.service.Iml;

import com.example.music.bean.Detail;
import com.example.music.bean.Song;
import com.example.music.mapper.SongMapper;
import com.example.music.service.SongService;
import com.example.music.utils.DetailUtils;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SongServiceIml implements SongService {

    @Autowired
    SongMapper songMapper;
    @Override
    //使用redis缓存
    @Cacheable(cacheNames = "SongById", unless = "#result == null ")
    public Song getSongById(Integer songID) {
        return songMapper.getSongById(songID);
    }

    @Cacheable(cacheNames = "SongByName", unless = "#result == null ")
    public Detail getSongByName(String songName) {
        List<Song> list=songMapper.getSongByName(songName);
        return DetailUtils.addList(list);
    }

    @Cacheable(cacheNames = "SongBySinger", unless = "#result == null ")
    public Detail getSongBySinger(String singer) {
        List<Song> list=songMapper.getSongBySinger(singer);
        return DetailUtils.addList(list);
    }

    @Override
    @Cacheable(cacheNames = "SongByRanking", unless = "#result == null ")
    public Detail getSongByRanking(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        Page<Song> list=songMapper.getSongByRanking();
        return DetailUtils.addPage(list);
    }
}
