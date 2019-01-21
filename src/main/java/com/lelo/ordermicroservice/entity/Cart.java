package com.lelo.ordermicroservice.entity;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = Cart.TABLE_NAME)
public class Cart {

    public static final String TABLE_NAME = "CART";

    @EmbeddedId
    CartIdentity cartIdentity;

    private int quantity;

    public Cart() {
    }

    public CartIdentity getCartIdentity() {
        return cartIdentity;
    }

    public void setCartIdentity(CartIdentity cartIdentity) {
        this.cartIdentity = cartIdentity;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
