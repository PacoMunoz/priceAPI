package com.inditex.price.application.productprice.search;

import com.inditex.price.application.ApplicationException;
import com.inditex.price.domain.productprice.entity.Uuid;
import com.inditex.price.domain.productprice.repository.QueryProductPriceRepository;
import com.inditex.price.utils.ProductPriceUtils;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class SearchProductPriceImplTest {

    @InjectMocks
    private SearchProductPriceImpl searchProductPrice;

    @Mock
    private QueryProductPriceRepository queryProductPriceRepository;

    @Test
    void should_throwException_when_productIdIsNull() {
        final var criteria = ProductPriceUtils.GET.getDefaultCriteria();
        criteria.setProductId(null);

        final var expectedThrow = Assertions.catchThrowable(() -> searchProductPrice.byCriteria(criteria));

        Assertions.assertThat(expectedThrow).isInstanceOf(ApplicationException.class).hasMessage("El id del producto es requerido");
    }

    @Test
    void should_throwException_when_applicationDateNull() {
        final var criteria = ProductPriceUtils.GET.getDefaultCriteria();
        criteria.setApplicationDate(null);

        final var expectedThrow = Assertions.catchThrowable(() -> searchProductPrice.byCriteria(criteria));

        Assertions.assertThat(expectedThrow).isInstanceOf(ApplicationException.class).hasMessage("El campo fecha de aplicacion es requerido");
    }

    @Test
    void should_throwException_when_brandIdIsNull() {
        final var criteria = ProductPriceUtils.GET.getDefaultCriteria();
        criteria.setBrandId(null);

        final var expectedThrow = Assertions.catchThrowable(() -> searchProductPrice.byCriteria(criteria));

        Assertions.assertThat(expectedThrow).isInstanceOf(ApplicationException.class).hasMessage("El id de la marca es requerido");
    }

    @Test
    void should_beOk_when_searchProductPrice() {
        final var criteria = ProductPriceUtils.GET.getDefaultCriteria();
        final var productPrice = ProductPriceUtils.GET.defaultDomain().build();
        BDDMockito.given(queryProductPriceRepository.byCriteria(
                criteria.getApplicationDate(),
                new Uuid(criteria.getProductId()),
                new Uuid(criteria.getBrandId()))
        ).willReturn(productPrice);

        final var result = searchProductPrice.byCriteria(criteria);

        Assertions.assertThat(result).isNotNull();
        Assertions.assertThat(result.getStartDate()).isBeforeOrEqualTo(criteria.getApplicationDate());
        Assertions.assertThat(result.getEndDate()).isAfterOrEqualTo(criteria.getApplicationDate());
        Assertions.assertThat(result.getProductId()).isEqualTo(criteria.getProductId());
        Assertions.assertThat(result.getBrandId()).isEqualTo(criteria.getBrandId());
    }
}