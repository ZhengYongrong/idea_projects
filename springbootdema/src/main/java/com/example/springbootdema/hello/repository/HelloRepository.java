package com.example.springbootdema.hello.repository;

import com.example.springbootdema.hello.domain.Hello;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;


/**
 * PagingAndSortingRepository
 * 基础CRUD功能
 * 分页+排序功能
 * 自定义查询功能
 * 统计分析功能
 *
 * @author Administrator
 */
@Repository
public interface HelloRepository
        extends PagingAndSortingRepository<Hello, Long> {

}
