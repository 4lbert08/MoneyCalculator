package software.ulpgc.app.swing;

import software.ulpgc.architecture.model.Money;
import software.ulpgc.architecture.view.MoneyDisplay;

import javax.swing.*;
import java.awt.*;

public class SwingMoneyDisplay extends JLabel implements MoneyDisplay {

    public SwingMoneyDisplay() {
        this.setHorizontalAlignment(JLabel.CENTER);
        this.setVerticalAlignment(JLabel.CENTER);
    }

    @Override
    public void show(Money money) {
        this.setText(money.toString());
    }
}
