package Components;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class FrameWindow extends JFrame {
    JPanel msgPanel, textPanel, buttonPanel;
    JLabel msgLabel;
    JTextField textField;
    JButton clickButton;
    public FrameWindow(String title) {
        super(title);
        setSize(320,240);
        setLayout(new GridLayout(3,1,5,5));

        msgPanel = new JPanel();
        msgLabel = new JLabel("Hello, dear user. Please input your username.");
        msgPanel.add(msgLabel);
        add(msgPanel);

        textPanel = new JPanel();
        textField = new JTextField(20);
        textPanel.add(textField);
        add(textPanel);

        buttonPanel = new JPanel();
        clickButton = new JButton("Register");
        buttonPanel.add(clickButton);
        add(buttonPanel);

        clickButton.addActionListener(new ButtonHandler());
    }

    class ButtonHandler implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getSource() == clickButton) {
                JOptionPane.showMessageDialog(textField, "Congratulations on your registration!\n" +
                        "Hello "+textField.getText());
                msgLabel.setText("User: "+textField.getText());
            }
        }
    }
}
public class SwingWindow {
    public static void main(String[] args) {
        FrameWindow frameWindow = new FrameWindow("Welcome");
        frameWindow.setVisible(true);
    }
}
