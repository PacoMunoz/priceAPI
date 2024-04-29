package com.inditex.price.application.productprice.search;

import com.inditex.price.utils.ProductPriceUtils;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class GetProductPriceDTOTest {

    @Test
    void should_mapProperlyFromDomain() {
        final var defaultDomain = ProductPriceUtils.GET.defaultDomain().build();

        final var result = GetProductPriceDTO.FROM.domain(defaultDomain);

        Assertions.assertThat(result).isNotNull();
        Assertions.assertThat(result.getPrice()).isEqualTo(ProductPriceUtils.DEFAULT_PRICE.value());
        Assertions.assertThat(result.getProductId()).isEqualTo(ProductPriceUtils.DEFAULT_PRODUCT_ID.value());
        Assertions.assertThat(result.getBrandId()).isEqualTo(ProductPriceUtils.DEFAULT_BRAND_ID.value());
        Assertions.assertThat(result.getEndDate()).isEqualTo(ProductPriceUtils.DEFAULT_END_DATE);
        Assertions.assertThat(result.getStartDate()).isEqualTo(ProductPriceUtils.DEFAULT_START_DATE);
    }

}