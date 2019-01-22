package com.lelo.ordermicroservice.service;/* Made by: mehtakaran9 */

import com.lelo.ordermicroservice.entity.Order;

import java.util.List;

public interface OrderService {

    Order addOrder(String customerId);
    List<Order> getAll(String customerId);
    Order getOrder(String orderId);
}
