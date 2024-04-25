package com.inditex.price.domain;

import java.io.Serial;

public class DomainException extends RuntimeException{
    @Serial
    private static final long serialVersionUID = -2064145430384421936L;

    public DomainException(String key) {
        super(key);
    }

}
