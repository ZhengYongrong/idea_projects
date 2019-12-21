package com.example.springbootdema.hello.web;

import com.example.springbootdema.hello.domain.Hello;
import com.example.springbootdema.hello.service.IHelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/hello")
public class HelloController {
    @Autowired
    private IHelloService helloService;

    @PostMapping
    public void save(Hello hello) {// id = null
        helloService.saveOrUpdate(hello);
    }

    @PutMapping
    public void update(Hello hello) {// id = 1
        helloService.saveOrUpdate(hello);
    }


    @DeleteMapping
    public void delete(Long id) {
        Hello hello = helloService.findOne(id);
        if (null != hello)
            helloService.delete(hello);
    }

    @GetMapping
    public Hello findOne(Long id) {
        return helloService.findOne(id);
    }

}
