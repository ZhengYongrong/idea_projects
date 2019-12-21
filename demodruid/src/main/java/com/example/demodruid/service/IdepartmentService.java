package com.example.demodruid.service;

import com.example.demodruid.bean.Department;

public interface IdepartmentService {
    public void save(Department department);
    public Department getBYid(Integer id);
}
