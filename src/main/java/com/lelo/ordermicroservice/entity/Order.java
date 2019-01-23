package com.lelo.ordermicroservice.entity;/* Made by: mehtakaran9 */

import com.fasterxml.jackson.annotation.JsonBackReference;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
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
    @Column(name = "order_date")
    private Date date;
    private double amount;
    @JsonBackReference
    @OneToMany(mappedBy = "order")
    private List<OrderItem> orderItems;

    public Order() {
    }
//    DateFormat dateFormat = new SimpleDateFormat("dd MMM yyyy HH:mm:ss");


    public Order(String orderId, List<OrderItem> orderItems, String customerId, Date date, double amount) {
        this.orderId = orderId;
        this.orderItems = orderItems;
        this.customerId = customerId;
//        this.date = dateFormat.format(new Date());
        this.date = date;
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

    public List<OrderItem> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(List<OrderItem> orderItems) {
        this.orderItems = orderItems;
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
