package com.example.springbootdema.order.service;

import com.example.springbootdema.order.domain.Order;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;

import java.util.Optional;

public interface IOrderService {
    public Order save(Order entity);

    public Optional<Order> findById(Long id);

    public boolean existsById(Long id);

    public long count();

    public void deleteById(Long id);

    public void deleteAll(Long[] ids);

    public Page<Order> findAll(Specification<Order> spec, Pageable pageable);
}