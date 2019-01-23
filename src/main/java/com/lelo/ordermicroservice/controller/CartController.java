package com.lelo.ordermicroservice.controller;

import com.lelo.ordermicroservice.dto.CartDTO;
import com.lelo.ordermicroservice.dto.CartResponseDTO;
import com.lelo.ordermicroservice.entity.Cart;
import com.lelo.ordermicroservice.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cart")
@CrossOrigin("*")
public class CartController {
    @Autowired
    CartService cartService;

    @CrossOrigin("*")
    @RequestMapping(value = "/{customerId}/{productId}/{merchantId}",method = RequestMethod.POST)
    public ResponseEntity<Cart> addQuantity(@PathVariable String customerId, @PathVariable String productId,
                                            @PathVariable String merchantId, @RequestBody CartDTO cartDTO)
    {
        Cart cart = cartService.addQuantity(customerId,productId,merchantId,cartDTO.getQuantity());
        return new ResponseEntity<>(cart, HttpStatus.OK);

    }

    @CrossOrigin("*")
    @RequestMapping(value = "/{customerId}",method = RequestMethod.GET)
    public ResponseEntity<List<CartResponseDTO>> getByCustomerId(@PathVariable String customerId){
        List<CartResponseDTO> cartDTOList = cartService.getByCustomerId(customerId);
        return new ResponseEntity<List<CartResponseDTO>>(cartDTOList, HttpStatus.OK);

    }

    @CrossOrigin("*")
    @RequestMapping(value = "/delete/{customerId}",method = RequestMethod.DELETE)
    public ResponseEntity<Boolean> delete(@PathVariable String customerId ){
        cartService.delete(customerId);
        return new ResponseEntity<Boolean>(Boolean.TRUE, HttpStatus.OK);
    }

    @CrossOrigin("*")
    @RequestMapping(value = "/removeItem/{customerId}/{productId}/{merchantId}", method = RequestMethod.DELETE)
    public void removeItem(@PathVariable String customerId,@PathVariable String productId,
                           @PathVariable String merchantId){
        cartService.removeItem(customerId,productId,merchantId);
    }

    @CrossOrigin("*")
    @RequestMapping(value = "/update/{customerId}/{productId}/{merchantId}",method = RequestMethod.PUT)
    public ResponseEntity<Boolean> updateQuantity(@PathVariable String customerId,@PathVariable String productId,
                                                 @PathVariable String merchantId, @RequestBody CartDTO cartDTO){
        cartService.updateQuantity(customerId,productId,merchantId,cartDTO.getQuantity());
        return new ResponseEntity<Boolean>(Boolean.TRUE, HttpStatus.OK);
    }

}
