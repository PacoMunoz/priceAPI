package com.inditex.price.infrastructure.persistence.dao.productprice;

import com.inditex.price.infrastructure.persistence.model.productprice.ProductPricePO;
import org.apache.ibatis.annotations.Mapper;

import java.time.LocalDateTime;
import java.util.Optional;

@Mapper
public interface ProductPriceDAO {
    Optional<ProductPricePO> search(LocalDateTime applicationDate, String productId, String brandId);
}
