package com.inditex.price.application.productprice.search;

import com.inditex.price.domain.productprice.entity.ProductPrice;
import io.reflectoring.model.ProductPriceDTO;

enum GetProductPriceDTO {

    FROM;

    public ProductPriceDTO domain(ProductPrice productPrice) {
        final var productPriceDTO = new ProductPriceDTO();
        productPriceDTO.setProductId(productPrice.productId().value());
        productPriceDTO.setBrandId(productPrice.brandId().value());
        productPriceDTO.setPriceList(productPrice.priceList());
        productPriceDTO.setStartDate(productPrice.startDate());
        productPriceDTO.setEndDate(productPrice.endDate());
        productPriceDTO.setPrice(productPrice.price().value());

        return productPriceDTO;
    }
}
