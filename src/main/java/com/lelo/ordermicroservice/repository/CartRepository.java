package com.lelo.ordermicroservice.repository;

import com.lelo.ordermicroservice.entity.Cart;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CartRepository extends CrudRepository<Cart, String> {
    @Query(value = "SELECT * FROM cart WHERE cart.customer_id = :customerId AND cart.product_id = :productId AND cart.merchant_id = :merchantId", nativeQuery = true)
    Cart findByCustomerIdAndProductIdAndMerchantId(@Param("customerId") String customerId,@Param("productId") String productId,@Param("merchantId") String merchantId);

    @Query(value = "select * from cart where cart.customer_id = :customerId", nativeQuery = true)
    List<Cart> getByCustomerId(@Param("customerId") String customerId);

}
