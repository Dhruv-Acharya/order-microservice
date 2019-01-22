package com.lelo.ordermicroservice.dto;

public class OrderItemDTO {
    private String orderItemsId;
    private String productId;
    private String merchantId;
    private double price;
    private int quantity;


    public String getOrderItemsId() {
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
