package com.example.springbootdema.woker.service;

import com.example.springbootdema.hello.domain.Hello;
import com.example.springbootdema.woker.domain.worker;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IworkerService {
    public void saveOrUpdate(worker worker);

    public void delete(worker worker);

    public worker findOne(Long id);

    public Page<worker> findPage(Pageable pageable);
}
