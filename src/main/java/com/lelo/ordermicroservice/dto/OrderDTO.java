package com.lelo.ordermicroservice.dto;/* Made by: mehtakaran9 */

import com.lelo.ordermicroservice.entity.OrderItem;
import javax.persistence.OneToMany;
import java.util.Date;
import java.util.List;

public class OrderDTO {

    private String orderId;

    @OneToMany(mappedBy = "order")
    private List<OrderItem> orderItems;

    private String customerId;
    private Date date;
    private double amount;

    public OrderDTO(String orderId, List<OrderItem> orderItems, String customerId, Date date, double amount) {
        this.orderId = orderId;
        this.orderItems = orderItems;
        this.customerId = customerId;
        this.date = new Date();
        this.amount = amount;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "OrderDTO{" +
                "orderId='" + orderId + '\'' +
                ", customerId='" + customerId + '\'' +
                ", date=" + date +
                ", amount=" + amount +
                '}';
    }
}
