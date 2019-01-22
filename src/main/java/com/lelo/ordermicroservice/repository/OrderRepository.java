package com.lelo.ordermicroservice.repository;/* Made by: mehtakaran9 */

import com.lelo.ordermicroservice.entity.Order;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends CrudRepository<Order, String> {

}
