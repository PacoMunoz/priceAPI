package com.inditex.price.domain.productprice.entity;

import com.inditex.price.domain.DomainException;

import java.time.LocalDateTime;
import java.util.Objects;


public final class ProductPrice {
    private final Uuid id;
    private final Uuid brandId;
    private final LocalDateTime startDate;
    private final LocalDateTime endDate;
    private final Integer priceList;
    private final Uuid productId;
    private final Price price;
    private final Currency currency;

    public static final class Builder {
        private final Uuid id;
        private Uuid brandId;
        private LocalDateTime startDate;
        private LocalDateTime endDate;
        private Integer priceList;
        private Uuid productId;
        private Price price;
        private Currency currency;

        public Builder(ProductPrice price) {
            this.id = price.id;
            this.brandId = price.brandId;
            this.startDate = price.startDate;
            this.endDate = price.endDate;
            this.priceList = price.priceList;
            this.productId = price.productId;
            this.price = price.price;
            this.currency = price.currency;
        }

        public Builder(Uuid id) {
            this.id = id;
        }

        public Builder brandId(Uuid brandId) {
            this.brandId = brandId;
            return this;
        }

        public Builder startDate(LocalDateTime startDate) {
            this.startDate = startDate;
            return this;
        }

        public Builder endDate(LocalDateTime endDate) {
            this.endDate = endDate;
            return this;
        }

        public Builder priceList(Integer priceList) {
            this.priceList = priceList;
            return this;
        }

        public Builder productId(Uuid productId) {
            this.productId = productId;
            return this;
        }

        public Builder price(Price price) {
            this.price = price;
            return this;
        }

        public Builder currency(Currency currency) {
            this.currency = currency;
            return this;
        }

        public ProductPrice build() {
            return new ProductPrice(this);
        }
    }

    private ProductPrice(Builder builder) {
        check(builder);
        this.id = builder.id;
        this.brandId = builder.brandId;
        this.startDate = builder.startDate;
        this.endDate = builder.endDate;
        this.priceList = builder.priceList;
        this.productId = builder.productId;
        this.price = builder.price;
        this.currency = builder.currency;
    }

    private void check (Builder builder) {
        if (builder.brandId == null) {
            throw new DomainException("El id de la marca del precio de producto es requerida");
        }
        if (builder.startDate == null) {
            throw new DomainException("La fecha de inicio del precio de producto es requerida");
        }
        if (builder.endDate == null) {
            throw new DomainException("La fecha de fin del precio de producto es requerida");
        }
        if (builder.endDate.isBefore(builder.startDate)) {
            throw new DomainException("La fecha de fin del precio de producto no puede ser posterior a la fecha de inicio");
        }
        if (builder.priceList == null) {
            throw new DomainException("El identificador de tarifa del precio de producto es requerido");
        }
        if (builder.productId == null) {
            throw new DomainException("El identificador del producto del precio de producto es requerido");
        }
        if (builder.price == null) {
            throw new DomainException("El precio del precio de producto es requerido");
        }
        if (builder.currency == null) {
            throw new DomainException("El currency del precio de producto es requerido");
        }
    }

    public Uuid id() {
        return this.id;
    }

    public Uuid brandId() {
        return this.brandId;
    }

    public LocalDateTime startDate() {
        return this.startDate;
    }

    public LocalDateTime endDate() {
        return this.endDate;
    }

    public Integer priceList() {
        return this.priceList;
    }

    public Uuid productId() {
        return this.productId;
    }

    public Price price() {
        return this.price;
    }

    public Currency currency() {
        return this.currency;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductPrice productPrice = (ProductPrice) o;
        return Objects.equals(id, productPrice.id) && Objects.equals(brandId, productPrice.brandId) && Objects.equals(startDate, productPrice.startDate)
                && Objects.equals(endDate, productPrice.endDate)  && Objects.equals(priceList, productPrice.priceList)
                && Objects.equals(productId, productPrice.productId()) && Objects.equals(price, productPrice.price())
                && Objects.equals(currency, productPrice.currency());
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, brandId, startDate, endDate, priceList, productId, price, currency);
    }

    @Override
    public String toString() {
        return "Brand{" +
                "id=" + id +
                ", brandId=" + brandId +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", priceList=" + priceList +
                ", productId=" + productId +
                ", price=" + price.value() +
                ", currency=" + currency.code() +
                '}';
    }
}
