package software.ulpgc.architecture.io;

import software.ulpgc.architecture.model.Currency;

public interface CurrencyDeserializer {
    Currency deserializer(String line);
}
