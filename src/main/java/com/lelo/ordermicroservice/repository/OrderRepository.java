package com.lelo.ordermicroservice.repository;/* Made by: mehtakaran9 */

import com.lelo.ordermicroservice.entity.Order;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends CrudRepository<Order, String> {
    @Query(value = "SELECT * FROM table_order WHERE table_order.customer_id = :customerId", nativeQuery = true)
    List<Order> getAll(@Param("customerId") String customerId);
}
