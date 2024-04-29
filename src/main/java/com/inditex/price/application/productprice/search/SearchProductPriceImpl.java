package com.inditex.price.application.productprice.search;

import com.inditex.price.application.ApplicationException;
import com.inditex.price.application.productprice.ApplicationNotFoundException;
import com.inditex.price.application.productprice.dto.ProductPriceDTO;
import com.inditex.price.domain.productprice.entity.Uuid;
import com.inditex.price.domain.productprice.repository.QueryProductPriceRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
class SearchProductPriceImpl implements SearchProductPrice{

    private final QueryProductPriceRepository queryProductPriceRepository;

    SearchProductPriceImpl(QueryProductPriceRepository queryProductPriceRepository) {
        this.queryProductPriceRepository = queryProductPriceRepository;
    }

    @Override
    public ProductPriceDTO search(LocalDateTime applicationDate, String productId, String brandId) {
        validate(applicationDate, productId, brandId);

        return queryProductPriceRepository
                .search(applicationDate, new Uuid(productId), new Uuid(brandId))
                .map(GetProductPriceDTO.FROM::domain)
                .orElseThrow(() -> new ApplicationNotFoundException("No se ha encontrado precio para los parametros indicados"));
    }

    private void validate(LocalDateTime applicationDate, String productId, String brandId) {
        if (productId == null || productId.isBlank()) {
            throw new ApplicationException("El id del producto es requerido");
        }
        if (applicationDate == null) {
            throw new ApplicationException("El campo fecha de aplicacion es requerido");
        }
        if (brandId == null || brandId.isBlank()) {
            throw new ApplicationException("El id de la marca es requerido");
        }
    }
}
