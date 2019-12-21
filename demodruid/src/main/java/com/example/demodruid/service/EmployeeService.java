package com.example.demodruid.service;

import com.example.demodruid.bean.Employee;
import com.example.demodruid.bean.emp_dep;
import com.example.demodruid.mapper.EmployeeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService implements IEmployeeService{

    @Autowired
    EmployeeMapper employeeMapper;

    @Override
    @Cacheable(cacheNames = "employee")
    public Employee getEmpById(Integer id) {
        System.out.println("查询员工"+id);
        return employeeMapper.getEmpById(id);
    }

    @Override
    public void insertEmp(Employee employee) {
        employeeMapper.insertEmp(employee);
    }

    public void insertSelective(Employee employee){
        System.out.println("选择性查询：");
        employeeMapper.insertSelective(employee);
    }

    @Override
    public void updateByPrimaryKeySelective(Employee employee) {
        employeeMapper.updateByPrimaryKeySelective(employee);
    }

    @Override
    public List<emp_dep> getEmpAndDep() {
        return employeeMapper.getEmpAndDep();
    }


}
