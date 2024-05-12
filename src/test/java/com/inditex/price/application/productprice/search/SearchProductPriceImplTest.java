package com.inditex.price.application.productprice.search;

import com.inditex.application.productprice.dto.ProductPriceDTO;
import com.inditex.price.domain.productprice.service.QueryProductPrice;
import com.inditex.price.utils.ProductPriceUtils;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

@ExtendWith(MockitoExtension.class)
class SearchProductPriceImplTest {

    @InjectMocks
    private SearchProductPriceImpl searchProductPrice;

    @Mock
    private QueryProductPrice queryProductPrice;

    @Test
    void should_beOk_when_searchProductPrice() {
        final var productPrice = ProductPriceUtils.GET.defaultDomain().build();
        final var applicationDate = ProductPriceUtils.DEFAULT_APPLICATION_DATE;

        BDDMockito.given(queryProductPrice.search(applicationDate, productPrice.productId(), productPrice.brandId()))
                .willReturn(Optional.of(productPrice));

        final var result = searchProductPrice.search(applicationDate, productPrice.productId().value(), productPrice.brandId().value());

        Assertions.assertThat(result).isNotNull().isInstanceOf(ProductPriceDTO.class);;
        BDDMockito.verify(queryProductPrice).search(applicationDate, productPrice.productId(), productPrice.brandId());
    }
}