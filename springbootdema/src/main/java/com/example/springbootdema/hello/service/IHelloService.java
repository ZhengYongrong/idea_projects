package com.example.springbootdema.hello.service;

import com.example.springbootdema.hello.domain.Hello;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface IHelloService {
    public void saveOrUpdate(Hello hello);

    public void delete(Hello hello);

    public Hello findOne(Long id);

    public Page<Hello> findPage(Pageable pageable);
}
