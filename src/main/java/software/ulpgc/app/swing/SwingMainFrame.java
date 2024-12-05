package software.ulpgc.app.swing;

import software.ulpgc.architecture.control.Command;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class SwingMainFrame extends JFrame {
    private final List<Command> commands;

    public SwingMainFrame() {
        commands = new ArrayList<>();
    }
}
