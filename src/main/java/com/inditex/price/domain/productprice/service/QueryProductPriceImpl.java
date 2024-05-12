package com.inditex.price.domain.productprice.service;

import com.inditex.price.domain.productprice.entity.ProductPrice;
import com.inditex.price.domain.productprice.entity.Uuid;
import com.inditex.price.domain.productprice.repository.QueryProductPriceRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
class QueryProductPriceImpl implements QueryProductPrice{

    private final QueryProductPriceRepository queryProductPriceRepository;

    QueryProductPriceImpl(QueryProductPriceRepository queryProductPriceRepository) {
        this.queryProductPriceRepository = queryProductPriceRepository;
    }

    @Override
    public Optional<ProductPrice> search(LocalDateTime applicationDate, Uuid productId, Uuid brandId) {
        return queryProductPriceRepository.search(applicationDate, productId, brandId);
    }
}
