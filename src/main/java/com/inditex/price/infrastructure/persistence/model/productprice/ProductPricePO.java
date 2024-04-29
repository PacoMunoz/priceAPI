package com.inditex.price.infrastructure.persistence.model.productprice;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class ProductPricePO {
    private final String id;
    private final String brandId;
    private final LocalDateTime startDate;
    private final LocalDateTime endDate;
    private final Integer priceList;
    private final String productId;
    private final Integer priority;
    private final BigDecimal price;
    private final Integer currency;
}
