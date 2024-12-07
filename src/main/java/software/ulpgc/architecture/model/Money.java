package software.ulpgc.architecture.model;

import software.ulpgc.architecture.model.Currency;

public record Money(long amount, Currency currency) {
    @Override
    public String toString() {
        return amount + " " + currency;
    }
}
