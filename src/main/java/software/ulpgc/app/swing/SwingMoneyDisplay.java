package software.ulpgc.app.swing;

import software.ulpgc.architecture.model.Money;
import software.ulpgc.architecture.view.MoneyDisplay;

import javax.swing.*;

public class SwingMoneyDisplay extends JLabel implements MoneyDisplay {

    public SwingMoneyDisplay() {
        this.setHorizontalAlignment(JLabel.CENTER);
        this.setVerticalAlignment(JLabel.CENTER);
    }

    @Override
    public void show(Money money) {
        String formatedAmount = String.format("%.2f", money.amount());
        this.setText(formatedAmount + " - " + money.currency());
    }
}
