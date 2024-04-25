package com.inditex.price.domain.entity;

import com.inditex.price.domain.productprice.entity.Currency;
import com.inditex.price.domain.DomainException;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Comparator;

import static org.junit.jupiter.api.Assertions.*;

class CurrencyTest {
    
    @Test
    void should_getCurrencyType_when_codeExist() {
        final var currencyEur = Currency.EUR;

        final var result = Currency.of(currencyEur.code());

        Assertions.assertThat(result).isEqualTo(Currency.EUR).isInstanceOf(Currency.class);
    }

    @Test
    void should_getCurrencyNoIdentify_when_codeNotExist() {
        final var result = Currency.of(
                Arrays.stream(Currency.values()).max(Comparator.comparing(Currency::code)).get().code() + 1
        );

        Assertions.assertThat(result).isEqualTo(Currency.NO_IDENTIFY).isInstanceOf(Currency.class);
    }

    @Test
    void should_getCurrencyNotIdentify_when_codeIsNull() {
        final var result = Currency.of(null);

        Assertions.assertThat(result).isEqualTo(Currency.NO_IDENTIFY).isInstanceOf(Currency.class);
    }

    @Test
    void should_beOk_when_channelTypeIsValid() {
        final var currency = Currency.EUR;

        final var result = Currency.of(currency.code());

        assertDoesNotThrow(result::check);
    }

    @Test
    void should_throwError_when_channelTypeIsInvalid() {
        final var result = Currency.of(
                Arrays.stream(Currency.values()).max(Comparator.comparing(Currency::code)).get().code() + 1
        );

        assertThrows(DomainException.class, result::check);
    }

}