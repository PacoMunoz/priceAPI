package com.inditex.price.utils;

import com.inditex.price.application.productprice.dto.ProductPriceDTO;
import com.inditex.price.domain.productprice.entity.Currency;
import com.inditex.price.domain.productprice.entity.ProductPrice;
import com.inditex.price.domain.productprice.entity.Uuid;
import com.inditex.price.infrastructure.persistence.model.productprice.ProductPricePO;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public enum ProductPriceUtils {

    GET;

    public static final Uuid DEFAULT_ID = new Uuid("c00d55d6-90c4-4a79-bd93-58eca13cf2cd");
    public static final Uuid DEFAULT_PRODUCT_PRICE_ID = new Uuid("c53dfc71-78a6-4420-8b1f-55f8a7e9409c");
    public static final Uuid DEFAULT_BRAND_ID = new Uuid("aabe2a5c-d25d-4988-b60b-9a32e2a9b8a2");
    public static final Uuid DEFAULT_PRODUCT_ID = new Uuid("3799775a-ee85-4244-8441-3a2f3b93d8a8");
    public static final LocalDateTime DEFAULT_START_DATE = LocalDateTime.now().minusHours(1);
    public static final LocalDateTime DEFAULT_APPLICATION_DATE = LocalDateTime.now();
    public static final LocalDateTime DEFAULT_END_DATE = LocalDateTime.now().plusHours(1);
    public static final BigDecimal DEFAULT_PRICE = new BigDecimal(12);
    public static final Integer DEFAULT_PRICE_LIST = 14;
    public static final Integer DEFAULT_PRIORITY = 1;
    public static final Currency DEFAULT_CURRENCY = Currency.EUR;

    public ProductPrice.Builder defaultDomain() {
        return new ProductPrice.Builder(DEFAULT_PRODUCT_PRICE_ID)
                .brandId(DEFAULT_BRAND_ID)
                .productId(DEFAULT_PRODUCT_ID)
                .price(DEFAULT_PRICE)
                .priceList(DEFAULT_PRICE_LIST)
                .startDate(DEFAULT_START_DATE)
                .endDate(DEFAULT_END_DATE)
                .currency(Currency.EUR);
    }

    public ProductPriceDTO getDefaultDTO() {
        return new ProductPriceDTO(DEFAULT_PRODUCT_ID.value(), DEFAULT_BRAND_ID.value(),
                DEFAULT_PRICE_LIST, DEFAULT_START_DATE, DEFAULT_END_DATE, DEFAULT_PRICE);
    }

    public ProductPricePO getDefaultPO() {
        return new ProductPricePO(DEFAULT_ID.value(), DEFAULT_BRAND_ID.value(), DEFAULT_START_DATE, DEFAULT_END_DATE, DEFAULT_PRICE_LIST
                , DEFAULT_PRODUCT_ID.value(), DEFAULT_PRIORITY, DEFAULT_PRICE, DEFAULT_CURRENCY.code());
    }
}
