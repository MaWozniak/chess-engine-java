import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class TESTS_Human {

    private TestBoards tests = new TestBoards();
    private BoardDisplay2 testDisplay = new BoardDisplay2();
    private GameLog log = new GameLog();
    private Input input = new Input();

    private Algorithm algorithm = new Algorithm("brute force");

    public static void main(String[] args) {
        new TESTS_Human();
    }

    public TESTS_Human() {

        algorithm.board().copyBoard(tests.test0);

        ListenForKeys lForKeys = new ListenForKeys();
        input.textInput.addKeyListener(lForKeys);

        testDisplay.setPieces(algorithm.board());

    }

    public class ListenForKeys implements KeyListener {
        int validMove = 0;

        @Override
        public void keyTyped(KeyEvent e) {


        }

        @Override
        public void keyPressed(KeyEvent e) {
            if (e.getKeyChar() == '\n') {

                String move = input.textInput.getText();

                Move ENTERED;

                algorithm.GenerateSequences('W');
                algorithm.CheckCheckmate('W');
                algorithm.RemoveCheckmates();

                if (move.length() >= 5) {

                    for (int i = 0; i < algorithm.sequences.size(); i++) {

                        if ((algorithm.sequences.get(i).move(0).getPos1_X() == move.charAt(0) - 96) && (algorithm.sequences.get(i).move(0).getPos1_Y() == move.charAt(1) - 48)
                                && (algorithm.sequences.get(i).move(0).getPos2_X() == move.charAt(3) - 96) && (algorithm.sequences.get(i).move(0).getPos2_Y() == move.charAt(4) - 48)) {
                            ENTERED = algorithm.sequences.get(i).move(0);

                            algorithm.board().makeMove('W', ENTERED);
                            algorithm.addRecordMove(ENTERED);
                            log.whiteMove(ENTERED);

                            validMove = 1;
                        }
                    }
                }

                if (validMove == 0) {
                    JOptionPane.showMessageDialog(testDisplay, "There's no such a move.\n\nAvailable moves:\n" + algorithm.listOfMoves('W') + "\n\nRemember SPACE between:\n \"e2 e4\" !",
                            "Ups...", JOptionPane.INFORMATION_MESSAGE);

                    input.textInput.setText("");
                    input.textInput.requestFocus();
                }


                testDisplay.setPieces(algorithm.board());

                input.textInput.setText("");
                input.textInput.requestFocus();

            }

        }

        @Override
        public void keyReleased(KeyEvent e) {
            if (e.getKeyChar() == '\n') {

                if (validMove == 1) {
                    Move GENERATED;

                    GENERATED = algorithm.makeMove('B', 'b');

                    if (GENERATED.getSpecialMove() == 100) {
                        JOptionPane.showMessageDialog(testDisplay, "Congratulations - White Wins!",
                                "Checkmate", JOptionPane.INFORMATION_MESSAGE);
                    }


                    algorithm.board().makeMove('B', GENERATED);
                    algorithm.addRecordMove(GENERATED);
                    log.blackMove(GENERATED);

                    testDisplay.setPieces(algorithm.board());

                    if (GENERATED.getCheckmate()) {
                        JOptionPane.showMessageDialog(testDisplay, "Black Wins",
                                "Checkmate", JOptionPane.INFORMATION_MESSAGE);
                    }

                    input.textInput.setText("");
                    input.textInput.requestFocus();

                    validMove = 0;

                    //END ALGORITHM
                } else {

                    input.textInput.setText("");
                    input.textInput.requestFocus();
                }


            }

        }
    }
}
