package com.example.music.bean;

public class Song {
    private Integer songID;
    private String  songName;
    private String  singer;
    private String  fileUrl;
    private Integer hits;
    private Integer download;
    private Integer songType; //1-流行音乐；2-说唱；3-舞曲；4-民谣；5-其他的
    private String imageUrl;

    public Integer getSongID() {
        return songID;
    }

    public void setSongID(Integer songID) {
        this.songID = songID;
    }

    public String getSongName() {
        return songName;
    }

    public void setSongName(String songName) {
        this.songName = songName;
    }

    public String getSinger() {
        return singer;
    }

    public void setSinger(String singer) {
        this.singer = singer;
    }

    public String getFileUrl() {
        return fileUrl;
    }

    public void setFileUrl(String fileUrl) {
        this.fileUrl = fileUrl;
    }

    public Integer getHits() {
        return hits;
    }

    public void setHits(Integer hits) {
        this.hits = hits;
    }

    public Integer getDownload() {
        return download;
    }

    public void setDownload(Integer download) {
        this.download = download;
    }

    public Integer getSongType() {
        return songType;
    }

    public void setSongType(Integer songType) {
        this.songType = songType;
    }

    @Override
    public String toString() {
        return "Song{" +
                "songID=" + songID +
                ", songName='" + songName + '\'' +
                ", singer='" + singer + '\'' +
                ", fileUrl='" + fileUrl + '\'' +
                ", hits=" + hits +
                ", download=" + download +
                ", songType=" + songType +
                '}';
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
