package com.example.music.service;

import com.example.music.bean.Detail;

public interface SongListService {
    public Detail getSongListDetail();
    public Detail getSongList(int pageNum, int pageSize);
    public Detail getSongListByName(String songListName);
}
