package com.lelo.ordermicroservice.service;

import org.springframework.http.ResponseEntity;

public interface OrderItemsService {

    ResponseEntity<String> addOrderItems(String cartId);
}
