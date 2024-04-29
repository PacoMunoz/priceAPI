package com.inditex.price.application.productprice.search;

import com.inditex.price.application.productprice.dto.ProductPriceDTO;
import com.inditex.price.domain.productprice.entity.ProductPrice;

enum GetProductPriceDTO {

    FROM;

    public ProductPriceDTO domain(ProductPrice productPrice) {
        return new ProductPriceDTO(productPrice.productId().value(), productPrice.brandId().value(),
                productPrice.priceList(), productPrice.startDate(), productPrice.endDate(), productPrice.price().value());
    }
}
