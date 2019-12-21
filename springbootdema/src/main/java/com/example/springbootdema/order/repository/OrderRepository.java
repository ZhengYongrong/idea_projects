package com.example.springbootdema.order.repository;

import com.example.springbootdema.order.domain.Order;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends
        PagingAndSortingRepository<Order, Long>//分页和排序
        , JpaSpecificationExecutor<Order>//动态查询
{

}