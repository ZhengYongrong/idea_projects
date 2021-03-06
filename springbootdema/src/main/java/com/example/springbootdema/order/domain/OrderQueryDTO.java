package com.example.springbootdema.order.domain;

import org.apache.commons.lang3.StringUtils;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class OrderQueryDTO {
    private String orderNumber;

    @DateTimeFormat(pattern = "yyyy/MM/dd HH:mm:ss")
    private Date createTimeStart;

    @DateTimeFormat(pattern = "yyyy/MM/dd HH:mm:ss")
    private Date createTimeEnd;

    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }

    public Date getCreateTimeStart() {
        return createTimeStart;
    }

    public void setCreateTimeStart(Date createTimeStart) {
        this.createTimeStart = createTimeStart;
    }

    public Date getCreateTimeEnd() {
        return createTimeEnd;
    }

    public void setCreateTimeEnd(Date createTimeEnd) {
        this.createTimeEnd = createTimeEnd;
    }

    @SuppressWarnings({"serial"})
    public static Specification<Order> getWhereClause(final OrderQueryDTO orderQueryDTO) {
        return new Specification<Order>() {
            @Override
            public Predicate toPredicate(Root<Order> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {

                List<Predicate> predicate = new ArrayList<>();

                if (StringUtils.isNotBlank(orderQueryDTO.getOrderNumber())) {
                    predicate.add(criteriaBuilder.like(root.get("orderNumber").as(String.class),
                            "%" + orderQueryDTO.getOrderNumber() + "%"));
                }
                if (null != orderQueryDTO.getCreateTimeStart()) {
                    predicate.add(criteriaBuilder.greaterThanOrEqualTo(root.get("createTime").as(Date.class),
                            orderQueryDTO.getCreateTimeStart()));
                }
                if (null != orderQueryDTO.getCreateTimeEnd()) {
                    predicate.add(criteriaBuilder.lessThanOrEqualTo(root.get("createTime").as(Date.class),
                            orderQueryDTO.getCreateTimeEnd()));
                }

                Predicate[] pre = new Predicate[predicate.size()];
                return query.where(predicate.toArray(pre)).getRestriction();
            }
        };
    }
}