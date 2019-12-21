package com.example.demodruid.bean;

import lombok.Data;

@Data
public class emp_dep {

    //private String departmentName;

    //员工
    private Integer id;
    private String lastName;
    private Integer gender;
    private String email;
    private Integer dId;

    //部门
    private Department department;
}
