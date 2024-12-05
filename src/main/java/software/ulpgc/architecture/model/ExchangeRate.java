package software.ulpgc.architecture.model;

import java.time.LocalDate;

public class ExchangeRate {
    private final LocalDate date;
    private final Currency from;
    private final Currency to;
    private final double rate;

    public ExchangeRate(LocalDate date, Currency from, Currency to, double rate) {
        this.date = date;
        this.from = from;
        this.to = to;
        this.rate = rate;
    }

    public LocalDate getDate() {
        return date;
    }

    public Currency getFrom() {
        return from;
    }

    public Currency getTo() {
        return to;
    }

    public double getRate() {
        return rate;
    }

    @Override
    public String toString() {
        return "ExchangeDate{" +
                "date=" + date +
                ", from=" + from +
                ", to=" + to +
                ", rate=" + rate +
                '}';
    }
}
