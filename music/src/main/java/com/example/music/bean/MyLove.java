package com.example.music.bean;

public class MyLove {
    private Integer loveID;
    private Integer userID;
    private Integer songID;

    @Override
    public String toString() {
        return "MyLove{" +
                "loveID=" + loveID +
                ", userID=" + userID +
                ", songID=" + songID +
                '}';
    }

    public Integer getLoveID() {
        return loveID;
    }

    public void setLoveID(Integer loveID) {
        this.loveID = loveID;
    }

    public Integer getUserID() {
        return userID;
    }

    public void setUserID(Integer userID) {
        this.userID = userID;
    }

    public Integer getSongID() {
        return songID;
    }

    public void setSongID(Integer songID) {
        this.songID = songID;
    }
}
