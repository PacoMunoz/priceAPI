package com.inditex.price.infrastructure.entrypoint.api;

import com.inditex.price.domain.ApplicationNotFoundException;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;

@SpringBootTest
class QueryProductPriceControllerTest {

    // Se sustituye los valores enteros para los identificadores de producto y marca por UUIDs
    private static final String PRODUCT_ID = "2f67a7df-47d6-4e39-8f69-bc2ef1b47ee5";
    private static final String BRAND_ID = "45a9192c-c2b6-4429-b72e-786e45604469";

    @Autowired
    private QueryProductPriceController queryProductPriceController;

    @ParameterizedTest
    @CsvSource({"14,10,35.50", "14,16,25.45", "14,21,35.50", "15,10,30.50", "16,21,38.95"})
    void should_searchProductPrice(int day, int hour, BigDecimal expected) {
        final var date = LocalDateTime.of(2020, 6, day, hour, 0, 0);

        final var result = queryProductPriceController.getProductPricesByCriteria(date, PRODUCT_ID, BRAND_ID);

        Assertions.assertThat(result).isNotNull();
        Assertions.assertThat(Objects.requireNonNull(result.getBody()).getPrice()).isEqualTo(expected);
    }

    @Test
    void should_throwError_when_productIdDoesNotExist() {
        final var date = LocalDateTime.of(2020, 6, 14, 10, 0, 0);

        final var expectedThrow = Assertions.catchThrowable(
                () -> queryProductPriceController.getProductPricesByCriteria(date, UUID.randomUUID().toString(), BRAND_ID)
        );

        Assertions.assertThat(expectedThrow).isInstanceOf(ApplicationNotFoundException.class)
                .hasMessage("No se ha encontrado precio para los parametros indicados");
    }

    @Test
    void should_ThrowError_when_brandIdDoesNotExist() {
        final var date = LocalDateTime.of(2020, 6, 14, 10, 0, 0);

        final var expectedThrow = Assertions.catchThrowable(
                () -> queryProductPriceController.getProductPricesByCriteria(date, PRODUCT_ID, UUID.randomUUID().toString())
        );

        Assertions.assertThat(expectedThrow).isInstanceOf(ApplicationNotFoundException.class)
                .hasMessage("No se ha encontrado precio para los parametros indicados");
    }

    @Test
    void should_ThrowError_when_DateDoesNotExist() {
        final var date = LocalDateTime.of(2025, 6, 14, 10, 0, 0);

        final var expectedThrow = Assertions.catchThrowable(
                () -> queryProductPriceController.getProductPricesByCriteria(date, PRODUCT_ID, BRAND_ID)
        );

        Assertions.assertThat(expectedThrow).isInstanceOf(ApplicationNotFoundException.class)
                .hasMessage("No se ha encontrado precio para los parametros indicados");
    }

}