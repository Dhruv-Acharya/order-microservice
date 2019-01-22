package com.lelo.ordermicroservice.dto;/* Made by: mehtakaran9 */

public class ResponseDTO {
    private String RProductId;
    private String RProductDescription;
    private String RProductURL;
    private String RProductName;
    private double RProductLowestPrice;
    private double RProductHighestPrice;
    private int RProductQuantity;
    private String RMerchantName;
    private String RMerchantId;

    @Override
    public String toString() {
        return "ResponseDTO{" +
                "RProductId='" + RProductId + '\'' +
                ", RProductDescription='" + RProductDescription + '\'' +
                ", RProductURL='" + RProductURL + '\'' +
                ", RProductName='" + RProductName + '\'' +
                ", RProductLowestPrice=" + RProductLowestPrice +
                ", RProductHighestPrice=" + RProductHighestPrice +
                ", RProductQuantity=" + RProductQuantity +
                ", RMerchantName='" + RMerchantName + '\'' +
                ", RMerchantId='" + RMerchantId + '\'' +
                '}';
    }

    public String getRProductId() {
        return RProductId;
    }

    public void setRProductId(String RProductId) {
        this.RProductId = RProductId;
    }

    public String getRProductDescription() {
        return RProductDescription;
    }

    public void setRProductDescription(String RProductDescription) {
        this.RProductDescription = RProductDescription;
    }

    public String getRProductURL() {
        return RProductURL;
    }

    public void setRProductURL(String RProductURL) {
        this.RProductURL = RProductURL;
    }

    public String getRProductName() {
        return RProductName;
    }

    public void setRProductName(String RProductName) {
        this.RProductName = RProductName;
    }

    public double getRProductLowestPrice() {
        return RProductLowestPrice;
    }

    public void setRProductLowestPrice(double RProductLowestPrice) {
        this.RProductLowestPrice = RProductLowestPrice;
    }

    public double getRProductHighestPrice() {
        return RProductHighestPrice;
    }

    public void setRProductHighestPrice(double RProductHighestPrice) {
        this.RProductHighestPrice = RProductHighestPrice;
    }

    public int getRProductQuantity() {
        return RProductQuantity;
    }

    public void setRProductQuantity(int RProductQuantity) {
        this.RProductQuantity = RProductQuantity;
    }

    public String getRMerchantName() {
        return RMerchantName;
    }

    public void setRMerchantName(String RMerchantName) {
        this.RMerchantName = RMerchantName;
    }

    public String getRMerchantId() {
        return RMerchantId;
    }

    public void setRMerchantId(String RMerchantId) {
        this.RMerchantId = RMerchantId;
    }
}
