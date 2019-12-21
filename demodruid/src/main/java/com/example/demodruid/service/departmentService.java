package com.example.demodruid.service;

import com.example.demodruid.bean.Department;
import com.example.demodruid.mapper.departmentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cache.Cache;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.stereotype.Service;

@Service
public class departmentService implements IdepartmentService{

    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    @Autowired
    departmentMapper departmentMapper;

    @Override
    public void save(Department department) {
        departmentMapper.insertDept(department);
    }

    @Override
    public Department getBYid(Integer id) {
        return departmentMapper.getDeptById(id);
    }

    // 使用缓存管理器得到缓存，进行api调用
//    public Department getDeptById(Integer id){
//        System.out.println("查询部门"+id);
//        Department department = departmentMapper.getDeptById(id);
//
//        //获取某个缓存
//        Cache dept = redisCacheManager.getCache("dept");
//        dept.put("dept:1",department);
//
//        return department;
//    }
    @Cacheable(cacheNames = "dept")
    public Department getDeptById(Integer id){
        System.out.println("查询部门"+id);
        Department department = departmentMapper.getDeptById(id);
        return department;
    }
}
