package software.ulpgc.app.swing;

import software.ulpgc.architecture.model.Currency;
import software.ulpgc.architecture.view.CurrencyDialog;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class SwingCurrencyDialog extends JPanel implements CurrencyDialog {
    private JComboBox<Currency> currencySelector;

    public SwingCurrencyDialog() {setLayout(new FlowLayout());}

    @Override
    public CurrencyDialog define(List<Currency> currencies, String header) {
        add(new JLabel(header));
        add(createCurrencySelector(currencies));
        return this;
    }

    private Component createCurrencySelector(List<Currency> currencies) {
        JComboBox<Currency> selector = new JComboBox<>();
        for (Currency currency : currencies) selector.addItem(currency);
        this.currencySelector = selector;
        return selector;
    }

    @Override
    public Currency get() {
        return currencySelector.getItemAt(currencySelector.getSelectedIndex());
    }
}
