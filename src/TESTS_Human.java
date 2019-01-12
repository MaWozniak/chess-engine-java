import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class TESTS_Human {

    private TestBoards tests = new TestBoards();
    private BoardDisplay2 testDisplay = new BoardDisplay2();
    private GameLog log = new GameLog();
    private Input input = new Input();

    private Algorithm algorithm = new Algorithm();


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
        int check = 0;

        @Override
        public void keyTyped(KeyEvent e) {


        }

        @Override
        public void keyPressed(KeyEvent e) {
            if (e.getKeyChar() == '\n') {

                String move = input.textInput.getText();

                Move ENTERED;


                algorithm.board().generateMoves('W', 1);

                for (int i = 0; i < algorithm.board().getMovesDepth1().size(); i++) {

                    if ((algorithm.board().getMovesDepth1().get(i).getPos1_X() == move.charAt(0) - 96) && (algorithm.board().getMovesDepth1().get(i).getPos1_Y() == move.charAt(1) - 48)
                            && (algorithm.board().getMovesDepth1().get(i).getPos2_X() == move.charAt(3) - 96) && (algorithm.board().getMovesDepth1().get(i).getPos2_Y() == move.charAt(4) - 48)) {
                        ENTERED = algorithm.board().getMovesDepth1().get(i);

                        algorithm.board().makeMove('W', ENTERED);
                        log.whiteMove(ENTERED);

                        check = 1;
                    }
                }

                if (check == 0) {
                    JOptionPane.showMessageDialog(testDisplay, "There's no such a move.\n\nAvailable moves:\n" + algorithm.board().listOfMoves() + "\n\nRemember SPACE between:\n \"e2 e4\" !",
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

                if (check == 1) {
                    Move GENERATED;

                    GENERATED = algorithm.makeMove('B', 'b'); //TESTING: 'd'
                    // GENERATED = algorithm.board().createDepth4('B','W','b');

                    algorithm.board().makeMove('B', GENERATED);
                    log.blackMove(GENERATED);

                    testDisplay.setPieces(algorithm.board());

                    input.textInput.setText("");
                    input.textInput.requestFocus();

                    check = 0;

                    //END ALGORITHM
                } else {

                    input.textInput.setText("");
                    input.textInput.requestFocus();
                }


            }

        }
    }
}
