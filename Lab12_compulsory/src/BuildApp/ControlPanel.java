package BuildApp;

import javax.swing.*;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ControlPanel extends JPanel {
    private final MainFrame frame;
    private final JLabel classLabel = new JLabel("Swing Class:");
    private final JTextField classField = new JTextField(35);
    private final JButton addButton = new JButton("Add");
    //private final JComboBox classNameField =
    private final JLabel nameLabel = new JLabel("Add name:");
    private final JTextField nameField = new JTextField(15) ;

    public ControlPanel(MainFrame frame) {
        this.frame = frame;
        add(classLabel);
        add(classField);
        add(nameLabel);
        add(nameField);
        add(addButton);
        addButton.addActionListener(e -> {
            JComponent componentJ = null;
            try { componentJ = createComponent(classField.getText(), nameField.getText());
            } catch (ClassNotFoundException ex) {
                ex.printStackTrace();
                System.out.println("Error, better look StackTrace and good luck!");
            }
            frame.designPanel.absolutePosition(componentJ);
        });
    }

    private JComponent createComponent(String className, String text) throws ClassNotFoundException {
        Class c = Class.forName(className);
        try {// note that button can be initiated with null and wont get the classname like Panel
            Method method = c.getMethod("setText", String.class);
            JComponent j = (JComponent)c.newInstance();
            method.invoke(j, text);
            return j;
        } catch (IllegalAccessException | InstantiationException | InvocationTargetException | NoSuchMethodException  e) {
            e.printStackTrace();
            System.out.println("Error, better look StackTrace and good luck!");
        }
        return new JLabel(className);
    }

}