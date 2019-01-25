package com.lelo.ordermicroservice.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;

@Entity
@Table(name = OrderItem.TABLE_NAME)
public class OrderItem {

    public static final String TABLE_NAME = "ORDER_ITEM";
    @EmbeddedId
    OrderItemIdentity orderItemIdentity;
    private double price;
    private int quantity;
    @ManyToOne
    @JoinColumn(name = "order_id", insertable = false, updatable = false)
    private Order order;

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public OrderItemIdentity getOrderItemIdentity() {
        return orderItemIdentity;
    }

    public void setOrderItemIdentity(OrderItemIdentity orderItemIdentity) {
        this.orderItemIdentity = orderItemIdentity;
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
