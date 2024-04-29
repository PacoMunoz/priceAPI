package com.inditex.price.infrastructure.persistence.repository.productprice;

import com.inditex.price.utils.ProductPriceUtils;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProductPriceMapperTest {

    @Test
    void should_mapper_to_domain() {
        final var result = ProductPriceMapper.TO.domain(ProductPriceUtils.GET.getDefaultPO());

        Assertions.assertThat(result.id()).isEqualTo(ProductPriceUtils.DEFAULT_ID);
        Assertions.assertThat(result.productId()).isEqualTo(ProductPriceUtils.DEFAULT_PRODUCT_ID);
        Assertions.assertThat(result.brandId()).isEqualTo(ProductPriceUtils.DEFAULT_BRAND_ID);
        Assertions.assertThat(result.startDate()).isEqualTo(ProductPriceUtils.DEFAULT_START_DATE);
        Assertions.assertThat(result.endDate()).isEqualTo(ProductPriceUtils.DEFAULT_END_DATE);
        Assertions.assertThat(result.priceList()).isEqualTo(ProductPriceUtils.DEFAULT_PRICE_LIST);
        Assertions.assertThat(result.priceList()).isEqualTo(ProductPriceUtils.DEFAULT_PRICE_LIST);
        Assertions.assertThat(result.price()).isEqualTo(ProductPriceUtils.DEFAULT_PRICE);
        Assertions.assertThat(result.currency()).isEqualTo(ProductPriceUtils.DEFAULT_CURRENCY);
    }

}