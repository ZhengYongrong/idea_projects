package com.example.music.bean;

import java.util.Date;

public class Comment {
    private Integer commentID;
    private Integer userID;
    private Integer songID;
    private String contents;
    private Date commentDate;

    @Override
    public String toString() {
        return "Comment{" +
                "commentID=" + commentID +
                ", userID=" + userID +
                ", songID=" + songID +
                ", contents='" + contents + '\'' +
                ", commentDate=" + commentDate +
                '}';
    }

    public Integer getCommentID() {
        return commentID;
    }

    public void setCommentID(Integer commentID) {
        this.commentID = commentID;
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

    public String getContents() {
        return contents;
    }

    public void setContents(String contents) {
        this.contents = contents;
    }

    public Date getCommentDate() {
        return commentDate;
    }

    public void setCommentDate(Date commentDate) {
        this.commentDate = commentDate;
    }
}
