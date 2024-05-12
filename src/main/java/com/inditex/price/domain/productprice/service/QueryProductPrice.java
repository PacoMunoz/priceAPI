package com.inditex.price.domain.productprice.service;

import com.inditex.price.domain.productprice.entity.ProductPrice;
import com.inditex.price.domain.productprice.entity.Uuid;

import java.time.LocalDateTime;
import java.util.Optional;

public interface QueryProductPrice {
    Optional<ProductPrice> search(LocalDateTime applicationDate, Uuid productId, Uuid brandId);
}
