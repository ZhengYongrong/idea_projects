package com.example.demodruid.bean;

import lombok.Data;

import java.util.List;

@Data
public class post_persion {
    private Integer postId;
    private String station;
    private List<Persion> list;

    public post_persion() {
    }
}
