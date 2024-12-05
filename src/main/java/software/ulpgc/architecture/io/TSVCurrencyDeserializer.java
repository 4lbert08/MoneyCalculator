package software.ulpgc.architecture.io;

import software.ulpgc.architecture.model.Currency;

public class TSVCurrencyDeserializer implements CurrencyDeserializer {

    @Override
    public Currency deserializer(String line) {
        return deserialize(line.split("\t"));
    }

    private Currency deserialize(String[] split) {
        return new Currency(split[1], split[2]);
    }
}
