package com.example.demodruid.controller;

import com.example.demodruid.bean.Department;
import com.example.demodruid.bean.Employee;
import com.example.demodruid.service.EmployeeService;
import com.example.demodruid.service.departmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class departmentController {

    @Autowired
    departmentService departmentService;

    @Autowired
    EmployeeService employeeService;

    @GetMapping("/dept/{id}")
    public Department getDepartment(@PathVariable(value = "id") Integer id){

        //return departmentService.getBYid(id);
        return  departmentService.getDeptById(id);
    }

    @GetMapping("/dept")
    public Department insertDept(Department department){
        departmentService.save(department);
        return department;
    }

    @GetMapping("/emp/{id}")
    public Employee getEmp(@PathVariable("id") Integer id){
        return employeeService.getEmpById(id);
    }

}
