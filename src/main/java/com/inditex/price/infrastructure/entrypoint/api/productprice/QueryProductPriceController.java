package com.inditex.price.infrastructure.entrypoint.api.productprice;

import com.inditex.price.application.productprice.dto.ProductPriceDTO;
import com.inditex.price.application.productprice.search.SearchProductPrice;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/v1/productprices")
public class QueryProductPriceController {

    private final SearchProductPrice searchProductPrice;

    public QueryProductPriceController(SearchProductPrice searchProductPrice) {
        this.searchProductPrice = searchProductPrice;
    }

    @GetMapping("/search")
    public ProductPriceDTO search(@RequestParam LocalDateTime applicationDate, @RequestParam String productId,
                                  @RequestParam String brandId) {
        return searchProductPrice.search(applicationDate, productId, brandId);
    }
}
