package com.lelo.ordermicroservice.service.impl;/* Made by: mehtakaran9 */

import com.lelo.ordermicroservice.Utilities.Merchant;
import com.lelo.ordermicroservice.Utilities.Product;
import com.lelo.ordermicroservice.dto.ResponseDTO;
import com.lelo.ordermicroservice.entity.Order;
import com.lelo.ordermicroservice.entity.OrderItem;
import com.lelo.ordermicroservice.repository.CartRepository;
import com.lelo.ordermicroservice.repository.OrderItemRepository;
import com.lelo.ordermicroservice.repository.OrderRepository;
import com.lelo.ordermicroservice.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private CartRepository cartRepository;
    
    @Autowired
    private OrderItemRepository orderItemRepository;
    
    @Autowired
    private OrderRepository orderRepository;

    @Override
    public Order addOrder(String customerId) {
        Order order = new Order();
        order.setCustomerId(customerId);
        order.setDate(new Date());
        return orderRepository.save(order);
    }

    @Override
    public List<Order> getAll(String customerId){
        List<Order> orderList = orderRepository.getAll(customerId);
        return orderList;
    }

    @Override
    public Order getOrder(String orderId){
        return orderRepository.findOne(orderId);
    }
    
    @Override
    public List<ResponseDTO> getOrderAll(String orderId){
        List<ResponseDTO> responseDTOList = new ArrayList<>();
        Order order = orderRepository.findOne(orderId);

        List<OrderItem> orderItems = orderItemRepository.findByOrder(order);
        ResponseDTO responseDTO = new ResponseDTO();
        for (OrderItem orderItem:
             orderItems) {

            String merchantId = orderItem.getOrderItemIdentity().getMerchantId();
            String productId = orderItem.getOrderItemIdentity().getProductId();
            String merchantURI = "https://merchant-lelo.herokuapp.com/merchant/rating/get/" + merchantId;
            RestTemplate restTemplate = new RestTemplate();
            Merchant merchantResult = restTemplate.getForObject(merchantURI, Merchant.class);
            String merchantName = merchantResult.getMerchantName();
            String ProductURI = "https://product-lelo.herokuapp.com/product/get/"+productId+"/"+merchantId;
            Product productResult = restTemplate.getForObject(ProductURI, Product.class);
            String productName = productResult.getName();
            String productURL = productResult.getImageUrl();
            int productQuantity = productResult.getQuantity();
            double productPrice = productResult.getPrice();
            String productDescription = productResult.getDescription();
            responseDTO.setRMerchantId(merchantId);
            responseDTO.setRMerchantName(merchantName);
            responseDTO.setRProductDescription(productDescription);
            responseDTO.setRProductId(productId);
            responseDTO.setRProductName(productName);
            responseDTO.setRProductPrice(productPrice);
            responseDTO.setRProductQuantity(productQuantity);
            responseDTO.setRProductURL(productURL);
            responseDTOList.add(responseDTO);

        }
        return responseDTOList;
    }
}
