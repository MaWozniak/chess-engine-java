import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Comparator;

public class Algorithm3 {

    public ArrayList<Sequence> sequences = new ArrayList<>();
    public ArrayList<Move> movesRecord = new ArrayList<>();

    private ArrayList<Move> movesGenerate = new ArrayList<>();
    private ArrayList<Move> movesDepth1 = new ArrayList<>();
    private ArrayList<Move> movesDepth2 = new ArrayList<>();
    private String version;
    private Board board;

    private static DecimalFormat df = new DecimalFormat("#.###");

    public Algorithm3(String version) {
        board = new Board(version);
        this.version = version;
    }

    public void addRecordMove(Move move) {
        movesRecord.add(move);
    }

    public Move makeMove(char color, char version) {

        generate(color);

        return Decision();
    }

    public void RemoveCheckmates() {

        //Removing sequences with Check or Checkmate

        for (int i = sequences.size() - 1; i >= 0; i--) {
            if (sequences.get(i).check) {
                sequences.remove(i);
            }
        }
    }


    public void generate(char side) {
//
//        double value1;
//        double value2;
//        double value3 = 0.0;
//        double value4;
//        double bestSideB = -200.0;
//        double bestSideB_2 = -200.0;
//        double bestWorth = 200.0;
//        double worth = 200.0;
//        double alpha = 200.0;
//        double beta = 200.0;
//        double bestBeta = -200.0;
//        double worstBeta = 200.0;
//        double avaregeBeta = 0.0;
//        int counterBeta = 0;

        char sideA = 'W';
        char sideB = 'B';

        if (side == 'B') {
            sideA = 'B';
            sideB = 'W';
        }

        Board tempBoard = new Board(this.version);
        tempBoard.copyBoard(this.board);
        this.generateMoves(sideA);

        System.out.println("Board value: " + board.value(sideA));

        //ALGORITHM:

        for (int i = 0; i < movesGenerate.size(); i++) {

            board.makeMove(sideA, movesGenerate.get(i));

            movesGenerate.get(i).introduce();
            System.out.println(" Value: " + board.value(sideA));

            board.copyBoard(tempBoard);
        }

    }

    public Move Decision() {

        //BlackIsChackmated
        Move BlackIsCheckmated = new Move(0, 0, 0, 0, 0, false, 100);

        Move Decision = BlackIsCheckmated;

        if (sequences.size() != 0) {
            Decision = sequences.get(0).move(0);
        }
        //WhiteisChackmated
        if (sequences.get(0).worthDepth4 < -50) {
            Decision.setCheckmate();
        }

        return Decision;
    }

    public void generateMoves(char color) {
        board.createPositionsArray();

        movesGenerate.clear();

        if (color == 'W') {
            for (int i = 0; i < 19; i++) {
                movesGenerate.addAll(board.whitePieces[i].generateMoves(board.position, i, board.getLastMove()));
            }
        }

        if (color == 'B') {
            for (int i = 0; i < 19; i++) {
                movesGenerate.addAll(board.blackPieces[i].generateMoves(board.position, i, board.getLastMove()));
            }
        }

        movesDepth1.clear();
        movesDepth1.addAll(movesGenerate);
    }

    public Board board() {

        return this.board;
    }

    public String listOfMoves(char color) {

        GenerateSequences(color);

        CheckCheckmate(color);

        RemoveCheckmates();

        String list = "";

        for (int i = 0; i < sequences.size(); i++) {

            list = list + (char) (sequences.get(i).move(0).getPos1_X() + 96) + sequences.get(i).move(0).getPos1_Y() + " - " +
                    (char) (sequences.get(i).move(0).getPos2_X() + 96) + sequences.get(i).move(0).getPos2_Y() + "     ";

            if ((i - 2) % 3 == 0) {
                list = list + "\n";
            }
        }
        return list;
    }


    public void CheckCheckmate(char color) {

        double value1 = 0.0;
        double value2 = 0.0;

        char sideA = 'W';
        char sideB = 'B';

        if (color == 'B') {
            sideA = 'B';
            sideB = 'W';
        }

        Board tempBoard = new Board(version);
        tempBoard.copyBoard(this.board);

        for (int i = 0; i < sequences.size(); i++) {

            board.makeMove(sideA, sequences.get(i).move(0));

            value1 = board.value(sideA);

            if (value1 < -50) {

                sequences.get(i).checkmate = true;
            }

            this.generateMoves(sideB);

            for (int j = 0; j < movesDepth2.size(); j++) {

                board.makeMove(sideB, movesDepth2.get(j));

                value2 = board.value(sideB);


                if (value2 > 50) {

                    sequences.get(i).check = true;
                }

                board.copyBoard(tempBoard);
                board.makeMove(sideA, sequences.get(i).move(0));
            }

            board.copyBoard(tempBoard);
        }
    }

    public void GenerateSequences(char color) {

        sequences.clear();

        generateMoves(color);

        for (int i = 0; i < movesDepth1.size(); i++) {

            sequences.add(new Sequence());
            sequences.get(i).set(0, movesDepth1.get(i));
        }

    }

}
