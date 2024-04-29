package com.inditex.price.application.productprice;

import com.inditex.price.application.ApplicationException;

public class ApplicationNotFoundException extends ApplicationException {
    public ApplicationNotFoundException(String key) {
        super(key);
    }
}
