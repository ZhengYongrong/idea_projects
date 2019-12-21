package com.example.music.dto;

import com.example.music.bean.Song;

import java.util.Date;
import java.util.List;

public class SongListDTO {

    private Integer songListID;
    private String songListName;
    private Integer createUserID;
    private Date createDate;
    private String introduction;
    private String imageUrl;

    private List<Song> songs;

    public Integer getSongListID() {
        return songListID;
    }

    public void setSongListID(Integer songListID) {
        this.songListID = songListID;
    }

    public String getSongListName() {
        return songListName;
    }

    public void setSongListName(String songListName) {
        this.songListName = songListName;
    }

    public Integer getCreateUserID() {
        return createUserID;
    }

    public void setCreateUserID(Integer createUserID) {
        this.createUserID = createUserID;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public List<Song> getSongs() {
        return songs;
    }

    public void setSongs(List<Song> songs) {
        this.songs = songs;
    }

    @Override
    public String toString() {
        return "SongListDTO{" +
                "songListID=" + songListID +
                ", songListName='" + songListName + '\'' +
                ", createUserID=" + createUserID +
                ", createDate=" + createDate +
                ", introduction='" + introduction + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                ", songs=" + songs +
                '}';
    }
}
