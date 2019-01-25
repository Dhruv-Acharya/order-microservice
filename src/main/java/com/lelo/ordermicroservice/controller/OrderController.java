package com.lelo.ordermicroservice.controller;/* Made by: mehtakaran9 */

import com.lelo.ordermicroservice.Utilities.JavaEmail;
import com.lelo.ordermicroservice.dto.OrderItemResponseDTO;
import com.lelo.ordermicroservice.entity.Order;
import com.lelo.ordermicroservice.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.mail.MessagingException;
import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {
    @Autowired
    OrderService orderService;

    @CrossOrigin("*")
    @RequestMapping(value = "/addOrder/{customerId}/{addressId}", method = RequestMethod.POST)
    private ResponseEntity<Order> addOrder(@PathVariable String customerId, @PathVariable String addressId) throws MessagingException {
        Order order = orderService.addOrder(customerId, addressId);
        JavaEmail javaEmail = new JavaEmail();
        String emailIdResult = orderService.getEmailId(customerId);
        javaEmail.JavaEmail(emailIdResult, "Order Placed: <br>Order ID is: " +
                order.getOrderId() + "<br>Order Date: " + order.getDate() + "<br>Order Amount: "
                + order.getAmount() + "<br>Customer ID: " + order.getCustomerId(), "Order Placed");
        return new ResponseEntity<>(order, HttpStatus.OK);
    }

    @CrossOrigin("*")
    @RequestMapping(value = "/getAll/{customerId}", method = RequestMethod.GET)
    private ResponseEntity<List<Order>> getAll(@PathVariable String customerId){
        List<Order> orderList = orderService.getAll(customerId);
        return new ResponseEntity<>(orderList, HttpStatus.ACCEPTED);
    }

    @CrossOrigin("*")
    @RequestMapping(value = "/getOrderAll/{orderId}", method = RequestMethod.GET)
    private List<OrderItemResponseDTO> getOrderAll(@PathVariable String orderId) {
        return orderService.getOrderAll(orderId);
    }
}
