package com.lelo.ordermicroservice.service;

import com.lelo.ordermicroservice.entity.OrderItem;

import java.util.List;

public interface OrderItemService {

    void addOrderItem(String customerId);
    List<OrderItem> findByOrder(String orderId);
}
