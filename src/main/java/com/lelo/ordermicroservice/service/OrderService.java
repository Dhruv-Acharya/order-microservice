package com.lelo.ordermicroservice.service;/* Made by: mehtakaran9 */

import com.lelo.ordermicroservice.dto.OrderItemResponseDTO;
import com.lelo.ordermicroservice.entity.Order;

import java.util.List;

public interface OrderService {

    String getEmailId(String customerId);

    Order addOrder(String customerId, String addressId);
    List<Order> getAll(String customerId);
    Order getOrder(String orderId);

    List<OrderItemResponseDTO> getOrderAll(String orderId);
}
