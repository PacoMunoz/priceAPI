package com.inditex.price.application;

import com.inditex.price.application.ApplicationException;

public class ApplicationNotFoundException extends ApplicationException {
    public ApplicationNotFoundException(String key) {
        super(key);
    }
}
