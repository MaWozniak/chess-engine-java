import java.util.ArrayList;

public class Move
        //maximum siplycity
{
    private int pieceIndex = 0;
    private int pos1_X = 0;
    private int pos1_Y = 0;
    private int pos2_X = 0;
    private int pos2_Y = 0;
    private boolean capture = false;
    private int specialMove = 0;
    private boolean checkmate = false;

    //algorithm
    public double worthDepth4 = 0.0;
    public double bestBeta4 = 0.0;
    public double avrgBeta4 = 0.0;

    public double worthDepth8 = 0.0;
    public double bestBeta8 = 0.0;

    //sequence
    public ArrayList<Move> sequence = new ArrayList<>(); //depth 1-4

    public Move(int piece, int X1, int Y1, int X2, int Y2, boolean takePiece) {
        this.pieceIndex = piece;
        this.pos1_X = X1;
        this.pos1_Y = Y1;
        this.pos2_X = X2;
        this.pos2_Y = Y2;
        this.capture = takePiece;
        this.checkmate = false;
    }

    public Move(int piece, int X1, int Y1, int X2, int Y2, boolean takePiece, int specialMove) {
        this.pieceIndex = piece;
        this.pos1_X = X1;
        this.pos1_Y = Y1;
        this.pos2_X = X2;
        this.pos2_Y = Y2;
        this.capture = takePiece;
        this.specialMove = specialMove;
        this.checkmate = false;
    }

    public Move() {
    }

    public int getPieceIndex() {
        return pieceIndex;
    }

    public int getPos1_X() {
        return this.pos1_X;
    }

    public int getPos1_Y() {
        return this.pos1_Y;
    }

    public int getPos2_X() {
        return this.pos2_X;
    }

    public int getPos2_Y() {
        return this.pos2_Y;
    }

    public boolean getCapture() {
        return this.capture;
    }

    public int getSpecialMove() {
        return this.specialMove;
    }

    public void introduce() {
        System.out.print(" p-" + (this.pieceIndex + 1) + "  " + (char) (this.pos1_X + 96) + this.pos1_Y + " - " + (char) (this.pos2_X + 96) + this.pos2_Y + "  " + this.capture);
    }

    public void introduceShort() {
        System.out.print("(" + (char) (this.pos1_X + 96) + this.pos1_Y + "-" + (char) (this.pos2_X + 96) + this.pos2_Y + ")");
    }

    public void showSequence() {
        for (int i = 0; i < this.sequence.size(); i++) {
            this.sequence.get(i).introduceShort();
        }
    }

    public boolean getCheckmate() {
        return checkmate;
    }

    public void setCheckmate() {
        this.checkmate = true;
    }

    public String pieceInitial() {
        String initial = "";
        if (this.pieceIndex == 8 || this.pieceIndex == 15) {
            initial = initial + "R";
        }
        if (this.pieceIndex == 9 || this.pieceIndex == 14) {
            initial = initial + "N";
        }
        if (this.pieceIndex == 10 || this.pieceIndex == 13) {
            initial = initial + "B";
        }
        if (this.pieceIndex == 11 || this.pieceIndex == 16 || this.pieceIndex == 17 || this.pieceIndex == 18) {
            initial = initial + "Q";
        }
        if (this.pieceIndex == 12) {
            initial = initial + "K";
        }
        return initial;
    }

    public boolean equals(Move move) {
        boolean result = false;
        if((this.pos1_X == move.pos1_X)&&(this.pos2_X == move.pos2_X) &&(this.pos1_Y == move.pos1_Y)
                &&(this.pos2_Y == move.pos2_Y)&&(this.pieceIndex == move.pieceIndex)) {
            result = true;
        }
        return result;
    }

    public boolean mirrorEquals(Move move) {
        boolean result = false;
        if((this.pos1_X == move.pos2_X)&&(this.pos2_X == move.pos1_X) &&(this.pos1_Y == move.pos2_Y)
                &&(this.pos2_Y == move.pos1_Y)&&(this.pieceIndex == move.pieceIndex)) {
            result = true;
        }
        return result;
    }


}
