package com.inditex.price.infrastructure.persistence.repository.productprice;

import com.inditex.price.domain.productprice.entity.ProductPrice;
import com.inditex.price.domain.productprice.entity.Uuid;
import com.inditex.price.domain.productprice.repository.QueryProductPriceRepository;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Optional;

@Component
final class QueryProductPriceRepositoryImpl implements QueryProductPriceRepository {

    private final JpaProductPriceRepository jpaProductPriceRepository;

    QueryProductPriceRepositoryImpl(JpaProductPriceRepository jpaProductPriceRepository) {
        this.jpaProductPriceRepository = jpaProductPriceRepository;
    }


    @Override
    public Optional<ProductPrice> search(LocalDateTime applicationDate, Uuid productId, Uuid brandId) {
        final var productPricePO = jpaProductPriceRepository.search(applicationDate, productId.value(), brandId.value());
        return productPricePO.map(ProductPriceMapper.TO::domain);
    }
}
