package com.inditex.price.domain.productprice.entity;

import com.inditex.price.domain.DomainException;

public enum Currency {
    EUR(1),
    USD(2),
    GBP(3),
    NO_IDENTIFY(0);

    private final int code;

    Currency(int code) {
        this.code = code;
    }

    public static Currency of(Integer code) {
        if (code != null) {
            for(Currency currency : Currency.values()) {
                if (currency.code == code) {
                    return currency;
                }
            }
        }
        return NO_IDENTIFY;
    }

    public int code() {
        return this.code;
    }

    public void check() {
        if (NO_IDENTIFY == this) {
            throw new DomainException("Currency is not valid");
        }
    }
}
