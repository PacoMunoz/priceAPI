package com.inditex.price.domain;

import java.io.Serial;

public class ApplicationException extends RuntimeException {
    @Serial
    private static final long serialVersionUID = -2061245430384431936L;

    public ApplicationException(String key) {
        super(key);
    }
}
