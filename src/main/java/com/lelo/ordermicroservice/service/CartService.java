package com.lelo.ordermicroservice.service;

import com.lelo.ordermicroservice.dto.CartDTO;

import java.util.List;

public interface CartService {

    void addQuantity(String customerId,String productId, String merchantId, int quantity);

    List<CartDTO> getByCustomerId(String customerId);

    void delete(String customerId);

    void updateQuantity(String customerId,String productId, String merchantId, int quantity);

}
