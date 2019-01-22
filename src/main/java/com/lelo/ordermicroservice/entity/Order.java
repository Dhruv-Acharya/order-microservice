package com.lelo.ordermicroservice.entity;/* Made by: mehtakaran9 */

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = Order.TABLE_NAME)
public class Order {
    public static final String TABLE_NAME = "TABLE_ORDER";
    private static final String ID_COLUMN = "ID";

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @Column(name = Order.ID_COLUMN)
    private String orderId;

    private String customerId;
    private Date date;
    private double amount;
    @OneToMany(mappedBy = "order")
    private List<OrderItem> orderItems;

    public Order() {
    }

    public Order(String orderId, List<OrderItem> orderItems, String customerId, Date date, double amount) {
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
        return "Order{" +
                "orderId='" + orderId + '\'' +
                ", customerId='" + customerId + '\'' +
                ", date=" + date +
                ", amount=" + amount +
                '}';
    }
}
