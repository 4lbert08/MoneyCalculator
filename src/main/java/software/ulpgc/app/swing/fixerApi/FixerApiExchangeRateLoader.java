package software.ulpgc.app.swing.fixerApi;

import software.ulpgc.architecture.io.ExchangeRateLoader;
import software.ulpgc.architecture.model.Currency;

import java.io.IOException;

public class FixerApiExchangeRateLoader implements ExchangeRateLoader {
    @Override
    public double load(Currency from, Currency to) throws IOException {
        return 0;
    }
}
