package software.ulpgc.app.swing.fixerApi;

import software.ulpgc.architecture.io.ExchangeRateLoader;
import software.ulpgc.architecture.model.Currency;
import software.ulpgc.architecture.model.ExchangeRate;

import java.io.IOException;

public class FixerApiExchangeRateLoader implements ExchangeRateLoader {
    private final static String urlApi = "";
    @Override
    public ExchangeRate load(Currency from, Currency to) throws IOException {
        return null;
    }
}
