package com.lelo.ordermicroservice.repository;

import com.lelo.ordermicroservice.entity.OrderItems;
import org.springframework.data.repository.CrudRepository;

public interface OrderItemsRepository extends CrudRepository<OrderItems, String> {
}
