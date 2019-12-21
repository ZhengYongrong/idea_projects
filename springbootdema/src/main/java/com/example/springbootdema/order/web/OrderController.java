package com.example.springbootdema.order.web;

import com.example.springbootdema.common.web.ResponseEntity;
import com.example.springbootdema.common.web.STablePageRequest;
import com.example.springbootdema.order.domain.Order;
import com.example.springbootdema.order.domain.OrderQueryDTO;
import com.example.springbootdema.order.service.IOrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/order")
public class OrderController {
    private static Logger log = LoggerFactory.getLogger(OrderController.class);

    @Autowired
    private IOrderService orderService;

    @GetMapping
    public ResponseEntity<Order> findProductByKey(
            OrderQueryDTO orderQueryDTO
            , STablePageRequest pageRequest
    ) {
        //ProductVO responseVo = new ProductVO();
        Page<Order> page = Page.empty(pageRequest.getPageable());
        try {
            //Page<ProductDto> dtoPage = orderService.findAll(
            // 		OrderQueryDTO.getWhereClause(orderQueryDTO)
            //     , pageRequest.getPageable());
            //for增强for遍历转换每一个entity to dto
            // ProductVO.dto2Vo(dto, responseVo);
            page = orderService.findAll(OrderQueryDTO.getWhereClause(orderQueryDTO), pageRequest.getPageable());
        } /*catch (ApplicationException ex) {
            log.error("Find Order error.{}", ex.getMessage());
            return ResponseEntity.ofFailed().data("Find Order Page error.");
        }*/ catch (Exception ex) {
            log.error("Find Order error.{}", ex.getMessage());
            return ResponseEntity.ofFailed().data("Find Order Page error.");
        }
        return ResponseEntity.ofSuccess().status(HttpStatus.OK).data(page);
    }
}