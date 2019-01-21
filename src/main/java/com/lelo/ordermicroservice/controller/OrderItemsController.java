package com.lelo.ordermicroservice.controller;

import com.lelo.ordermicroservice.service.OrderItemsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/orderItems")
public class OrderItemsController {

    @Autowired
    OrderItemsService orderItemsService;

    @RequestMapping(value = "/add/{cartId}",method = RequestMethod.POST)
    private ResponseEntity<String> addItems(@PathVariable String cartId){
        return orderItemsService.addOrderItems(cartId);
    }
}
