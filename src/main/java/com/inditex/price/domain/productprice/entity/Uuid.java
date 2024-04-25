package com.inditex.price.domain.productprice.entity;

import com.inditex.price.domain.DomainException;

import java.util.regex.Pattern;

public record Uuid(String value) {

    private static final Pattern UUID_REGEX_PATTERN =
            Pattern.compile("[0-9a-fA-F]{8}-[0-9a-fA-F]{4}-[0-9a-fA-F]{4}-[0-9a-fA-F]{4}-[0-9a-fA-F]{12}");

    public Uuid {
        if (value == null || value.isBlank()) {
            throw new DomainException("El identificador es obligatorio");
        }
        if (!UUID_REGEX_PATTERN.matcher(value).matches()) {
            throw new DomainException("El identificador no tiene un formato correcto");
        }
    }
}
