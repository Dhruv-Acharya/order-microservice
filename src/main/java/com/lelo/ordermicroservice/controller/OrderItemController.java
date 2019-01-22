package com.lelo.ordermicroservice.controller;

import com.lelo.ordermicroservice.entity.Order;
import com.lelo.ordermicroservice.service.OrderItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/orderItems")
public class OrderItemController {

    @Autowired
    OrderItemService orderItemService;

    @RequestMapping(value = "/add/{customerId}",method = RequestMethod.POST)
    private void addItem(@PathVariable String customerId){
        orderItemService.addOrderItem(customerId);
    }
}
