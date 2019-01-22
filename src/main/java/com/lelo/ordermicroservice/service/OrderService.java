package com.lelo.ordermicroservice.service;/* Made by: mehtakaran9 */

import com.lelo.ordermicroservice.dto.ResponseDTO;
import com.lelo.ordermicroservice.entity.Order;

import java.util.List;

public interface OrderService {

    String getEmailId(String customerId);

    Order addOrder(String customerId);
    List<Order> getAll(String customerId);
    Order getOrder(String orderId);

    List<ResponseDTO> getOrderAll(String orderId);
}
