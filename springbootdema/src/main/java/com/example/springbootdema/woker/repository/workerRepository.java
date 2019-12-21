package com.example.springbootdema.woker.repository;

import com.example.springbootdema.woker.domain.worker;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface workerRepository
        extends PagingAndSortingRepository<worker, Long> {
}
