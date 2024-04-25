package com.inditex.price.application.productprice.dto;

import java.time.LocalDateTime;

public class ProductPriceCriteriaDTO {
    private LocalDateTime applicationDate;
    private String productId;
    private String brandId;

    public ProductPriceCriteriaDTO(LocalDateTime applicationDate, String productId, String brandId) {
        this.applicationDate = applicationDate;
        this.productId = productId;
        this.brandId = brandId;
    }

    public LocalDateTime getApplicationDate() {
        return applicationDate;
    }

    public String getProductId() {
        return productId;
    }

    public String getBrandId() {
        return brandId;
    }

    public void setApplicationDate(LocalDateTime applicationDate) {
        this.applicationDate = applicationDate;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public void setBrandId(String brandId) {
        this.brandId = brandId;
    }
}
