package com.example.demodruid.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;

@Data
@AllArgsConstructor
public class Persion {
    private Integer postId;
    @NonNull
    private Integer persionId;
    private String persionName;
}
