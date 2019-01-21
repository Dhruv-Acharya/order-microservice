package com.lelo.ordermicroservice.repository;

import com.lelo.ordermicroservice.entity.OrderItem;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderItemRepository extends CrudRepository<OrderItem, String> {
}
