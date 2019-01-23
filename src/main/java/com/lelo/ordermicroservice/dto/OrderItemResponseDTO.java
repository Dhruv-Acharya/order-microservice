package com.lelo.ordermicroservice.dto;/* Made by: mehtakaran9 */

public class OrderItemResponseDTO {
    private String productId;
    private String productDescription;
    private String productImageUrl;
    private String productName;
    private int productQuantity;
    private String merchantName;
    private String merchantId;
    private double productPrice;

    public OrderItemResponseDTO() {
    }

    public OrderItemResponseDTO(String productId, String productDescription, String productImageUrl, String productName, int productQuantity, String merchantName, String merchantId, double productPrice) {
        this.productId = productId;
        this.productDescription = productDescription;
        this.productImageUrl = productImageUrl;
        this.productName = productName;
        this.productQuantity = productQuantity;
        this.merchantName = merchantName;
        this.merchantId = merchantId;
        this.productPrice = productPrice;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public String getProductImageUrl() {
        return productImageUrl;
    }

    public void setProductImageUrl(String productImageUrl) {
        this.productImageUrl = productImageUrl;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getProductQuantity() {
        return productQuantity;
    }

    public void setProductQuantity(int productQuantity) {
        this.productQuantity = productQuantity;
    }

    public String getMerchantName() {
        return merchantName;
    }

    public void setMerchantName(String merchantName) {
        this.merchantName = merchantName;
    }

    public String getMerchantId() {
        return merchantId;
    }

    public void setMerchantId(String merchantId) {
        this.merchantId = merchantId;
    }

    public double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(double productPrice) {
        this.productPrice = productPrice;
    }
}
