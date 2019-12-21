package com.example.demodruid.mapper;

import com.example.demodruid.bean.Employee;
import com.example.demodruid.bean.emp_dep;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

//@Mapper或者@MapperScan将接口扫描装配到容器中
@Mapper
public interface EmployeeMapper {

    public Employee getEmpById(Integer id);

    public void insertEmp(Employee employee);

    public void insertSelective(Employee employee);

    public void updateByPrimaryKeySelective(Employee employee);

    public List<emp_dep> getEmpAndDep();
}
