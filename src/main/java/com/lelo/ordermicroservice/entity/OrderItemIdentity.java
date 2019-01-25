package com.lelo.ordermicroservice.entity;/* Made by: mehtakaran9 */

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Embeddable
public class OrderItemIdentity implements Serializable {
    @NotNull
    private String productId;
    @NotNull
    private String merchantId;
    @Column(name = "order_id", nullable = false, updatable = false)
    private String orderId;

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
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
