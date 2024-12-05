package software.ulpgc.architecture.io;

import software.ulpgc.architecture.model.Currency;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

public class FileCurrencyLoader implements CurrencyLoader {
    private final File file;
    private final CurrencyDeserializer deserializer;

    public FileCurrencyLoader(File file, CurrencyDeserializer deserializer) {
        this.file = file;
        this.deserializer = deserializer;
    }

    @Override
    public List<Currency> load() throws IOException {
        List<Currency> currencies = new ArrayList<>();
        List<String> lines = Files.readAllLines(file.toPath());
        for (String line: lines) {
            currencies.add(deserializer.deserializer(line));
        }
        return currencies;
    }
}
