package com.lelo.ordermicroservice.dto;

public class ProductMerchantDTO {
    private String productId;
    private String merchantId;
    private double price;
    private int quantityOffered;
    private int quantitySold;
    private double discount;
    private double rating;
    private double ratingCounter;

    public ProductMerchantDTO() {
    }

    public ProductMerchantDTO(String productId, String merchantId, double price, int quantityOffered, int quantitySold, double discount, double rating, double ratingCounter) {
        this.productId = productId;
        this.merchantId = merchantId;
        this.price = price;
        this.quantityOffered = quantityOffered;
        this.quantitySold = quantitySold;
        this.discount = discount;
        this.rating = rating;
        this.ratingCounter = ratingCounter;
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

    public int getQuantityOffered() {
        return quantityOffered;
    }

    public void setQuantityOffered(int quantityOffered) {
        this.quantityOffered = quantityOffered;
    }

    public int getQuantitySold() {
        return quantitySold;
    }

    public void setQuantitySold(int quantitySold) {
        this.quantitySold = quantitySold;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public double getRatingCounter() {
        return ratingCounter;
    }

    public void setRatingCounter(double ratingCounter) {
        this.ratingCounter = ratingCounter;
    }

    @Override
    public String toString() {
        return "ProductMerchantDTO{" +
                "productId='" + productId + '\'' +
                ", merchantId='" + merchantId + '\'' +
                ", price=" + price +
                ", quantityOffered=" + quantityOffered +
                ", quantitySold=" + quantitySold +
                ", discount=" + discount +
                ", rating=" + rating +
                ", ratingCounter=" + ratingCounter +
                '}';
    }
}
