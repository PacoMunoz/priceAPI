package com.inditex.price.domain.productprice.service;

import com.inditex.price.domain.productprice.repository.QueryProductPriceRepository;
import com.inditex.price.utils.ProductPriceUtils;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class QueryProductPriceImplTest {

    @InjectMocks
    private QueryProductPriceImpl queryProductPrice;

    @Mock
    private QueryProductPriceRepository queryProductPriceRepository;

    @Test
    void should_queryProductPrice() {
        // given
        final var applicationDate = ProductPriceUtils.DEFAULT_APPLICATION_DATE;
        final var productId = ProductPriceUtils.DEFAULT_PRODUCT_ID;
        final var brandId = ProductPriceUtils.DEFAULT_BRAND_ID;
        // when
        final var result = queryProductPrice.search(applicationDate, productId, brandId);
        // then
        BDDMockito.verify(queryProductPriceRepository).search(applicationDate, productId, brandId);
    }

}