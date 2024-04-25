package com.inditex.price.application.productprice.search;

import com.inditex.price.application.ApplicationException;
import com.inditex.price.application.productprice.dto.ProductPriceCriteriaDTO;
import com.inditex.price.application.productprice.dto.ProductPriceDTO;
import com.inditex.price.domain.productprice.entity.Uuid;
import com.inditex.price.domain.productprice.repository.QueryProductPriceRepository;

class SearchProductPriceImpl implements SearchProductPrice{

    private final QueryProductPriceRepository queryProductPriceRepository;

    SearchProductPriceImpl(QueryProductPriceRepository queryProductPriceRepository) {
        this.queryProductPriceRepository = queryProductPriceRepository;
    }

    @Override
    public ProductPriceDTO byCriteria(ProductPriceCriteriaDTO productPriceCriteriaDTO) {
        validate(productPriceCriteriaDTO);
        final var domainProductPrice = queryProductPriceRepository.byCriteria(
                productPriceCriteriaDTO.getApplicationDate(),
                new Uuid(productPriceCriteriaDTO.getProductId()),
                new Uuid(productPriceCriteriaDTO.getBrandId())
        );
        return GetProductPriceDTO.FROM.domain(domainProductPrice);
    }

    private void validate(ProductPriceCriteriaDTO productPriceCriteriaDTO) {
        if (productPriceCriteriaDTO.getProductId() == null || productPriceCriteriaDTO.getProductId().isBlank()) {
            throw new ApplicationException("El id del producto es requerido");
        }
        if (productPriceCriteriaDTO.getApplicationDate() == null) {
            throw new ApplicationException("El campo fecha de aplicacion es requerido");
        }
        if (productPriceCriteriaDTO.getBrandId() == null || productPriceCriteriaDTO.getBrandId().isBlank()) {
            throw new ApplicationException("El id de la marca es requerido");
        }
    }
}
