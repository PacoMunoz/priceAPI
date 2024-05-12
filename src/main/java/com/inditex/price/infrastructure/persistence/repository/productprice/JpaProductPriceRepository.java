package com.inditex.price.infrastructure.persistence.repository.productprice;

import com.inditex.price.infrastructure.persistence.model.productprice.ProductPricePO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.Optional;

@Repository
public interface JpaProductPriceRepository extends JpaRepository<ProductPricePO, String> {
    @Query(value = """
            SELECT
                    ID,
                    BRAND_ID,
                    START_DATE,
                    END_DATE,
                    PRICE_LIST,
                    PRODUCT_ID,
                    PRIORITY,
                    PRICE,
                    CURRENCY
                    FROM
                    PRODUCT_PRICE
                    WHERE
                    PRODUCT_ID = ?2
                    AND BRAND_ID = ?3
                    AND START_DATE <= ?1
                    AND END_DATE >= ?1
                    ORDER BY PRIORITY DESC
                    LIMIT 1
                   """
    , nativeQuery = true)
    Optional<ProductPricePO> search(LocalDateTime applicationDate, String productId, String brandId);
}
