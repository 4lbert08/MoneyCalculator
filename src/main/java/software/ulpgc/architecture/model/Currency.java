package software.ulpgc.architecture.model;

public class Currency {

    private final String code;
    private final String name;
    private final String symbol;
    private final Country country;

    public Currency(String code, String name, String symbol, Country country) {
        this.code = code;
        this.name = name;
        this.symbol = symbol;
        this.country = country;
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public String getSymbol() {
        return symbol;
    }

    public Country getCountry() {
        return country;
    }

    @Override
    public String toString() {
        return "Currency{" +
                "code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", symbol='" + symbol + '\'' +
                ", country=" + country +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (this == null || getClass() != o.getClass()) return false;
        return false;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }
}
