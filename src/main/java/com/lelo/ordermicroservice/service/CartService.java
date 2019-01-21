package com.lelo.ordermicroservice.service;

import com.lelo.ordermicroservice.Utilities.CartList;

public interface CartService {

    void addQuantity(String customerId,String productId, String merchantId, int quatity);

    String getByCustomerId(String customerId);

    void delete(String cartId);

    void updateQuantity(String customerId,String productId, String merchantId, int quatity);

    CartList getCart(String cartId);

}
