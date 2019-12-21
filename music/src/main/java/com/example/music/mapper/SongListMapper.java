package com.example.music.mapper;

import com.example.music.bean.SongList;
import com.example.music.dto.SongListDTO;
import com.github.pagehelper.Page;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface SongListMapper {
    public List<SongListDTO> getSongListDetail();
    public Page<SongList> getSongList();
    public List<SongList> getSongListByName(String songListName);
}
