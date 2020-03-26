package GUI;

import com.sun.xml.internal.bind.v2.TODO;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ControlPanel extends JPanel {
    final MainFrame frame;
    JButton saveBtn = new JButton("Save");
    JButton loadBtn = new JButton("Load");
    JButton resetBtn = new JButton("Reset");
    JButton exitBtn = new JButton("Exit");
    //create all buttons (Load, Reset, Exit)


    public ControlPanel(MainFrame frame) {
        this.frame = frame;
        init();
    }
    private void init() {
        //change the default layout manager (just for fun)
        setLayout(new GridLayout(1, 4));
//add all buttons
        add(exitBtn);
        add(loadBtn);
        add(saveBtn);
        add(resetBtn);
        //mai adauga
        //config listeners for all buttons
        exitBtn.addActionListener(this::exit);
        loadBtn.addActionListener(this::load);
        saveBtn.addActionListener(this::save);
        resetBtn.addActionListener(this::reset);
        //adaug...

    }
    private void exit(ActionEvent e)
    {

        System.exit (0); ;
    }
    private void load(ActionEvent e)
    {
        try {
            BufferedImage image;
            image = ImageIO.read(new File("test2.png"));
            frame.canvas.graphics.drawImage(image, 0, 0, this);

        } catch (IOException ex) {
            System.err.println(ex);
        }
    }
    //se salveaza in directorul proiectului (pt mac)
    private void save(ActionEvent e) {
        try {
            ImageIO.write(frame.canvas.image, "PNG", new File("test2.png"));
        } catch (IOException ex) {
            System.err.println(ex);
        }
    }

    private void reset(ActionEvent e) {
        frame.canvas.clear();
    }

}