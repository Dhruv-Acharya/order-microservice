package com.lelo.ordermicroservice.service.impl;/* Made by: mehtakaran9 */

import com.lelo.ordermicroservice.entity.Order;
import com.lelo.ordermicroservice.repository.CartRepository;
import com.lelo.ordermicroservice.repository.OrderRepository;
import com.lelo.ordermicroservice.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private OrderRepository orderRepository;

    @Override
    public Order addOrder(String customerId) {
        Order order = new Order();
        order.setCustomerId(customerId);
        order.setDate(new Date());
        return orderRepository.save(order);
    }
}
