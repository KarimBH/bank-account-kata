package com.github.karimbh.bankaccount.domain;

import java.math.BigDecimal;
import java.util.Currency;

/**
 * A simplified and immutable representation of an amount of money.
 * A JSR-354 implementation is required for a real world project
 */
public class MonetaryAmount {

    private BigDecimal amount;

    private Currency currency;

    public MonetaryAmount(BigDecimal amount, Currency currency) {
        this.amount = amount;
        this.currency = currency;
    }

    /**
     * Returns a {@code MonetaryAmount} whose value is {@code (this +
     * toBeAddedMonetaryAmount)}, and whose currency is {@code this.currency}.
     * No currency match checking is done for the sake of simplicity
     *
     * @param toBeAddedMonetaryAmount to be added to this {@code MonetaryAmount}.
     * @return {@code this + toBeAddedMonetaryAmount}
     */
    MonetaryAmount add(MonetaryAmount toBeAddedMonetaryAmount) {
        return new MonetaryAmount(
                amount.add(toBeAddedMonetaryAmount.amount),
                currency
        );
    }

    /**
     * Returns a {@code MonetaryAmount} whose value is {@code (this -
     * toBeSubtractedMonetaryAmount)}, and whose currency is {@code this.currency}.
     * No currency match checking is done for the sake of simplicity
     *
     * @param toBeSubtractedMonetaryAmount to be subtracted to this {@code MonetaryAmount}.
     * @return {@code this - toBeSubtractedMonetaryAmount}
     */
    MonetaryAmount subtract(MonetaryAmount toBeSubtractedMonetaryAmount) {
        return new MonetaryAmount(
                amount.subtract(toBeSubtractedMonetaryAmount.amount),
                currency
        );
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public Currency getCurrency() {
        return currency;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MonetaryAmount that = (MonetaryAmount) o;
        return amount.equals(that.amount) && currency.equals(that.currency);
    }

    @Override
    public int hashCode() {
        int result = amount.hashCode();
        result = 31 * result + currency.hashCode();
        return result;
    }
}
