package com.inditex.price.application.productprice.search;

import com.inditex.price.application.productprice.dto.ProductPriceCriteriaDTO;
import com.inditex.price.application.productprice.dto.ProductPriceDTO;

public interface SearchProductPrice {
    ProductPriceDTO byCriteria(ProductPriceCriteriaDTO productPriceCriteriaDTO);
}
