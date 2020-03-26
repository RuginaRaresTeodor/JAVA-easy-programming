package GUI;

import com.sun.xml.internal.bind.v2.TODO;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

import static GUI.DrawingPanel.H;
import static GUI.DrawingPanel.W;

public class ConfigPanel extends JPanel {
    final MainFrame frame;
    JLabel sizeLabel; // we’re drawing regular polygons
    JSpinner sidesField;
    JSpinner sizeField;// number of sides
    JComboBox colorCombo; // the color of the shape
    JLabel sidesLabel;

    public ConfigPanel(MainFrame frame) {
        this.frame = frame;
        init();
    }

    private void init() {
        //create the label and the spinner
        sizeLabel = new JLabel( "Size:");
        sizeField = new JSpinner(new SpinnerNumberModel(3, 3, 100, 1));
        sidesLabel = new JLabel("Number of sides:");
        sidesField = new JSpinner(new SpinnerNumberModel(0, 0, 100, 1));
        sidesField.setValue(3); //default number of sides
        String[] colors={"Random","Black"};
        // random colors sunt in drawing panel
        colorCombo=new JComboBox<>(colors);
        colorCombo.setSelectedIndex(1);
        add(sizeLabel);
        add(sizeField);
        add(sidesLabel); //JPanel uses FlowLayout by default
        add(sidesField);
        add(colorCombo);

    }
}