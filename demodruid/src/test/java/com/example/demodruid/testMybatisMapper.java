package com.example.demodruid;


import com.example.demodruid.bean.Employee;
import com.example.demodruid.bean.Persion;
import com.example.demodruid.mapper.PostMapper;
import com.example.demodruid.service.EmployeeService;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class testMybatisMapper {

    @Autowired
    EmployeeService employeeService;
    @Autowired
    PostMapper postMapper;
    @Test
    public void insertSelective(){
        Employee employee1=new Employee();
        employee1.setEmail("99450912@mail.com");
        employee1.setGender(1);
        System.out.println(employee1);
        employeeService.insertSelective(employee1);
    }

    @Test
    public void updateByPrimaryKeySelective(){
        Employee employee1=new Employee();
        employee1.setId(1);
        employee1.setEmail("0099450912@mail.com");
        employee1.setGender(1);
        employee1.setLastName("liu 永荣");
        System.out.println(employee1);
        employeeService.updateByPrimaryKeySelective(employee1);
    }

    @Test
    public void getEmpAndDep(){
        System.out.println(employeeService.getEmpAndDep());
    }

    @Test
    public  void getPP(){
        System.out.println(postMapper.getPP());
    }

    @Test
    public void testLombok(){

        Persion persion=new Persion(1,null,null);
        log.info(persion.getPersionName());
    }
}
