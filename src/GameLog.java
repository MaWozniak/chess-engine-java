import javax.swing.*;
import java.awt.*;

public class GameLog extends JFrame {
    JTextArea textArea1;
    int counter = 1;

    public GameLog() {
        this.setSize(200, 650);
        this.setLocationRelativeTo(null);
        setLocation(860, 150);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Game Log");
        this.setResizable(false);

        JPanel thePanel = new JPanel();

        thePanel.setBackground(new Color(70, 70, 78));

        textArea1 = new JTextArea(27, 10);
        textArea1.setBackground(Color.BLACK);
        textArea1.setForeground(Color.WHITE);
        textArea1.setFont(new Font("Times", Font.BOLD, 18));
        textArea1.setText("");
        textArea1.setLineWrap(true);
        textArea1.setWrapStyleWord(true);
        textArea1.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(textArea1,
                JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
                JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

        thePanel.add(scrollPane);
        this.add(thePanel);
        this.setVisible(true);
    }

    public void whiteMove(Move move) {
        textArea1.append(" " + counter + ".  " + move.pieceInitial() + (char) (move.getPos2_X() + 96) + move.getPos2_Y() + " ");
        counter++;
    }

    public void blackMove(Move move) {
        textArea1.append(" " + move.pieceInitial() + (char) (move.getPos2_X() + 96) + move.getPos2_Y() + " \n");
    }


}
