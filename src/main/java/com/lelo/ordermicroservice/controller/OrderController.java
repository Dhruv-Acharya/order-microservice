package com.lelo.ordermicroservice.controller;/* Made by: mehtakaran9 */

import com.lelo.ordermicroservice.entity.Order;
import com.lelo.ordermicroservice.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {
    @Autowired
    OrderService orderService;

    @RequestMapping(value = "/addOrder/{customerId}", method = RequestMethod.POST)
    private ResponseEntity<Boolean> addOrder(@PathVariable String customerId){
        orderService.addOrder(customerId);
        return new ResponseEntity<>(Boolean.TRUE, HttpStatus.OK);
    }

    @RequestMapping(value = "/getAll/{customerId}", method = RequestMethod.GET)
    private ResponseEntity<List<Order>> getAll(@PathVariable String customerId){
        List<Order> orderList = orderService.getAll(customerId);
        return new ResponseEntity<>(orderList, HttpStatus.ACCEPTED);
    }


    @RequestMapping(value = "/get/{orderId}", method = RequestMethod.GET)
    private Order getOrder(@PathVariable String orderId){
        return orderService.getOrder(orderId);
    }
}
