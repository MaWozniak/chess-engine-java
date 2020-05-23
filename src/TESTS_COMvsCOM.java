import javax.swing.*;
import java.util.Scanner;

public class TESTS_COMvsCOM {
    //in console:
    // c - whites make move
    // b - blacks make move
    // a - continuous game

    private TestBoards tests = new TestBoards();
    private BoardDisplay2 testDisplay = new BoardDisplay2();
    private GameLog log = new GameLog();
    private Scanner reader = new Scanner(System.in);

    private Algorithm algorithm = new Algorithm();

    public static void main(String[] args) {
        new TESTS_COMvsCOM();
    }

    public TESTS_COMvsCOM() {

        algorithm.board().copyBoard(tests.test0);

        testDisplay.setPieces(algorithm.board());

        //////////////////////////////////////

        String input = reader.next();

        for (int i = 1; i < 100; i++) {

            System.out.println(i);
            //automat
            if (input.equals("a")) {

                for (int j = 1; j < 200; j++) {
                    Move GENERATED;
                    GENERATED = algorithm.makeMove('W', 'b');
                    algorithm.board().makeMove('W', GENERATED);
                    log.whiteMove(GENERATED);
                    testDisplay.setPieces(algorithm.board());

                    /////////////////////////////////////////////////////////
                    Move GENERATED2;
                    GENERATED2 = algorithm.makeMove('B', 'b');
                    algorithm.board().makeMove('B', GENERATED2);
                    log.blackMove(GENERATED2);
                    testDisplay.setPieces(algorithm.board());

                    /////////////////////////////////////////////////////////

//                    board.makeMove('B', algorithm.makeMove('B', 'b'));
//                    testDisplay.setPieces(board);
                    // board.makeMove('B',board.createDepth2_PROTOTYPE('B','W'));
                }

            }
//            if (input.equals("c")) {
//
//                algorithm.board().copyBoard(tests.test0);
//                Move GENERATED = algorithm.makeMove('W', 'b');
//                board.makeMove('W', GENERATED);
//                algorithm.board().makeMove('W', GENERATED);
//                testDisplay.setPieces(algorithm.board());
//                testDisplay.setPieces(board);
//            }
//            if (input.equals("b")) {
//
//                algorithm.board().copyBoard(tests.test0);
//                Move GENERATED = algorithm.makeMove('B', 'b');
//                board.makeMove('B', algorithm.makeMove('B', 'b'));
//                algorithm.board().makeMove('B', GENERATED);
//                testDisplay.setPieces(algorithm.board());
//                testDisplay.setPieces(board);
//            }
            //if(input.equals("b")) {board.makeMove('B', board.createDepth6verC('B', 'W')); testDisplay.setPieces(board);}

            System.out.println("ok");

            input = reader.next();
        }

    }
}
