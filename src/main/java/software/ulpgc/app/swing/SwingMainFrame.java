package software.ulpgc.app.swing;

import software.ulpgc.architecture.control.Command;
import software.ulpgc.architecture.view.*;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.Map;

public class SwingMainFrame extends JFrame {
    private final Map<String, Command> commands;
    private MoneyDisplay moneyDisplay;
    private MoneyDialog moneyDialog;
    private CurrencyDialog currencyDialog;


    public SwingMainFrame() {
        commands = new HashMap<>();
        setTitle("Money Calculator App");
        setSize(750, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        this.setLayout(new GridLayout(4,1,5,5));
        this.add(createMoneyDialog());
        this.add(createCurrencyDialog());
        this.add(exchangeButton());
        this.add(createMoneyDisplay());
    }

    private Component exchangeButton() {
        JPanel panel = new JPanel();
        JButton button = new JButton("Exchange");
        button.addActionListener(_ -> commands.get("exchange money").execute());
        panel.add(button);
        return panel;
    }

    private Component createMoneyDisplay() {
        SwingMoneyDisplay display = new SwingMoneyDisplay();
        this.moneyDisplay = display;
        return display;
    }

    private Component createCurrencyDialog() {
        SwingCurrencyDialog dialog = new SwingCurrencyDialog();
        this.currencyDialog = dialog;
        return dialog;
    }

    private Component createMoneyDialog() {
        SwingMoneyDialog dialog = new SwingMoneyDialog();
        this.moneyDialog = dialog;
        return dialog;
    }


    public MoneyDisplay getMoneyDisplay() {
        return moneyDisplay;
    }

    public MoneyDialog getMoneyDialog() {
        return moneyDialog;
    }

    public CurrencyDialog getCurrencyDialog() {
        return currencyDialog;
    }

    public void put(String key, Command value) {
        commands.put(key, value);
    }
}
