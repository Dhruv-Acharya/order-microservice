package com.lelo.ordermicroservice.controller;


import com.lelo.ordermicroservice.Utilities.CartList;
import com.lelo.ordermicroservice.dto.CartDTO;
import com.lelo.ordermicroservice.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cart")
public class CartController {
    @Autowired
    CartService cartService;

    @RequestMapping(value = "/{customerId}/{productId}/{merchantId}",method = RequestMethod.POST)
    public ResponseEntity<Boolean> addQuatity(@PathVariable String customerId, @PathVariable String productId,
                                              @PathVariable String merchantId,@RequestBody CartDTO cartDTO)
    {
        cartService.addQuantity(customerId,productId,merchantId,cartDTO.getQuantity());
        return new ResponseEntity<Boolean>(Boolean.TRUE, HttpStatus.OK);

    }


    @RequestMapping(value = "/{customerId}",method = RequestMethod.GET)
    public ResponseEntity<Boolean> getByCustomerId(@PathVariable String customerId){

        cartService.getByCustomerId(customerId);
        return new ResponseEntity<Boolean>(Boolean.TRUE, HttpStatus.OK);

    }

    @RequestMapping(value = "/delete/{cartId}",method = RequestMethod.DELETE)
    public ResponseEntity<Boolean> delete(@PathVariable String cartId ){

        cartService.delete(cartId);
        return new ResponseEntity<Boolean>(Boolean.TRUE, HttpStatus.OK);
    }

    @RequestMapping(value = "/update/{cartId}/{productId}/{merchantId}",method = RequestMethod.PUT)
    public ResponseEntity<Boolean> updateQuatity(@PathVariable String cartId,@PathVariable String productId,
                                                 @PathVariable String merchantId, @RequestBody CartDTO cartDTO){
        cartService.updateQuantity(cartId,productId,merchantId,cartDTO.getQuantity());
        return new ResponseEntity<Boolean>(Boolean.TRUE, HttpStatus.OK);
    }

    @RequestMapping(value = "get/{cartId}", method = RequestMethod.GET)
    public CartList getCartList(@PathVariable String cartId){
        return cartService.getCart(cartId);
    }
}
