package com.example.music.service;

import com.example.music.bean.Detail;
import com.example.music.bean.Song;
import com.example.music.bean.SongList;

import java.util.List;

public interface SongService {
    public Song getSongById(Integer songID);
    public Detail getSongByName(String songName);
    public Detail getSongBySinger(String singer);
    public Detail getSongByRanking(int pageNum, int pageSize);
}
