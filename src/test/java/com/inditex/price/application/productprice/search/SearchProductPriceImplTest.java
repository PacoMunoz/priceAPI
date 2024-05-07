package com.inditex.price.application.productprice.search;

import com.inditex.application.productprice.dto.ProductPriceDTO;
import com.inditex.price.application.ApplicationException;
import com.inditex.price.domain.productprice.repository.QueryProductPriceRepository;
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
    private QueryProductPriceRepository queryProductPriceRepository;

    @Test
    void should_throwException_when_productIdIsNull() {
        final var expectedThrow = Assertions.catchThrowable(
                () -> searchProductPrice.search(ProductPriceUtils.DEFAULT_APPLICATION_DATE,
                        null, ProductPriceUtils.DEFAULT_BRAND_ID.value())
        );

        Assertions.assertThat(expectedThrow).isInstanceOf(ApplicationException.class).hasMessage("El id del producto es requerido");
    }

    @Test
    void should_throwException_when_applicationDateNull() {
        final var expectedThrow = Assertions.catchThrowable(
                () -> searchProductPrice.search(null, ProductPriceUtils.DEFAULT_PRODUCT_ID.value(),
                        ProductPriceUtils.DEFAULT_BRAND_ID.value()));

        Assertions.assertThat(expectedThrow).isInstanceOf(ApplicationException.class).hasMessage("El campo fecha de aplicacion es requerido");
    }

    @Test
    void should_throwException_when_brandIdIsNull() {
        final var expectedThrow = Assertions.catchThrowable(
                () -> searchProductPrice.search(ProductPriceUtils.DEFAULT_APPLICATION_DATE,
                        ProductPriceUtils.DEFAULT_PRODUCT_ID.value(), null));

        Assertions.assertThat(expectedThrow).isInstanceOf(ApplicationException.class).hasMessage("El id de la marca es requerido");
    }

    @Test
    void should_beOk_when_searchProductPrice() {
        final var productPrice = ProductPriceUtils.GET.defaultDomain().build();
        final var applicationDate = ProductPriceUtils.DEFAULT_APPLICATION_DATE;

        BDDMockito.given(queryProductPriceRepository.search(applicationDate, productPrice.productId(), productPrice.brandId()))
                .willReturn(Optional.of(productPrice));

        final var result = searchProductPrice.search(applicationDate, productPrice.productId().value(), productPrice.brandId().value());

        Assertions.assertThat(result).isNotNull().isInstanceOf(ProductPriceDTO.class);;
        BDDMockito.verify(queryProductPriceRepository).search(applicationDate, productPrice.productId(), productPrice.brandId());
    }
}