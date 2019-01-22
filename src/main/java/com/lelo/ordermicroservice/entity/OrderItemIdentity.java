package com.lelo.ordermicroservice.entity;/* Made by: mehtakaran9 */

import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Embeddable
public class OrderItemIdentity implements Serializable {
    @NotNull
    private String productId;
    @NotNull
    private String merchantId;

    public OrderItemIdentity() {

    }

    public OrderItemIdentity(String productId, String merchantId) {
        this.productId = productId;
        this.merchantId = merchantId;
    }

    @Override
    public String toString() {
        return "OrderItemIdentity{" +
                "productId='" + productId + '\'' +
                ", merchantId='" + merchantId + '\'' +
                '}';
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
}
