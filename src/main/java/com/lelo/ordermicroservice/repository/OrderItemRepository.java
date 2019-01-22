package com.lelo.ordermicroservice.repository;

import com.lelo.ordermicroservice.entity.Order;
import com.lelo.ordermicroservice.entity.OrderItem;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderItemRepository extends CrudRepository<OrderItem, String> {
    List<OrderItem> findByOrder(Order order);
}
