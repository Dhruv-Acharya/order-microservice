package com.lelo.ordermicroservice.service.impl;/* Made by: mehtakaran9 */

import com.lelo.ordermicroservice.Utilities.Constans;
import com.lelo.ordermicroservice.dto.*;
import com.lelo.ordermicroservice.entity.Cart;
import com.lelo.ordermicroservice.entity.Order;
import com.lelo.ordermicroservice.entity.OrderItem;
import com.lelo.ordermicroservice.entity.OrderItemIdentity;
import com.lelo.ordermicroservice.repository.CartRepository;
import com.lelo.ordermicroservice.repository.OrderItemRepository;
import com.lelo.ordermicroservice.repository.OrderRepository;
import com.lelo.ordermicroservice.service.CartService;
import com.lelo.ordermicroservice.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
@Service
public class OrderServiceImpl implements OrderService {
    DateFormat dateFormat = new SimpleDateFormat("dd MMM yyyy HH:mm:ss");

    @Autowired
    private CartRepository cartRepository;

    @Autowired
    CartService cartService;
    
    @Autowired
    private OrderItemRepository orderItemRepository;
    
    @Autowired
    private OrderRepository orderRepository;

    @Override
    public String getEmailId(String customerId){
        String customerURI = "https://customer-lelo.herokuapp.com/customer/get/"+customerId;
        RestTemplate restTemplate = new RestTemplate();
        String emailIdResult = restTemplate.getForObject(customerURI, String.class);
        return emailIdResult;
    }

    @Override
    public Order addOrder(String customerId) {
        Order order = new Order();
        order.setCustomerId(customerId);
//        String dateOrder = dateFormat.format(new Date());
        order.setDate(new Date());
        Order createOrder = orderRepository.save(order);
        double totalAmount = 0;
        List<CartResponseDTO> cartItems = cartService.getByCustomerId(customerId);
        for (CartResponseDTO cartItem :
                cartItems) {
            OrderItem orderItem = new OrderItem();
            orderItem.setOrder(order);
            orderItem.setQuantity(cartItem.getQuantity());
            OrderItemIdentity orderItemIdentity = new OrderItemIdentity();
            orderItemIdentity.setMerchantId(cartItem.getMerchant_id());
            orderItemIdentity.setProductId(cartItem.getProduct_id());
            orderItem.setOrderItemIdentity(orderItemIdentity);
            String productURI = Constans.PRODUCT_MICROSERVICE_BASE_URL + "/product/get/"+cartItem.getProduct_id() + "/" + cartItem.getMerchant_id();
            RestTemplate restTemplate = new RestTemplate();
            ProductMerchantDTO productResult = restTemplate.getForObject(productURI, ProductMerchantDTO.class);
            totalAmount += productResult.getPrice() * cartItem.getQuantity();
            orderItem.setPrice(productResult.getPrice());
            orderItemRepository.save(orderItem);
//
//            String productQuantityURI = Constans.PRODUCT_MICROSERVICE_BASE_URL + "/product/get/"+cartItem.getCartIdentity().getProductId() + "/" + cartItem.getCartIdentity().getMerchantId();
////            RestTemplate restTemplate = new RestTemplate();
////            ProductMerchantDTO productResult = restTemplate.getForObject(productURI, ProductMerchantDTO.class);
        }
        cartService.delete(customerId);
        order.setAmount(totalAmount);
        orderRepository.save(order);
        return order;
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
    public List<OrderItemResponseDTO> getOrderAll(String orderId){
        List<OrderItemResponseDTO> orderItemResponseDTOList = new ArrayList<>();
        Order order = orderRepository.findOne(orderId);

        List<OrderItem> orderItems = orderItemRepository.findByOrder(order);

        for (OrderItem orderItem:
             orderItems) {
            OrderItemResponseDTO orderItemResponseDTO = new OrderItemResponseDTO();
            String merchantId = orderItem.getOrderItemIdentity().getMerchantId();
            String productId = orderItem.getOrderItemIdentity().getProductId();
            String merchantURI = Constans.MERCHANT_MICROSERVICE_BASE_URL + "/merchant/rating/get/" + merchantId;
            RestTemplate restTemplate = new RestTemplate();
            MerchantDTO merchantResult = restTemplate.getForObject(merchantURI, MerchantDTO.class);

            orderItemResponseDTO.setMerchantId(merchantResult.getMerchantId());
            orderItemResponseDTO.setMerchantName(merchantResult.getName());

            String productURI = Constans.PRODUCT_MICROSERVICE_BASE_URL + "/product/get/"+productId;
            ProductDTO productResult = restTemplate.getForObject(productURI, ProductDTO.class);

            orderItemResponseDTO.setProductDescription(productResult.getDescription());
            orderItemResponseDTO.setProductId(productResult.getProductId());
            orderItemResponseDTO.setProductImageUrl(productResult.getImageUrl());
            orderItemResponseDTO.setProductName(productResult.getName());

//            String productMerchantURI = Constans.PRODUCT_MICROSERVICE_BASE_URL + "/product/get/" + productId + "/" + merchantId;
//            ProductMerchantDTO productMerchantResult = restTemplate.getForObject(productMerchantURI, ProductMerchantDTO.class);

            orderItemResponseDTO.setProductPrice(orderItem.getPrice());
            orderItemResponseDTO.setProductQuantity(orderItem.getQuantity());

//            orderItemResponseDTO.setProductPrice(productResult.get);
//            String merchantId = orderItem.getOrderItemIdentity().getMerchantId();
//            String productId = orderItem.getOrderItemIdentity().getProductId();
//            String merchantURI = "https://merchant-lelo.herokuapp.com/merchant/rating/get/" + merchantId;
//            RestTemplate restTemplate = new RestTemplate();
//            MerchantDTO merchantResult = restTemplate.getForObject(merchantURI, MerchantDTO.class);
//            String merchantName = merchantResult.getName();
//            String productMerchantURI = "https://product-lelo.herokuapp.com/product/get/"+productId+"/"+merchantId;
//            ProductDTO productResult = restTemplate.getForObject(productMerchantURI, ProductDTO.class);
//            String productName = productResult.getName();
//            String productImageURL = productResult.getImageUrl();
//
//            String productDescription = productResult.getDescription();
//            orderItemResponseDTO.setRMerchantId(merchantId);
//            orderItemResponseDTO.setRMerchantName(merchantName);
//            orderItemResponseDTO.setRProductDescription(productDescription);
//            orderItemResponseDTO.setRProductId(productId);
//            orderItemResponseDTO.setRProductName(productName);
//            orderItemResponseDTO.setRProductURL(productImageURL);
            System.out.println(orderItemResponseDTO);
            orderItemResponseDTOList.add(orderItemResponseDTO);

        }
        return orderItemResponseDTOList;
    }
}
