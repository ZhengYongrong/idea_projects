package com.example.music.bean;

import java.util.Date;

public class SongList {
    private Integer songListID;
    private String songListName;
    private Integer createUserID;
    private Date createDate;
    private String introduction;
    private String imageUrl;

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

    @Override
    public String toString() {
        return "SongList{" +
                "songListID=" + songListID +
                ", songListName='" + songListName + '\'' +
                ", createUserID=" + createUserID +
                ", createDate=" + createDate +
                ", introduction='" + introduction + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                '}';
    }
}
