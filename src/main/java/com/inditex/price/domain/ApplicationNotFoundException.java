package com.inditex.price.domain;

public class ApplicationNotFoundException extends ApplicationException {
    public ApplicationNotFoundException(String key) {
        super(key);
    }
}
