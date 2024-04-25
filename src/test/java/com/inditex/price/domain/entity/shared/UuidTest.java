package com.inditex.price.domain.entity.shared;

import com.inditex.price.domain.DomainException;
import com.inditex.price.domain.productprice.entity.Uuid;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.UUID;

class UuidTest {

    @Test
    void should_throwException_when_isNull() {
        final var expectedThrow = Assertions.catchException(() -> new Uuid(null));

        Assertions.assertThat(expectedThrow).isInstanceOf(DomainException.class).hasMessage("El identificador es obligatorio");
    }

    @Test
    void should_throwException_when_isBlank() {
        final var expectedThrow = Assertions.catchException(() -> new Uuid(""));

        Assertions.assertThat(expectedThrow).isInstanceOf(DomainException.class).hasMessage("El identificador es obligatorio");
    }

    @Test
    void should_throwException_when_notMatchPattern() {
        final var expectedThrow = Assertions.catchException(() -> new Uuid("1221"));

        Assertions.assertThat(expectedThrow).isInstanceOf(DomainException.class).hasMessage("El identificador no tiene un formato correcto");
    }

    @Test
    void should_beOk_when_createUuid() {
        final var uuid = UUID.randomUUID().toString();
        final var result = new Uuid(uuid);

        Assertions.assertThat(result).isNotNull();
        Assertions.assertThat(result.value()).isEqualTo(uuid);
    }
}