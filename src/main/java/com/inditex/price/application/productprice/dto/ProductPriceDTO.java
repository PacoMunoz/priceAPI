package com.inditex.price.application.productprice.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class ProductPriceDTO {

    private String productId;
    private String brandId;
    private Integer priceList;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private BigDecimal price;

    public ProductPriceDTO(String productId, String brandId, Integer priceList, LocalDateTime startDate, LocalDateTime endDate, BigDecimal price) {
        this.productId = productId;
        this.brandId = brandId;
        this.priceList = priceList;
        this.startDate = startDate;
        this.endDate = endDate;
        this.price = price;
    }

    public String getProductId() {
        return productId;
    }

    public String getBrandId() {
        return brandId;
    }

    public Integer getPriceList() {
        return priceList;
    }

    public LocalDateTime getStartDate() {
        return startDate;
    }

    public LocalDateTime getEndDate() {
        return endDate;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public void setBrandId(String brandId) {
        this.brandId = brandId;
    }

    public void setPriceList(Integer priceList) {
        this.priceList = priceList;
    }

    public void setStartDate(LocalDateTime startDate) {
        this.startDate = startDate;
    }

    public void setEndDate(LocalDateTime endDate) {
        this.endDate = endDate;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
