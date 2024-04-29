package com.inditex.price.infrastructure.persistence.repository.productprice;

import com.inditex.price.domain.productprice.entity.ProductPrice;
import com.inditex.price.domain.productprice.entity.Uuid;
import com.inditex.price.domain.productprice.repository.QueryProductPriceRepository;
import com.inditex.price.infrastructure.persistence.dao.productprice.ProductPriceDAO;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Optional;

@Component
final class QueryProductPriceRepositoryImpl implements QueryProductPriceRepository {

    private final ProductPriceDAO productPriceDAO;

    QueryProductPriceRepositoryImpl(ProductPriceDAO productPriceDAO) {
        this.productPriceDAO = productPriceDAO;
    }

    @Override
    public Optional<ProductPrice> search(LocalDateTime applicationDate, Uuid productId, Uuid brandId) {
        final var productPricePO = productPriceDAO.search(applicationDate, productId.value(), brandId.value());
        return productPricePO.map(ProductPriceMapper.TO::domain);
    }
}
