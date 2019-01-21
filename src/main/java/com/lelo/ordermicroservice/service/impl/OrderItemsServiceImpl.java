package com.lelo.ordermicroservice.service.impl;

import com.lelo.ordermicroservice.Utilities.Product;
import com.lelo.ordermicroservice.entity.Cart;
import com.lelo.ordermicroservice.entity.OrderItems;
import com.lelo.ordermicroservice.repository.CartRepository;
import com.lelo.ordermicroservice.repository.OrderItemsRepository;
import com.lelo.ordermicroservice.service.OrderItemsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.List;

public class OrderItemsServiceImpl implements OrderItemsService {

    @Autowired
    OrderItemsRepository orderItemsRepository;

    @Autowired
    CartRepository cartRepository;

    @Autowired
    List<Product> product;

    @Override
    public ResponseEntity<String> addOrderItems(String cartId) {
        Cart cart=cartRepository.findByCartId(cartId);
        OrderItems orderItems=new OrderItems();
        orderItems.setProductId(cart.getProductId());
        orderItems.setMerchantId(cart.getMerchantId());
        orderItems.setQuantity(cart.getQuantity());

        final String uri = "http://localhost:8080/product/get/"+cart.getProductId() + "/"+cart.getMerchantId();
        RestTemplate restTemplate = new RestTemplate();
        Product product = restTemplate.getForObject(uri, Product.class);

        orderItems.setPrice(product.getPrice());
        orderItemsRepository.save(orderItems);
        return orderItems.getOrderItemsId();

    }
}
