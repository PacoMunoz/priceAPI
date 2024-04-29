package com.inditex.price.infrastructure.persistence.dao.productprice;

import com.inditex.price.infrastructure.persistence.model.productprice.ProductPricePO;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@SpringBootTest
class ProductPriceDAOTest {

    @Autowired
    private ProductPriceDAO productPriceDAO;

    @Test
    void should_returnData_when_search() {
        final var date = LocalDateTime.of(2020, 7, 14, 3, 2, 1 );

        final var result = productPriceDAO.search(date, "2f67a7df-47d6-4e39-8f69-bc2ef1b47ee5", "45a9192c-c2b6-4429-b72e-786e45604469");

        final var startDate = LocalDateTime.of(2020, 6, 15, 16, 0, 0);
        final var endDate = LocalDateTime.of(2020, 12, 31, 23, 59, 59);
        final var expected = new ProductPricePO("78b1a3ba-caef-4798-be50-3dfa62e5a288",
                "45a9192c-c2b6-4429-b72e-786e45604469", startDate, endDate, 4, "2f67a7df-47d6-4e39-8f69-bc2ef1b47ee5",
                1, new BigDecimal("38.95"), 1);
        Assertions.assertThat(result).isPresent().contains(expected);
    }

    @Test
    void should_returnEmpty_when_search() {
        final var result = productPriceDAO.search(LocalDateTime.now(), "2f67a7df-47d6-4e39-8f69-bc2ef1b47ee5", "45a9192c-c2b6-4429-b72e-786e45604469");

        Assertions.assertThat(result).isEmpty();
    }

}