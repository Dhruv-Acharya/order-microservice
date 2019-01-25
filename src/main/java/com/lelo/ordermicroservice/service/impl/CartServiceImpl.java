package com.lelo.ordermicroservice.service.impl;

import com.lelo.ordermicroservice.Utilities.Constans;
import com.lelo.ordermicroservice.dto.CartResponseDTO;
import com.lelo.ordermicroservice.dto.MerchantDTO;
import com.lelo.ordermicroservice.dto.ProductDTO;
import com.lelo.ordermicroservice.dto.ProductMerchantDTO;
import com.lelo.ordermicroservice.entity.Cart;
import com.lelo.ordermicroservice.entity.CartIdentity;
import com.lelo.ordermicroservice.repository.CartRepository;
import com.lelo.ordermicroservice.repository.OrderRepository;
import com.lelo.ordermicroservice.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Iterator;
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
    public List<CartResponseDTO> getByCustomerId(String customerId) {
        List<Cart> cartDTOList;
        List<CartResponseDTO> responseDTOList = new ArrayList<>();
        cartDTOList = cartRepository.getByCustomerId(customerId);
        Iterator iterator = cartDTOList.iterator();
        while (iterator.hasNext()) {
            CartResponseDTO cartResponseDTO = new CartResponseDTO();
            Cart cartObj = (Cart) iterator.next();
            String merchantURI = Constans.MERCHANT_MICROSERVICE_BASE_URL + "/merchant/rating/get/" + cartObj.getCartIdentity().getMerchantId();
            RestTemplate restTemplate = new RestTemplate();
            MerchantDTO merchantResult = restTemplate.getForObject(merchantURI, MerchantDTO.class);

            cartResponseDTO.setMerchant_id(merchantResult.getMerchantId());
            cartResponseDTO.setMerchantName(merchantResult.getName());
            cartResponseDTO.setQuantity(cartObj.getQuantity());

            String productURI = Constans.PRODUCT_MICROSERVICE_BASE_URL + "/product/get/" + cartObj.getCartIdentity().getProductId();
            ProductDTO productResult = restTemplate.getForObject(productURI, ProductDTO.class);

            cartResponseDTO.setDescription(productResult.getDescription());
            cartResponseDTO.setImageUrl(productResult.getImageUrl());
            cartResponseDTO.setName(productResult.getName());
            cartResponseDTO.setProduct_id(productResult.getProductId());

            String productMerchantURI = Constans.PRODUCT_MICROSERVICE_BASE_URL + "/product/get/" + cartObj.getCartIdentity().getProductId() + "/" + cartObj.getCartIdentity().getMerchantId();
            ProductMerchantDTO productMerchantResult = restTemplate.getForObject(productMerchantURI, ProductMerchantDTO.class);

            cartResponseDTO.setPrice(productMerchantResult.getPrice());

            responseDTOList.add(cartResponseDTO);
        }
        return responseDTOList;
    }

    @Override
    public void delete(String customerId) {
        cartRepository.deleteByCustomerId(customerId);
    }

    @Override
    public void updateQuantity(String customerId, String productId, String merchantId, int quantity) {
        CartIdentity cartIdentity = new CartIdentity(customerId, productId, merchantId);
        Cart cart=cartRepository.findOne(cartIdentity);
        cart.setQuantity(quantity);
        cartRepository.save(cart);
    }

    @Override
    public void removeItem(String customerId, String productId, String merchantId) {
        CartIdentity cartIdentity = new CartIdentity();
        cartIdentity.setCustomerId(customerId);
        cartIdentity.setMerchantId(merchantId);
        cartIdentity.setProductId(productId);
        Cart cart = cartRepository.findOne(cartIdentity);
        cartRepository.delete(cart);
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
    public Cart addQuantity(String customerId, String productId, String merchantId, int quantity) {
        Cart cart=new Cart();
        CartIdentity cartIdentity = new CartIdentity();
        cartIdentity.setCustomerId(customerId);
        cartIdentity.setMerchantId(merchantId);
        cartIdentity.setProductId(productId);
        cart.setCartIdentity(cartIdentity);
        cart.setQuantity(quantity);
        cartRepository.save(cart);
        return cart;
   }
}
