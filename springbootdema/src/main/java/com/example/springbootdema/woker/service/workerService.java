package com.example.springbootdema.woker.service;

import com.example.springbootdema.hello.domain.Hello;
import com.example.springbootdema.woker.domain.worker;
import com.example.springbootdema.woker.repository.workerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class workerService implements IworkerService {

    @Autowired
    private workerRepository workerRepository;

    @Override
    public void saveOrUpdate(worker worker) {
        workerRepository.save(worker);
    }

    @Override
    public void delete(worker worker) {
        workerRepository.delete(worker);
    }

    @Override
    public worker findOne(Long id) {
        return workerRepository.findById(id).get();
    }

    @Override
    public Page<worker> findPage(Pageable pageable) {
        return workerRepository.findAll(pageable);
    }
}
