package com.lelo.ordermicroservice.dto;

public class ProductDTO {
    private String productId;
    private String name;
    private String usp;
    private String description;
    private String imageUrl;
    private String categoryId;
    private double rating;
    private double ratingCounter;
    private double lowestPrice;
    private double highestPrice;

    public ProductDTO() {
    }

    public ProductDTO(String productId, String name, String usp, String description, String imageUrl, String categoryId, double rating, double ratingCounter, double lowestPrice, double highestPrice) {
        this.productId = productId;
        this.name = name;
        this.usp = usp;
        this.description = description;
        this.imageUrl = imageUrl;
        this.categoryId = categoryId;
        this.rating = rating;
        this.ratingCounter = ratingCounter;
        this.lowestPrice = lowestPrice;
        this.highestPrice = highestPrice;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsp() {
        return usp;
    }

    public void setUsp(String usp) {
        this.usp = usp;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
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

    public double getLowestPrice() {
        return lowestPrice;
    }

    public void setLowestPrice(double lowestPrice) {
        this.lowestPrice = lowestPrice;
    }

    public double getHighestPrice() {
        return highestPrice;
    }

    public void setHighestPrice(double highestPrice) {
        this.highestPrice = highestPrice;
    }
}