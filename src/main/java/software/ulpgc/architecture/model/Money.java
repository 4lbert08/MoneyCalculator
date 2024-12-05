package software.ulpgc.architecture.model;

import java.util.Currency;

public class Money {
    private final  int account;
    private final Currency Currency;

    public int getAccount() {
        return account;
    }

    public java.util.Currency getCurrency() {
        return Currency;
    }

    public Money(int account, java.util.Currency currency) {
        this.account = account;
        Currency = currency;
    }

    @Override
    public String toString() {
        return "Money{" +
                "account=" + account +
                ", Currency=" + Currency +
                '}';
    }


}
