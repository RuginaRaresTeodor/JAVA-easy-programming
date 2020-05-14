package BuildApp;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class DesignPanel extends JPanel {
    public static final int W = 700, H = 400;
    private final MainFrame frame;

    public DesignPanel(MainFrame frame) {
        this.frame = frame;
        setPreferredSize(new Dimension(W, H));
        setLayout(null);
    }

    public void absolutePosition(JComponent componentJ) {
        //absolute position with random numbers + size made for preferredSize
        Random rand = new Random();
        componentJ.setBounds(rand.nextInt(W-0), rand.nextInt(H-0), componentJ.getPreferredSize().width, componentJ.getPreferredSize().height);
        this.add(componentJ);
        frame.setVisible(true);
        frame.repaint();
    }

}
