package com.inditex.price.infrastructure.persistence.repository.productprice;

import com.inditex.price.infrastructure.persistence.dao.productprice.ProductPriceDAO;
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
class QueryProductPriceRepositoryImplTest {

    @InjectMocks
    private QueryProductPriceRepositoryImpl queryProductPriceRepository;

    @Mock
    private ProductPriceDAO productPriceDAO;

    @Test
    void should_beOk_when_searchProductPrice() {
        final var applicationDate = ProductPriceUtils.DEFAULT_APPLICATION_DATE;
        final var productId = ProductPriceUtils.DEFAULT_PRODUCT_ID;
        final var brandId = ProductPriceUtils.DEFAULT_BRAND_ID;
        final var productPricePO = ProductPriceUtils.GET.getDefaultPO();

        BDDMockito.given(productPriceDAO.search(applicationDate, productId.value(), brandId.value()))
                .willReturn(Optional.of(productPricePO));

        final var result = queryProductPriceRepository.search(applicationDate, productId, brandId);

        Assertions.assertThat(result).isNotNull();
        BDDMockito.verify(productPriceDAO).search(applicationDate, productId.value(), brandId.value());
    }

}