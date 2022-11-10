package code;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {
    private JPanel panel;
    private JButton selectButton;
    private JButton unselectButton;
    private JCheckBox checkBox;

    public Main() {
        selectButton.addActionListener(e -> checkBox.setSelected(true));
        unselectButton.addActionListener(e -> checkBox.setSelected(false));
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Check Uncheck");
        frame.setContentPane(new Main().panel);

        frame.setSize(400, 400);
        frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        frame.setVisible(true);
    }
}
