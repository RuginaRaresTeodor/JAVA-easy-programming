package BuildApp;

import javax.swing.*;
import java.awt.*;

public class InfoPanel extends JPanel {
    public static final int W = 700, H = 100;
    private final MainFrame frame;
    private final JLabel infoLabel = new JLabel("You need to enter the full name of swing class like: javax.swing.JButton");
    public InfoPanel(MainFrame frame) {
        this.frame = frame;
        add(infoLabel);
    }
}
