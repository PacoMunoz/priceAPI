package com.inditex.price.domain.entity.productprice;

import com.inditex.price.domain.DomainException;
import com.inditex.price.utils.ProductPriceUtils;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

class ProductPriceTest {

    @Test
    void should_throwError_when_startDateIsNull() {
        final var expectedThrow = Assertions.catchThrowable(
                () -> ProductPriceUtils.GET.defaultDomain().startDate(null).build()
        );

        Assertions.assertThat(expectedThrow).isInstanceOf(DomainException.class)
                .hasMessage("La fecha de inicio del precio de producto es requerida");
    }

    @Test
    void should_throwError_when_brandIdIsNull() {
        final var expectedThrow = Assertions.catchThrowable(
                () -> ProductPriceUtils.GET.defaultDomain().brandId(null).build()
        );

        Assertions.assertThat(expectedThrow).isInstanceOf(DomainException.class)
                .hasMessage("El id de la marca del precio de producto es requerida");
    }

    @Test
    void should_throwError_when_endDateIsNull() {
        final var expectedThrow = Assertions.catchThrowable(
                () -> ProductPriceUtils.GET.defaultDomain().endDate(null).build()
        );

        Assertions.assertThat(expectedThrow).isInstanceOf(DomainException.class)
                .hasMessage("La fecha de fin del precio de producto es requerida");
    }

    @Test
    void should_throwError_when_endDateIsBeforeThanStartDate() {
        final var expectedThrow = Assertions.catchThrowable(
                () -> ProductPriceUtils.GET.defaultDomain()
                .startDate(LocalDateTime.now().plusHours(1))
                .endDate(LocalDateTime.now().minusHours(1))
                .build()
        );

        Assertions.assertThat(expectedThrow).isInstanceOf(DomainException.class)
                .hasMessage("La fecha de fin del precio de producto no puede ser posterior a la fecha de inicio");
    }

    @Test
    void should_throwError_when_priceListIsNull() {
        final var expectedThrow = Assertions.catchThrowable(
                () -> ProductPriceUtils.GET.defaultDomain()
                        .priceList(null)
                        .build()
        );

        Assertions.assertThat(expectedThrow).isInstanceOf(DomainException.class)
                .hasMessage("El identificador de tarifa del precio de producto es requerido");
    }

    @Test
    void should_throwError_when_productIdIsNull() {
        final var expectedThrow = Assertions.catchThrowable(
                () -> ProductPriceUtils.GET.defaultDomain()
                        .productId(null)
                        .build()
        );

        Assertions.assertThat(expectedThrow).isInstanceOf(DomainException.class)
                .hasMessage("El identificador del producto del precio de producto es requerido");
    }

    @Test
    void should_throwError_when_priceIsNull() {
        final var expectedThrow = Assertions.catchThrowable(
                () -> ProductPriceUtils.GET.defaultDomain()
                        .price(null)
                        .build()
        );

        Assertions.assertThat(expectedThrow).isInstanceOf(DomainException.class)
                .hasMessage("El precio del precio de producto es requerido");
    }

    @Test
    void should_throwError_when_currencyIsNull() {
        final var expectedThrow = Assertions.catchThrowable(
                () -> ProductPriceUtils.GET.defaultDomain()
                        .currency(null)
                        .build()
        );

        Assertions.assertThat(expectedThrow).isInstanceOf(DomainException.class)
                .hasMessage("El currency del precio de producto es requerido");
    }

    @Test
    void should_beOk_when_CreateProductPrice() {
        final var result = ProductPriceUtils.GET.defaultDomain().build();

        Assertions.assertThat(result).isNotNull();
        Assertions.assertThat(result.id()).isEqualTo(ProductPriceUtils.DEFAULT_PRODUCT_PRICE_ID);
    }

    @Test
    void should_equals_when_isSymmetrical() {

        final var productPrice1 = ProductPriceUtils.GET.defaultDomain().build();
        final var productPrice2 = ProductPriceUtils.GET.defaultDomain().build();

        Assertions.assertThat(productPrice1.equals(productPrice2)).isTrue();
        Assertions.assertThat(productPrice2.equals(productPrice1)).isTrue();
    }

    @Test
    void should_equals_when_hashcode() {
        final var productPrice1 = ProductPriceUtils.GET.defaultDomain().build();
        final var productPrice2 = ProductPriceUtils.GET.defaultDomain().build();

        Assertions.assertThat(productPrice1).hasSameHashCodeAs(productPrice2);
    }

    @Test
    void should_equals_when_isReflexive() {
        final var productPrice = ProductPriceUtils.GET.defaultDomain().build();

        Assertions.assertThat(productPrice.equals(productPrice)).isTrue();
    }

    @Test
    void should_notEquals_when_isNull() {
        final var productPrice = ProductPriceUtils.GET.defaultDomain().build();

        Assertions.assertThat(productPrice.equals(null)).isFalse();
    }

    @Test
    void should_notEquals_when_isDifferent() {
        final var productPrice1 = ProductPriceUtils.GET.defaultDomain().build();
        final var productPrice2 = ProductPriceUtils.GET.defaultDomain().priceList(12212).build();

        Assertions.assertThat(productPrice1.equals(productPrice2)).isFalse();
    }

    @Test
    void should_notEquals_when_isInstanceOfOtherClass() {
        final var otherClass = "OtherClass";

        final var productPrice = ProductPriceUtils.GET.defaultDomain().build();

        Assertions.assertThat(productPrice.equals(otherClass)).isFalse();
    }

    @Test
    void should_goOk_when_checkToString() {
        final var productPrice = ProductPriceUtils.GET.defaultDomain().build();
        final var result = productPrice.toString();

        Assertions.assertThat(result)
                .contains("id=".concat(productPrice.id().toString()))
                .contains("brandId=".concat(productPrice.brandId().toString()))
                .contains("startDate=".concat(productPrice.startDate().toString()))
                .contains("endDate=".concat(productPrice.endDate().toString()))
                .contains("productId=".concat(productPrice.productId().toString()))
                .contains("price=".concat(productPrice.price().toString()))
                .contains("currency=".concat(productPrice.currency().name()));
    }

}