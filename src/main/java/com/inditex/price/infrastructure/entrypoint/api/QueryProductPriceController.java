package com.inditex.price.infrastructure.entrypoint.api;

import com.inditex.application.productprice.dto.ProductPriceDTO;
import com.inditex.infrastructure.entrypoint.api.productprice.GetProductPricesByCriteriaApi;
import com.inditex.price.application.productprice.search.SearchProductPrice;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
public class QueryProductPriceController implements GetProductPricesByCriteriaApi {

    private final SearchProductPrice searchProductPrice;

    public QueryProductPriceController(SearchProductPrice searchProductPrice) {
        this.searchProductPrice = searchProductPrice;
    }


    @Override
    public ResponseEntity<ProductPriceDTO> getProductPricesByCriteria(LocalDateTime applicationDate, String productId, String brandId) {
        final var productPriceDTO = searchProductPrice.search(applicationDate, productId, brandId);
        return ResponseEntity.ok(productPriceDTO);
    }
}
