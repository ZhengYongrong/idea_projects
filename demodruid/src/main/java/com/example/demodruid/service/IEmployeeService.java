package com.example.demodruid.service;

import com.example.demodruid.bean.Employee;
import com.example.demodruid.bean.emp_dep;

import java.util.List;

public interface IEmployeeService {
    public Employee getEmpById(Integer id);

    public void insertEmp(Employee employee);

    public void insertSelective(Employee employee);

    public void updateByPrimaryKeySelective(Employee employee);

    public List<emp_dep> getEmpAndDep();
}
