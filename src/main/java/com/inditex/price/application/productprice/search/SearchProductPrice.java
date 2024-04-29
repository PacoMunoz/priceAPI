package com.inditex.price.application.productprice.search;

import com.inditex.price.application.productprice.dto.ProductPriceDTO;

import java.time.LocalDateTime;

public interface SearchProductPrice {
    ProductPriceDTO search(LocalDateTime applicationDate, String productId, String brandId);
}
