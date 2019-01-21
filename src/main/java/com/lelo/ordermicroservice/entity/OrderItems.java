package com.lelo.ordermicroservice.entity;


import org.hibernate.annotations.GenericGenerator;
import org.springframework.http.ResponseEntity;

import javax.persistence.*;

@Entity
@Table(name = OrderItems.TABLE_NAME)
public class OrderItems {

    public static final String TABLE_NAME = "ORDER_ITEMS";
    private static final String ID_COLUMN = "ID";


    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @Column(name = OrderItems.ID_COLUMN)
    private String orderItemsId;
    private String productId;
    private String merchantId;
    private double price;
    private int quantity;


    public ResponseEntity<String> getOrderItemsId() {
        return orderItemsId;
    }

    public void setOrderItemsId(String orderItemsId) {
        this.orderItemsId = orderItemsId;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getMerchantId() {
        return merchantId;
    }

    public void setMerchantId(String merchantId) {
        this.merchantId = merchantId;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
