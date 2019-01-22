package com.lelo.ordermicroservice.dto;

public class MerchantDTO {
    private String merchantId;
    private String name;
    private String emailId;
    private double rating;

    public MerchantDTO() {
    }

    public MerchantDTO(String merchantId, String name, String emailId, double rating) {
        this.merchantId = merchantId;
        this.name = name;
        this.emailId = emailId;
        this.rating = rating;
    }

    public String getMerchantId() {
        return merchantId;
    }

    public void setMerchantId(String merchantId) {
        this.merchantId = merchantId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }
}