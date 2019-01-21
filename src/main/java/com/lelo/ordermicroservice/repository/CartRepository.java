package com.lelo.ordermicroservice.repository;

import com.lelo.ordermicroservice.entity.Cart;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CartRepository extends CrudRepository<Cart, String> {

    Cart findByCartIdAndProductIdAndMerchantId(String cartId,String productId,String merchantId);
    Cart findByCustomerId(String customerId);
    Cart findByCartId(String cartId);
}
