import javax.swing.*;
import java.util.Scanner;

public class TESTS_COMvsCOM {
    /*
    //in console:
    // c - whites make move
    // b - blacks make move
    // a - continuous game

    private TestBoards tests = new TestBoards();
    private BoardDisplay2 testDisplay = new BoardDisplay2();
    private GameLog log = new GameLog();
    private Scanner reader = new Scanner(System.in);

    private Algorithm2 algorithmW = new Algorithm2("moves");
    private Algorithm algorithmB = new Algorithm("brute force");
    //private Algorithm2 algorithmB = new Algorithm2("none");

    public static void main(String[] args) {
        new TESTS_COMvsCOM();
    }

    public TESTS_COMvsCOM() {

        algorithmW.board().copyBoard(tests.test0);
        algorithmB.board().copyBoard(tests.test0);

        testDisplay.setPieces(algorithmW.board());

        //////////////////////////////////////

        String input = reader.next();

        for (int i = 1; i < 100; i++) {

            System.out.println(i);
            //automat
            if (input.equals("a")) {

                for (int j = 1; j < 200; j++) {
                    Move GENERATED;
                    GENERATED = algorithmW.makeMove('W', 'b');
                    algorithmW.board().makeMove('W', GENERATED);
                    algorithmW.addRecordMove(GENERATED);
                    algorithmB.board().makeMove('W', GENERATED);
                    algorithmB.addRecordMove(GENERATED);
                    log.whiteMove(GENERATED);
                    testDisplay.setPieces(algorithmW.board());

                    /////////////////////////////////////////////////////////
                    Move GENERATED2;
                    GENERATED2 = algorithmB.makeMove('B', 'b');
                    algorithmB.board().makeMove('B', GENERATED2);
                    algorithmB.addRecordMove(GENERATED2);
                    algorithmW.board().makeMove('B', GENERATED2);
                    algorithmW.addRecordMove(GENERATED2);
                    log.blackMove(GENERATED2);
                    testDisplay.setPieces(algorithmB.board());

                    /////////////////////////////////////////////////////////

                }

                System.out.println("ok");

                input = reader.next();
            }
        }

    }

     */
}
