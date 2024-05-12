package com.inditex.price.infrastructure.persistence.repository.productprice;

import com.inditex.price.infrastructure.persistence.model.productprice.ProductPricePO;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;

@DataJpaTest
class JpaProductPriceRepositoryTest {

    private final LocalDateTime date = LocalDateTime.of(2020, 7, 14, 3, 2, 1 );

    @Autowired
    private JpaProductPriceRepository jpaProductPriceRepository;

    @Test
    void should_returnData_when_search() {
        final var result = jpaProductPriceRepository.search(date, "2f67a7df-47d6-4e39-8f69-bc2ef1b47ee5", "45a9192c-c2b6-4429-b72e-786e45604469");

        final var expected = getProductPricePO();

        assertEqual(result, expected);
    }

    private static ProductPricePO getProductPricePO() {
        final var startDate = LocalDateTime.of(2020, 6, 15, 16, 0, 0);
        final var endDate = LocalDateTime.of(2020, 12, 31, 23, 59, 59);

        final var expected = new ProductPricePO();
        expected.setId("78b1a3ba-caef-4798-be50-3dfa62e5a288");
        expected.setBrandId("45a9192c-c2b6-4429-b72e-786e45604469");
        expected.setStartDate(startDate);
        expected.setEndDate(endDate);
        expected.setPriceList(4);
        expected.setProductId("2f67a7df-47d6-4e39-8f69-bc2ef1b47ee5");
        expected.setPriority(1);
        expected.setPrice(new BigDecimal("38.95"));
        expected.setCurrency(1);

        return expected;
    }

    private static void assertEqual(Optional<ProductPricePO> result, ProductPricePO expected) {
        Assertions.assertThat(result).isPresent();
        Assertions.assertThat(result.get().getId()).isEqualTo(expected.getId());
        Assertions.assertThat(result.get().getBrandId()).isEqualTo(expected.getBrandId());
        Assertions.assertThat(result.get().getStartDate()).isEqualTo(expected.getStartDate());
        Assertions.assertThat(result.get().getEndDate()).isEqualTo(expected.getEndDate());
        Assertions.assertThat(result.get().getPriceList()).isEqualTo(expected.getPriceList());
        Assertions.assertThat(result.get().getProductId()).isEqualTo(expected.getProductId());
        Assertions.assertThat(result.get().getPriority()).isEqualTo(expected.getPriority());
        Assertions.assertThat(result.get().getPrice()).isEqualTo(expected.getPrice());
        Assertions.assertThat(result.get().getCurrency()).isEqualTo(expected.getCurrency());
    }

    @Test
    void should_returnEmpty_when_dateDoesNotExist() {
        final var result = jpaProductPriceRepository.search(LocalDateTime.now(), "2f67a7df-47d6-4e39-8f69-bc2ef1b47ee5", "45a9192c-c2b6-4429-b72e-786e45604469");

        Assertions.assertThat(result).isEmpty();
    }

    @Test
    void should_returnEmpty_when_productIdDoesNotExist() {
        final var result = jpaProductPriceRepository.search(date, UUID.randomUUID().toString(), "45a9192c-c2b6-4429-b72e-786e45604469");

        Assertions.assertThat(result).isEmpty();
    }

    @Test
    void should_returnEmpty_when_brandIdDoesNotExist() {
        final var result = jpaProductPriceRepository.search(date, "2f67a7df-47d6-4e39-8f69-bc2ef1b47ee5", UUID.randomUUID().toString());

        Assertions.assertThat(result).isEmpty();
    }

}