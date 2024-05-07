package com.inditex.price.application.productprice.search;

import io.reflectoring.model.ProductPriceDTO;

import java.time.LocalDateTime;

public interface SearchProductPrice {
    ProductPriceDTO search(LocalDateTime applicationDate, String productId, String brandId);
}
