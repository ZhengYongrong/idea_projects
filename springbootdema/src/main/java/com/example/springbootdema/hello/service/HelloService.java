package com.example.springbootdema.hello.service;

import com.example.springbootdema.hello.domain.Hello;
import com.example.springbootdema.hello.repository.HelloRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


@Service
public class HelloService implements IHelloService {
    @Autowired
    private HelloRepository helloRepository;

    @Override
    public void saveOrUpdate(Hello hello) {
        helloRepository.save(hello);
    }

    @Override
    public void delete(Hello hello) {
        helloRepository.delete(hello);
    }


    @Override
    public Hello findOne(Long id) {
        return helloRepository.findById(id).get();
    }

    @Override
    public Page<Hello> findPage(Pageable pageable) {
        return helloRepository.findAll(pageable);
    }


}
