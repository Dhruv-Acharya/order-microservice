package com.lelo.ordermicroservice.entity;

import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Embeddable
public class CartIdentity implements Serializable {

    @NotNull
    private String customerId;
    @NotNull
    private String productId;
    @NotNull
    private String merchantId;

    public CartIdentity(){

    }

    public CartIdentity(String customerId,String productId,String merchantId)
    {
        this.customerId=customerId;
        this.merchantId=merchantId;
        this.productId=productId;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
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
