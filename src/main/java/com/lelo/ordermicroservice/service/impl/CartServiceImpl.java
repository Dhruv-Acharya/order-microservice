package com.lelo.ordermicroservice.service.impl;

import com.lelo.ordermicroservice.Utilities.CartList;
import com.lelo.ordermicroservice.Utilities.Merchant;
import com.lelo.ordermicroservice.Utilities.Product;
import com.lelo.ordermicroservice.entity.Cart;
import com.lelo.ordermicroservice.repository.CartRepository;
import com.lelo.ordermicroservice.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

@Service
@Transactional(readOnly = false)
public class CartServiceImpl implements CartService {

    @Autowired
    CartRepository cartRepository;

    @Autowired
    CartList cartList;

    @Override
    @Transactional(readOnly = true)
    public String getByCustomerId(String customerId) {
        Cart cart=cartRepository.findByCustomerId(customerId);
        return cart.getCartId();
    }

    @Override
    public void delete(String cartId) {
        cartRepository.delete(cartId);
    }

    @Override
    public void updateQuantity(String cartId, String productId, String merchantId, int quatity) {
        Cart cart=cartRepository.findByCartIdAndProductIdAndMerchantId(cartId,productId,merchantId);
        cart.setQuantity(quatity);
        cartRepository.save(cart);
    }

    @Override
    public CartList getCart(String cartId) {
        Cart cart=cartRepository.findByCartId(cartId);

        final String uriMerchant = "http://localhost:8080/merchant/get/"+cart.getMerchantId();
        RestTemplate restTemplateMerchant = new RestTemplate();
        Merchant merchant=restTemplateMerchant.getForObject(uriMerchant,Merchant.class);

        final String uriProduct = "http://localhost:8080/product/get/"+cart.getProductId() + "/"+cart.getMerchantId();
        RestTemplate restTemplateProduct = new RestTemplate();
        Product product = restTemplateProduct.getForObject(uriProduct, Product.class);

        cartList.setDescription(product.getDescription());
        cartList.setImageUrl(product.getImageUrl());
        cartList.setMerchant_id(cart.getMerchantId());
        cartList.setMerchantName(merchant.getMerchantName());
        cartList.setPrice(product.getPrice());
        cartList.setProduct_id(cart.getProductId());
        cartList.setProductName(product.getName());
        cartList.setQuantity(product.getQuantity());

        return cartList;
    }

    @Override
    public void addQuantity(String customerId, String productId, String merchantId, int quantity) {
        Cart cart=new Cart();
        cart.setQuantity(quantity);
        cart.setCustomerId(customerId);
        cart.setMerchantId(merchantId);
        cart.setProductId(productId);
        cartRepository.save(cart);
   }
}
