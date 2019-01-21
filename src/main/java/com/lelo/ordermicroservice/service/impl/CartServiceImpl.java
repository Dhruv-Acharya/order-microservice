package com.lelo.ordermicroservice.service.impl;

import com.lelo.ordermicroservice.dto.CartDTO;
import com.lelo.ordermicroservice.entity.Cart;
import com.lelo.ordermicroservice.entity.CartIdentity;
import com.lelo.ordermicroservice.repository.CartRepository;
import com.lelo.ordermicroservice.repository.OrderRepository;
import com.lelo.ordermicroservice.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = false)
public class CartServiceImpl implements CartService {

    @Autowired
    OrderRepository orderRepository;

    @Autowired
    CartRepository cartRepository;

    @Override
    @Transactional(readOnly = true)
    public List<CartDTO> getByCustomerId(String customerId) {
        List<CartDTO> cartDTOList = cartRepository.getByCustomerId(customerId);
        return cartDTOList;
        }

    @Override
    public void delete(String customerId) {
        cartRepository.delete(customerId);
    }

    @Override
    public void updateQuantity(String customerId, String productId, String merchantId, int quantity) {
        Cart cart=cartRepository.findByCustomertIdAndProductIdAndMerchantId(customerId,productId,merchantId);
        cart.setQuantity(quantity);
        cartRepository.save(cart);
    }

//    @Override
//    public CartList getCart(String customerId) {
//        List<CartDTO> cartDTOList = cartRepository.findByCustomerId(customerId);
//
//        final String uriMerchant = "http://localhost:8080/merchant/get/"+cartIdentity.getMerchantId();
//        RestTemplate restTemplateMerchant = new RestTemplate();
//        Merchant merchant=restTemplateMerchant.getForObject(uriMerchant,Merchant.class);
//
//        final String uriProduct = "http://localhost:8080/product/get/"+cartIdentity.getProductId() + "/"+cartIdentity.getMerchantId();
//        RestTemplate restTemplateProduct = new RestTemplate();
//        Product product = restTemplateProduct.getForObject(uriProduct, Product.class);
//
//        cartList.setDescription(product.getDescription());
//        cartList.setImageUrl(product.getImageUrl());
//        cartList.setMerchant_id(cartIdentity.getMerchantId());
//        cartList.setMerchantName(merchant.getMerchantName());
//        cartList.setPrice(product.getPrice());
//        cartList.setProduct_id(cartIdentity.getProductId());
//        cartList.setProductName(product.getName());
//        cartList.setQuantity(product.getQuantity());
//
//        return cartList;
//    }

    @Override
    public void addQuantity(String customerId, String productId, String merchantId, int quantity) {
        Cart cart=new Cart();
        CartIdentity cartIdentity = new CartIdentity();
        cartIdentity.setCustomerId(customerId);
        cartIdentity.setMerchantId(merchantId);
        cartIdentity.setProductId(productId);
        cart.setCartIdentity(cartIdentity);
        cart.setQuantity(quantity);
        cartRepository.save(cart);
   }
}
