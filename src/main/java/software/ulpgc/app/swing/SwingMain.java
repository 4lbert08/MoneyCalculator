package software.ulpgc.app.swing;

import software.ulpgc.app.fixerApi.FixerApiCurrenciesLoader;
import software.ulpgc.app.fixerApi.FixerApiExchangeRateLoader;
import software.ulpgc.architecture.control.Command;
import software.ulpgc.architecture.control.ExchangeMoneyCommand;
import software.ulpgc.architecture.model.Currency;

import java.io.File;
import java.util.List;

import static software.ulpgc.architecture.io.ImageDownloader.downloadImage;

public class SwingMain {
    public static void main(String[] args) throws Exception {
        File path = new File("");
        String Path = path.getAbsolutePath();
        String urlImage = "https://cdn.pixabay.com/photo/2013/07/12/14/43/money-exchange-148668_640.png";
        String finalPath = Path+"\\Icon.png";
        downloadImage(urlImage, finalPath);

        SwingMainFrame mainFrame = new SwingMainFrame();
        List<Currency> currencies = new FixerApiCurrenciesLoader().load();
        Command command = new ExchangeMoneyCommand(
                mainFrame.getCurrencyDialog().define(currencies, "To which currency do" +
                        " you want to change it:"),
                mainFrame.getMoneyDialog().define(currencies, "Quantity to exchange:"),
                mainFrame.getMoneyDisplay(),
                new FixerApiExchangeRateLoader());
                mainFrame.put("exchange money", command);
        mainFrame.setVisible(true);
    }
}
