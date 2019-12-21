package com.example.springbootdema.order.service;

import com.example.springbootdema.order.domain.Order;
import com.example.springbootdema.order.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/**
 * 业务逻辑层：
 * 系统核心功能：业务逻辑、算法、核心功能、调用持久层（下层）的方法对数据库进行CRUD操作。
 *
 * @author Administrator
 */
@Service
@Transactional
public class OrderService implements IOrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Override
    public Order save(Order entity) {
        return orderRepository.save(entity);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Order> findById(Long id) {
        return orderRepository.findById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public boolean existsById(Long id) {

        return orderRepository.existsById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public long count() {
        return orderRepository.count();
    }

    @Override
    public void deleteById(Long id) {
        orderRepository.deleteById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public Page<Order> findAll(Specification<Order> spec, Pageable pageable) {

        return orderRepository.findAll(spec, pageable);
    }

    @Override
    public void deleteAll(Long[] ids) {
        List<Long> idLists = new ArrayList<Long>(Arrays.asList(ids));

        List<Order> orders = (List<Order>) orderRepository.findAllById(idLists);
        if (orders != null) {
            orderRepository.deleteAll(orders);
        }
    }
}