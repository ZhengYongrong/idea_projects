package com.example.music.service.Iml;

import com.example.music.bean.Detail;
import com.example.music.bean.SongList;
import com.example.music.dto.SongListDTO;
import com.example.music.mapper.SongListMapper;
import com.example.music.service.SongListService;
import com.example.music.utils.DetailUtils;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SongListServiceIml implements SongListService {

    @Autowired
    SongListMapper songListMapper;

    @Cacheable(cacheNames = "SongListDetail", unless = "#result == null ")
    public Detail getSongListDetail(){
        List<SongListDTO> list=songListMapper.getSongListDetail();
        return DetailUtils.addList(list);
    }

    @Override
    @Cacheable(cacheNames = "SongList", unless = "#result == null ")
    public Detail getSongList(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        Page<SongList> lists=songListMapper.getSongList();
        return DetailUtils.addPage(lists);
    }

    @Override
    @Cacheable(cacheNames = "SongListName", unless = "#result == null ")
    public Detail getSongListByName(String songListName) {
        List<SongList> lists=songListMapper.getSongListByName(songListName);
        return DetailUtils.addList(lists);
    }
}
