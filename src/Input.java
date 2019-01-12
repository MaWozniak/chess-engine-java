import javax.swing.*;
import java.awt.*;

public class Input extends JFrame {
    public JTextArea textInput;

    Input() {
        JPanel inputPanel = new JPanel();

        this.setSize(480, 130);
        this.setLocationRelativeTo(null);
        //setLocation(760, 870); //center
        setLocation(1170, 870);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Input");
        this.setResizable(false);

        textInput = new JTextArea(4, 8);
        textInput.setBackground(Color.BLACK);
        textInput.setForeground(Color.WHITE);
        textInput.setFont(new Font("Times", Font.BOLD, 58));
        textInput.setText("");
        textInput.setLineWrap(true);
        textInput.setWrapStyleWord(true);

        inputPanel.setBackground(new Color(70, 70, 78));
        inputPanel.add(textInput);

        this.add(inputPanel);
        this.setVisible(true);
    }

}
