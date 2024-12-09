package software.ulpgc.app.fixerApi;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import software.ulpgc.architecture.io.ExchangeRateLoader;
import software.ulpgc.architecture.model.Currency;
import software.ulpgc.architecture.model.ExchangeRate;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.time.LocalDate;

public class FixerApiExchangeRateLoader implements ExchangeRateLoader {
    private final static String BASE_URL = "https://api.exchangeratesapi.io/v1/latest?access_key="
            + FixerApi.apiKey;
    @Override
    public ExchangeRate load(Currency from, Currency to) {
        try {
            LocalDate currentDate = getCurrentDate();
            double rate = getRateBetween(from, to);
            return new ExchangeRate(from, to, currentDate, rate);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static LocalDate getCurrentDate() {
        return LocalDate.now();
    }

    private double getRateBetween(Currency from, Currency to) throws IOException {
        String urlCustomized = BASE_URL + "&symbols=" + from.code() + "," + to.code();
        URL url = new URL(urlCustomized);
        String body = getBodyOf(url);
        return getRateOf(body, from, to);
    }

    private String getBodyOf(URL url) throws IOException {
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        int statusCode = connection.getResponseCode();
        if (statusCode > 299 || statusCode < 200) {
            throw new IOException("Error while loading rate. HTTP error: " + statusCode);
        }
        try (InputStream is = connection.getInputStream();
             BufferedReader reader = new BufferedReader(new InputStreamReader(is, StandardCharsets.UTF_8))) {
            return adaptBody(reader);
        }
    }

    private static String adaptBody(BufferedReader reader) throws IOException {
        StringBuilder body = new StringBuilder();
        String line;
        while ((line = reader.readLine()) != null) body.append(line);
        return body.toString();
    }

    private double getRateOf(String body, Currency from, Currency to) {
        JsonObject rates = new Gson().fromJson(body, JsonObject.class)
                .getAsJsonObject("rates");
        double fromRate = rates.getAsJsonPrimitive(from.code()).getAsDouble();
        double toRate = rates.getAsJsonPrimitive(to.code()).getAsDouble();
        return toRate/fromRate;
    }
}
