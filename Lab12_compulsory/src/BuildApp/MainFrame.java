package BuildApp;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame{
    ControlPanel controlPanel;
    DesignPanel designPanel;
    InfoPanel infoPanel;
    private MainFrame() {
        this.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
        controlPanel = new ControlPanel(this) ;
        designPanel = new DesignPanel(this);
        infoPanel = new InfoPanel(this);
        this.setVisible (true);
        this.add (controlPanel, BorderLayout.NORTH);
        this.add (designPanel, BorderLayout.CENTER);
        this.add (infoPanel,BorderLayout.SOUTH);
        pack();
    }
    public static void main ( String[] args ) {
        new MainFrame();
    }
}