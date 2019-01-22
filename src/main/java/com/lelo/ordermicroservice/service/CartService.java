package com.lelo.ordermicroservice.service;

import com.lelo.ordermicroservice.entity.Cart;
import java.util.List;

public interface CartService {

    Cart addQuantity(String customerId, String productId, String merchantId, int quantity);

    List<Cart> getByCustomerId(String customerId);

    void delete(String customerId);

    void updateQuantity(String customerId,String productId, String merchantId, int quantity);

}
