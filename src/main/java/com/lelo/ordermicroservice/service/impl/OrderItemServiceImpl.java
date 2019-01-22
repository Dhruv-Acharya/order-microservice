package com.lelo.ordermicroservice.service.impl;

import com.lelo.ordermicroservice.entity.Cart;
import com.lelo.ordermicroservice.entity.Order;
import com.lelo.ordermicroservice.entity.OrderItem;
import com.lelo.ordermicroservice.entity.OrderItemIdentity;
import com.lelo.ordermicroservice.repository.CartRepository;
import com.lelo.ordermicroservice.repository.OrderItemRepository;
import com.lelo.ordermicroservice.service.OrderItemService;
import com.lelo.ordermicroservice.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Iterator;
import java.util.List;
@Service
public class OrderItemServiceImpl implements OrderItemService {

    @Autowired
    OrderService orderService;

    @Autowired
    OrderItemRepository orderItemRepository;

    @Autowired
    CartRepository cartRepository;

    @Override
    public void addOrderItem(String customerId) {
        Order order = orderService.addOrder(customerId);
        Iterable<Cart> cartIterable = cartRepository.getByCustomerId(customerId);
        Iterator iterator = cartIterable.iterator();
        while(iterator.hasNext()){
            OrderItem orderItem = new OrderItem();
            Cart cart = (Cart) iterator.next();
            OrderItemIdentity orderItemIdentity = new OrderItemIdentity();
            orderItemIdentity.setMerchantId(cart.getCartIdentity().getMerchantId());
            orderItemIdentity.setProductId(cart.getCartIdentity().getProductId());
            orderItem.setOrderItemIdentity(orderItemIdentity);
            orderItem.setQuantity(cart.getQuantity());
            orderItem.setOrder(order);
            orderItemRepository.save(orderItem);
        }


    }

    @Override
    public List<OrderItem> findByOrder(String orderId) {
        Order order = orderService.getOrder(orderId);
        return orderItemRepository.findByOrder(order);
    }

//
//        final String uri = "http://localhost:8080/product/get/" + cartIdentity.getProductId() + "/" + cartIdentity.getMerchantId();
//        RestTemplate restTemplate = new RestTemplate();
//        Product product = restTemplate.getForObject(uri, Product.class);
//
//        orderItem.setPrice(product.getPrice());
//        orderItemRepository.save(orderItem);

}
