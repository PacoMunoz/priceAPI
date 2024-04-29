package com.inditex.price.domain.productprice.entity;

import com.inditex.price.domain.DomainException;

import java.math.BigDecimal;

public record Price(BigDecimal value) {
    public Price {
        if (value == null) {
            throw new DomainException("El precio del producto no puede ser nulo");
        }
        if (BigDecimal.ZERO.compareTo(value) > 0) {
            throw new DomainException("El precio del producto no puede ser menor que 0");
        }
    }
}
