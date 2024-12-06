package software.ulpgc.app.swing.fixerApi;

import software.ulpgc.architecture.io.CurrenciesLoader;
import software.ulpgc.architecture.model.Currency;

import java.util.List;

public class FixerApiCurrenciesLoader implements CurrenciesLoader {

    @Override
    public List<Currency> load() {
        return List.of();
    }
}
