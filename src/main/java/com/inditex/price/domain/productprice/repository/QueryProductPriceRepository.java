package com.inditex.price.domain.productprice.repository;

import com.inditex.price.domain.productprice.entity.ProductPrice;
import com.inditex.price.domain.productprice.entity.Uuid;

import java.time.LocalDateTime;

public interface QueryProductPriceRepository {
    ProductPrice byCriteria(LocalDateTime applicationDate, Uuid productId, Uuid brandId);
}
