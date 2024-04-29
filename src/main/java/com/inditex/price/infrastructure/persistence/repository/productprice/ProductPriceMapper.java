package com.inditex.price.infrastructure.persistence.repository.productprice;

import com.inditex.price.domain.productprice.entity.Currency;
import com.inditex.price.domain.productprice.entity.Price;
import com.inditex.price.domain.productprice.entity.ProductPrice;
import com.inditex.price.domain.productprice.entity.Uuid;
import com.inditex.price.infrastructure.persistence.model.productprice.ProductPricePO;

enum ProductPriceMapper {
    TO;

    public ProductPrice domain(ProductPricePO productPricePO) {
        final var productPrice = new ProductPrice.Builder(new Uuid(productPricePO.getId()));
        productPrice.productId(new Uuid(productPricePO.getProductId()));
        productPrice.brandId(new Uuid(productPricePO.getBrandId()));
        productPrice.priceList(productPricePO.getPriceList());
        productPrice.endDate(productPricePO.getEndDate());
        productPrice.startDate(productPricePO.getStartDate());
        productPrice.price(new Price(productPricePO.getPrice()));
        productPrice.currency(Currency.of(productPricePO.getCurrency()));
        return productPrice.build();
    }

}
