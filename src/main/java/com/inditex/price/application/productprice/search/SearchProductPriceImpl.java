package com.inditex.price.application.productprice.search;

import com.inditex.application.productprice.dto.ProductPriceDTO;
import com.inditex.price.domain.ApplicationNotFoundException;
import com.inditex.price.domain.productprice.entity.Uuid;
import com.inditex.price.domain.productprice.service.QueryProductPrice;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
class SearchProductPriceImpl implements SearchProductPrice{

    private final QueryProductPrice queryProductPrice;

    SearchProductPriceImpl(QueryProductPrice queryProductPrice) {
        this.queryProductPrice = queryProductPrice;
    }

    @Override
    public ProductPriceDTO search(LocalDateTime applicationDate, String productId, String brandId) {
        return queryProductPrice
                .search(applicationDate, new Uuid(productId), new Uuid(brandId))
                .map(GetProductPriceDTO.FROM::domain)
                .orElseThrow(() -> new ApplicationNotFoundException("No se ha encontrado precio para los parametros indicados"));
    }
}
