import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Board {
    public Piece[] whitePieces = new Piece[19];
    public Piece[] blackPieces = new Piece[19];

    private double score = 0.0;
    private double whiteScore = 0.0;
    private double blackScore = 0.0;

    public int[][] position = new int[9][9];

    private ArrayList<Move> movesGenerate = new ArrayList<Move>();
    private ArrayList<Move> movesSelected = new ArrayList<Move>();
    private ArrayList<Move> movesDepth1 = new ArrayList<Move>();
    private ArrayList<Move> movesDepth2 = new ArrayList<Move>();
    private ArrayList<Move> movesDepth3 = new ArrayList<Move>();
    private ArrayList<Move> movesDepth4 = new ArrayList<Move>();
    private ArrayList<Move> movesDepth5 = new ArrayList<Move>();
    private ArrayList<Move> movesDepth6 = new ArrayList<Move>();
    private ArrayList<Move> movesDepth7 = new ArrayList<Move>();
    private ArrayList<Move> movesDepth8 = new ArrayList<Move>();
    private ArrayList<Move> movesDepth9 = new ArrayList<Move>();
    private ArrayList<Move> movesDepth10 = new ArrayList<Move>();

    //for En passant
    private Move lastMove = new Move();

    final DecimalFormat df = new DecimalFormat("#0.000");
    private double value4response;

    public Board() {
        whitePieces[0] = new Piece(true, 'W', 1, 2);
        whitePieces[1] = new Piece(true, 'W', 2, 2);
        whitePieces[2] = new Piece(true, 'W', 3, 2);
        whitePieces[3] = new Piece(true, 'W', 4, 2);
        whitePieces[4] = new Piece(true, 'W', 5, 2);
        whitePieces[5] = new Piece(true, 'W', 6, 2);
        whitePieces[6] = new Piece(true, 'W', 7, 2);
        whitePieces[7] = new Piece(true, 'W', 8, 2);
        whitePieces[8] = new Rock(true, 'W', 1, 1);
        whitePieces[9] = new Knight(true, 'W', 2, 1);
        whitePieces[10] = new Bishop(true, 'W', 3, 1);
        whitePieces[11] = new Queen(true, 'W', 4, 1);
        whitePieces[12] = new King(true, 'W', 5, 1);
        whitePieces[13] = new Bishop(true, 'W', 6, 1);
        whitePieces[14] = new Knight(true, 'W', 7, 1);
        whitePieces[15] = new Rock(true, 'W', 8, 1);
        whitePieces[16] = new Queen(false, 'W', 6, 8); //for change on last line
        whitePieces[17] = new Queen(false, 'W', 7, 8); //for change on last line
        whitePieces[18] = new Queen(false, 'W', 8, 8); //for change on last line

        blackPieces[0] = new Piece(true, 'B', 1, 7);
        blackPieces[1] = new Piece(true, 'B', 2, 7);
        blackPieces[2] = new Piece(true, 'B', 3, 7);
        blackPieces[3] = new Piece(true, 'B', 4, 7);
        blackPieces[4] = new Piece(true, 'B', 5, 7);
        blackPieces[5] = new Piece(true, 'B', 6, 7);
        blackPieces[6] = new Piece(true, 'B', 7, 7);
        blackPieces[7] = new Piece(true, 'B', 8, 7);
        blackPieces[8] = new Rock(true, 'B', 1, 8);
        blackPieces[9] = new Knight(true, 'B', 2, 8);
        blackPieces[10] = new Bishop(true, 'B', 3, 8);
        blackPieces[11] = new Queen(true, 'B', 4, 8);
        blackPieces[12] = new King(true, 'B', 5, 8);
        blackPieces[13] = new Bishop(true, 'B', 6, 8);
        blackPieces[14] = new Knight(true, 'B', 7, 8);
        blackPieces[15] = new Rock(true, 'B', 8, 8);
        blackPieces[16] = new Queen(false, 'B', 6, 1); //for change on last line
        blackPieces[17] = new Queen(false, 'B', 7, 1); //for change on last line
        blackPieces[18] = new Queen(false, 'B', 8, 1); //for change on last line
    }

    public Piece getWhitePiece(int index) {
        return this.whitePieces[index];
    }

    public Piece getBlackPiece(int index) {
        return this.blackPieces[index];
    }

    public ArrayList<Move> getMovesDepth1() {
        return movesDepth1;
    }

    public String listOfMoves() {

        String list = "";

        this.generateMoves('W', 1);
        for (int i = 0; i < movesDepth1.size(); i++) {

            list = list + (char) (movesDepth1.get(i).getPos1_X() + 96) + movesDepth1.get(i).getPos1_Y() + " - " +
                    (char) (movesDepth1.get(i).getPos2_X() + 96) + movesDepth1.get(i).getPos2_Y() + "     ";

            if ((i - 2) % 3 == 0) {
                list = list + "\n";
            }
        }
        return list;
    }

    public void makeMove(char color, Move move) {

        if (color == 'W') {
            whitePieces[move.getPieceIndex()].changePos(move.getPos2_X(), move.getPos2_Y());
            if (move.getCapture()) {
                for (int i = 0; i < 19; i++) {
                    if (blackPieces[i].getPosX() == move.getPos2_X() && blackPieces[i].getPosY() == move.getPos2_Y()) {
                        blackPieces[i].Death();
                    }
                }
            }
            //CASTLES
            if (move.getSpecialMove() == 1) {
                whitePieces[15].changePos(6, 1);
            }
            if (move.getSpecialMove() == 2) {
                whitePieces[8].changePos(4, 1);
            }
            //PROMOTION
            if (move.getSpecialMove() == 5) {
                whitePieces[move.getPieceIndex()].Death();
                for (int j = 16; j < 19; j++) {
                    if (!whitePieces[j].isAlive()) {
                        whitePieces[j].change(true, move.getPos2_X(), move.getPos2_Y());
                        break;
                    }
                }
            }
            //EN PASSANT
            if (move.getSpecialMove() == 7) {
                for (int i = 0; i < 8; i++) {
                    if (blackPieces[i].getPosX() == move.getPos2_X() && (blackPieces[i].getPosY() + 1) == move.getPos2_Y()) {
                        blackPieces[i].Death();
                    }
                }
            }

        }
        if (color == 'B') {
            blackPieces[move.getPieceIndex()].changePos(move.getPos2_X(), move.getPos2_Y());
            if (move.getCapture()) {
                for (int i = 0; i < 19; i++) {
                    if (whitePieces[i].getPosX() == move.getPos2_X() && whitePieces[i].getPosY() == move.getPos2_Y()) {
                        whitePieces[i].Death();
                    }
                }
            }
            //CASTLES
            if (move.getSpecialMove() == 3) {
                blackPieces[15].changePos(6, 8);
            }
            if (move.getSpecialMove() == 4) {
                blackPieces[8].changePos(4, 8);
            }
            //PROMOTION
            if (move.getSpecialMove() == 6) {
                blackPieces[move.getPieceIndex()].Death();
                for (int j = 16; j < 19; j++) {
                    if (!blackPieces[j].isAlive()) {
                        blackPieces[j].change(true, move.getPos2_X(), move.getPos2_Y());
                        break;
                    }
                }
            }
            //EN PASSANT
            if (move.getSpecialMove() == 8) {
                for (int i = 0; i < 8; i++) {
                    if (whitePieces[i].getPosX() == move.getPos2_X() && (whitePieces[i].getPosY() - 1) == move.getPos2_Y()) {
                        whitePieces[i].Death();
                    }
                }
            }
        }

        //for En passant
        this.setLastMove(move);

    }

    public double value(char color) {
        whiteScore = 0;
        blackScore = 0;

        for (int i = 0; i < 19; i++) {
            whiteScore += whitePieces[i].getScore();
        }
        for (int i = 0; i < 19; i++) {
            blackScore += blackPieces[i].getScore();

        }

        whiteScore += positionalValue('W');
        blackScore += positionalValue('B');

        if (color == 'W') {
            score = whiteScore - blackScore;
        }
        if (color == 'B') {
            score = blackScore - whiteScore;
        }

        //System.out.println("VP: "+df.format(score)+" ( "+df.format(whiteScore)+":"+df.format(blackScore)+" )"); //df it's DecimalFormat
        //for (int i=0; i<8; i++) { System.out.println("pawn W "+i+" - "+df.format(whitePawns[i].getScore())); }
        //for (int i=0; i<8; i++) { System.out.println("pawn B "+i+" - "+df.format(blackPawns[i].getScore())); }

        return score;
    }

    public double value(char color, boolean positional) {
        whiteScore = 0;
        blackScore = 0;

        if(positional) {
            for (int i = 0; i < 19; i++) {
                whiteScore += whitePieces[i].getScore();
            }
            for (int i = 0; i < 19; i++) {
                blackScore += blackPieces[i].getScore();
            }

            whiteScore += positionalValue('W');
            System.out.println("whiteScore positionalValue: "+df.format(positionalValue('W')));
            blackScore += positionalValue('B');
            System.out.println("blackScore positionalValue: "+df.format(positionalValue('B')));

            if (color == 'W') {
                score = whiteScore - blackScore;
            }
            if (color == 'B') {
                score = blackScore - whiteScore;
            }
        }
        return score;

    }

    public double positionalValue(char color) {
        //test
//        if(whitePieces[9].isAlive()) {
//            System.out.println("Knight DISTANCE KING: "+df.format(distanceBetweenPieces(whitePieces[9], blackPieces[12])));
//            System.out.println("Knight x DISTANCE KING: "+df.format(xDistanceBetweenPieces(whitePieces[9], blackPieces[12])));
//            System.out.println("Knight y DISTANCE KING: "+df.format(yDistanceBetweenPieces(whitePieces[9], blackPieces[12])));
//            System.out.println("Knight diagonal distance: "+df.format(diagonalDistance(whitePieces[9], blackPieces[12])));
//            System.out.println("Knight black pieces on line X: "+df.format(piecesBetweenOnLineY('B', whitePieces[9], blackPieces[12])));
//            System.out.println("Knight white pieces on line X: "+df.format(piecesBetweenOnLineY('W', whitePieces[9], blackPieces[12])));
//        }
        double result = 0;
        Piece[] piecesA = new Piece[19];
        Piece[] piecesB = new Piece[19];
        if(color == 'W') {
            piecesA = whitePieces;
            piecesB = blackPieces;
        }
        if(color == 'B') {
            piecesA = blackPieces;
            piecesB = whitePieces;
        }
        for (int i = 0; i < 19; i++) {
            if(piecesA[i].isAlive()){
                //pawns
                if(i < 8) {
                    result += (10 - distanceBetweenPieces(piecesA[i], piecesB[12])) / 5;
                }
                //knights + queens
                if((i == 9)||(i == 11)||(i == 14)||(i == 16)||(i == 17)||(i == 18)) {
                    result += (10 - distanceBetweenPieces(piecesA[i], piecesB[12]));
                }
                //rocks
                if((i == 8)||(i == 15)) {
                    result += (10 - xDistanceBetweenPieces(piecesA[i], piecesB[12])) / 3;
                }
                //bishops
                if((i == 10)||(i == 13)) {
                    result += (10 - diagonalDistance(piecesA[i], piecesB[12])) / 2;
                }
            }
        }

        return result/1;
    }

    public double distanceBetweenPieces(Piece piece1, Piece piece2) {
        int x1 = piece1.getPosX();
        int y1 = piece1.getPosY();
        int x2 = piece2.getPosX();
        int y2 = piece2.getPosY();
        return Math.sqrt(Math.pow((x2 - x1), 2) + Math.pow((y2 - y1), 2));
    }

    public double xDistanceBetweenPieces(Piece piece1, Piece piece2) {
        int x1 = piece1.getPosX();
        int x2 = piece2.getPosX();
        return Math.abs(x2 - x1);
    }

    public double yDistanceBetweenPieces(Piece piece1, Piece piece2) {
        int y1 = piece1.getPosY();
        int y2 = piece2.getPosY();
        return Math.abs(y2 - y1);
    }

    public double diagonalDistance(Piece piece1, Piece piece2) {
        int x1 = piece1.getPosX();
        int y1 = piece1.getPosY();
        int x2 = piece2.getPosX();
        int y2 = piece2.getPosY();
        return Math.abs(Math.abs(x1 - y1) - Math.abs(x2 - y2)) + 8 - Math.abs(x1 + y1 - x2 - y2);
    }

    public int piecesBetweenOnLineY(char color, Piece piece1, Piece piece2) {
        int result = 0;
        int x1 = piece1.getPosX();
        int y1 = piece1.getPosY();
        int x2 = piece2.getPosX();
        int y2 = piece2.getPosY();
        if( y1 < y2 ) {
            if(color == 'B') {
                for (int i = 0; i < 19; i++) {
                    if((blackPieces[i].getPosX() == x1)&&(blackPieces[i].getPosY() > y1)) {
                        result ++;
                    }
                }
            }
            if(color == 'W') {
                for (int i = 0; i < 19; i++) {
                    if((whitePieces[i].getPosX() == x1)&&(whitePieces[i].getPosY() > y1)) {
                        result ++;
                    }
                }
            }

        } else {
            if(color == 'B') {
                for (int i = 0; i < 19; i++) {
                    if((blackPieces[i].getPosX() == x1)&&(blackPieces[i].getPosY() < y1)) {
                        result ++;
                    }
                }
            }
            if(color == 'W') {
                for (int i = 0; i < 19; i++) {
                    if((whitePieces[i].getPosX() == x1)&&(whitePieces[i].getPosY() < y1)) {
                        result ++;
                    }
                }
            }

        }
        return result;
    }

    public void generateMoves(char color, int movesDepth) {
        this.createPositionsArray();

        movesGenerate.clear();

        if (color == 'W') {
            for (int i = 0; i < 19; i++) {
                movesGenerate.addAll(whitePieces[i].generateMoves(position, i, this.getLastMove()));
            }
        }

        if (color == 'B') {
            for (int i = 0; i < 19; i++) {
                movesGenerate.addAll(blackPieces[i].generateMoves(position, i, this.getLastMove()));
            }
        }

        switch (movesDepth) {
            case 1:
                movesDepth1.clear();
                movesDepth1.addAll(movesGenerate);
                break;
            case 2:
                movesDepth2.clear();
                movesDepth2.addAll(movesGenerate);
                break;
            case 3:
                movesDepth3.clear();
                movesDepth3.addAll(movesGenerate);
                break;
            case 4:
                movesDepth4.clear();
                movesDepth4.addAll(movesGenerate);
                break;
            case 5:
                movesDepth5.clear();
                movesDepth5.addAll(movesGenerate);
                break;
            case 6:
                movesDepth6.clear();
                movesDepth6.addAll(movesGenerate);
                break;
            case 7:
                movesDepth7.clear();
                movesDepth7.addAll(movesGenerate);
                break;
            case 8:
                movesDepth8.clear();
                movesDepth8.addAll(movesGenerate);
                break;
            case 9:
                movesDepth9.clear();
                movesDepth9.addAll(movesGenerate);
                break;
            case 10:
                movesDepth10.clear();
                movesDepth10.addAll(movesGenerate);
                break;
            default:
                break;
        }
    }

    public void selectionMoves(char color, int movesDepth) {
        Board save2 = new Board();

        movesGenerate.clear();
        movesSelected.clear();

        double tempScore = 0.0;
        double score1 = -1000.0;
        double score2 = -1000.0;
        double score3 = -1000.0;
        double score4 = 1000.0;
        double score5 = 1000.0;
        double score6 = 1000.0;

        int a = 0;
        int b = 1;
        int c = 2;
        int d = 3;
        int e = 4;
        int f = 5;

        switch (movesDepth) {
            case 1:
                movesGenerate.addAll(movesDepth1);
                break;
            case 2:
                movesGenerate.addAll(movesDepth2);
                break;
            case 3:
                movesGenerate.addAll(movesDepth3);
                break;
            case 4:
                movesGenerate.addAll(movesDepth4);
                break;
            case 5:
                movesGenerate.addAll(movesDepth5);
                break;
            case 6:
                movesGenerate.addAll(movesDepth6);
                break;
            case 7:
                movesGenerate.addAll(movesDepth7);
                break;
            case 8:
                movesGenerate.addAll(movesDepth8);
                break;
            case 9:
                movesGenerate.addAll(movesDepth9);
                break;
            case 10:
                movesGenerate.addAll(movesDepth10);
                break;
            default:
                break;
        }

        for (int i = 0; i < movesGenerate.size(); i++) {
            this.makeMove(color, movesGenerate.get(i));

            tempScore = this.value(color);

            if (tempScore >= score1) {
                score1 = tempScore;
                a = i;
            }

            if (tempScore < score1 && tempScore >= score2) {
                score2 = tempScore;
                b = i;
            }

          /*  if(tempScore < score1 && tempScore < score2 && tempScore >= score3)
            {score3 = tempScore; c=i;}

            if(tempScore <= score4)
            {score4 = tempScore; d=i;}

            if(tempScore > score4 && tempScore <= score5)
            {score5 = tempScore; e=i;}

            if(tempScore > score4 && tempScore > score5 && tempScore <= score6)
            {score6 = tempScore; f=i;}
            */

            this.copyBoard(save2);
        }

        movesSelected.add(movesGenerate.get(a));
        movesSelected.add(movesGenerate.get(b));
      /*  movesSelected.add(movesGenerate.get(c));
        movesSelected.add(movesGenerate.get(d));
        movesSelected.add(movesGenerate.get(e));
        movesSelected.add(movesGenerate.get(f));
        */

        switch (movesDepth) {
            case 1:
                movesDepth1.clear();
                movesDepth1.addAll(movesSelected);
                break;
            case 2:
                movesDepth2.clear();
                movesDepth2.addAll(movesSelected);
                break;
            case 3:
                movesDepth3.clear();
                movesDepth3.addAll(movesSelected);
                break;
            case 4:
                movesDepth4.clear();
                movesDepth4.addAll(movesSelected);
                break;
            case 5:
                movesDepth5.clear();
                movesDepth5.addAll(movesSelected);
                break;
            case 6:
                movesDepth6.clear();
                movesDepth6.addAll(movesSelected);
                break;
            case 7:
                movesDepth7.clear();
                movesDepth7.addAll(movesSelected);
                break;
            case 8:
                movesDepth8.clear();
                movesDepth8.addAll(movesSelected);
                break;
            case 9:
                movesDepth9.clear();
                movesDepth9.addAll(movesSelected);
                break;
            case 10:
                movesDepth10.clear();
                movesDepth10.addAll(movesSelected);
                break;
            default:
                break;
        }

    }

    public void createPositionsArray() {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                position[i][j] = 0;
            }
        }

        for (int i = 0; i < 19; i++) {
            if (whitePieces[i].isAlive()) {
                position[whitePieces[i].getPosX()][whitePieces[i].getPosY()] = whitePieces[i].getCODE();
            }
            if (blackPieces[i].isAlive()) {
                position[blackPieces[i].getPosX()][blackPieces[i].getPosY()] = (blackPieces[i].getCODE() + 10);
            }
        }

    }

    public void showMoves(int depth) {
        if (depth == 1) {
            System.out.println("movesDepth1 (" + movesDepth1.size() + ") :");
            for (int i = 0; i < movesDepth1.size(); i++) {
                System.out.print(i + 1);
                movesDepth1.get(i).introduce();
                System.out.println("");
            }
        }
        if (depth == 2) {
            System.out.println("movesDepth2 (" + movesDepth2.size() + ") :");
            for (int i = 0; i < movesDepth2.size(); i++) {
                System.out.print(i + 1);
                movesDepth2.get(i).introduce();
                System.out.println("");
            }
        }

    }

    public void setLastMove(Move move) {
        this.lastMove = move;
    }

    public Move getLastMove() {
        return lastMove;
    }

    public void changeWhitePiece(int index, boolean alive, int X, int Y) {
        this.whitePieces[index].change(alive, X, Y);
    }

    public void changeBlackPiece(int index, boolean alive, int X, int Y) {
        this.blackPieces[index].change(alive, X, Y);
    }

    public void copyBoard(Board board) {
        for (int i = 0; i < 19; i++) {
            this.whitePieces[i].change(board.getWhitePiece(i).isAlive(), board.getWhitePiece(i).getPosX(), board.getWhitePiece(i).getPosY());
            this.blackPieces[i].change(board.getBlackPiece(i).isAlive(), board.getBlackPiece(i).getPosX(), board.getBlackPiece(i).getPosY());
        }
    }

}
