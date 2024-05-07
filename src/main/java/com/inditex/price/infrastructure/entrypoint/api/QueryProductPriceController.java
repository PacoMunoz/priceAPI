package com.inditex.price.infrastructure.entrypoint.api;

import com.inditex.price.application.productprice.search.SearchProductPrice;
import io.reflectoring.api.GetProductPricesByCriteriaApi;
import io.reflectoring.model.ProductPriceDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import java.time.LocalDateTime;

@Controller
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
