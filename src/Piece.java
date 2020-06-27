import java.util.ArrayList;

public class Piece {
    protected int posX = 0;
    protected int posY = 0;
    protected boolean alive = true;
    protected char color = 'U'; //unassigned
    protected int CODE = 1;
    protected ArrayList<Move> movesGenerate = new ArrayList<Move>();

    public Piece(boolean live, char side, int X, int Y) {
        this.alive = live;
        this.color = side;
        this.posX = X;
        this.posY = Y;
    }

    public Piece() {
    }

    public int getCODE() {
        return CODE;
    }

    public int getPosX() {
        return posX;
    }

    public int getPosY() {
        return posY;
    }

    public void change(boolean live, int X, int Y) {
        this.alive = live;
        this.posX = X;
        this.posY = Y;
    }

    public boolean isAlive() {
        return alive;
    }

    public void Death() {
        this.alive = false;
    }

    public void Promote() {
        this.alive = true;
    }

    public void changePos(int X, int Y) {
        this.posX = X;
        this.posY = Y;
    }

    public boolean isInBounds(int X, int Y) {
        return (X >= 1 && X < 9 && Y >= 1 && Y < 9);
    }

    public ArrayList<Move> generateMoves(int[][] position, int numOfPiece, Move lastMove) {
        this.movesGenerate.clear();

        if (this.color == 'W') {

            if (this.isAlive()) {
                if ((this.isInBounds(this.getPosX(), this.getPosY() + 1)) && //eliminate OutOfBounds error
                        (position[this.getPosX()][this.getPosY() + 1] == 0)) //posY+1
                {
                    if (this.getPosY() == 7) {

                        //PROMOTION:
                        Move newMove = new Move(numOfPiece, this.getPosX(), 7, this.getPosX(), 8, false, 5);
                        movesGenerate.add(newMove);

                    } else {

                        Move newMove = new Move(numOfPiece, this.getPosX(), this.getPosY(), this.getPosX(), this.getPosY() + 1, false);
                        movesGenerate.add(newMove);
                    }
                }

                if ((this.isInBounds(this.getPosX(), this.getPosY() + 2)) &&
                        (position[this.getPosX()][this.getPosY() + 1] == 0) &&
                        (position[this.getPosX()][this.getPosY() + 2] == 0) && (this.getPosY() == 2)) //posY+2
                {
                    Move newMove = new Move(numOfPiece, this.getPosX(), this.getPosY(), this.getPosX(), this.getPosY() + 2, false);
                    movesGenerate.add(newMove);
                }
                if ((this.isInBounds(this.getPosX() - 1, this.getPosY() + 1)) &&
                        (position[this.getPosX() - 1][this.getPosY() + 1] > 9)) //capture left
                {
                    Move newMove = new Move(numOfPiece, this.getPosX(), this.getPosY(), this.getPosX() - 1, this.getPosY() + 1, true);
                    movesGenerate.add(newMove);
                }
                if ((this.isInBounds(this.getPosX() + 1, this.getPosY() + 1)) &&
                        (position[this.getPosX() + 1][this.getPosY() + 1] > 9)) //capture right
                {
                    Move newMove = new Move(numOfPiece, this.getPosX(), this.getPosY(), this.getPosX() + 1, this.getPosY() + 1, true);
                    movesGenerate.add(newMove);
                }

                //EN PASSANT
                if (lastMove.getPos1_Y() == 7 && lastMove.getPos2_Y() == 5 && lastMove.getPieceIndex() < 8 && this.getPosY() == 5 && (this.getPosX() + 1) == lastMove.getPos2_X()) {
                    Move newMove = new Move(numOfPiece, this.getPosX(), this.getPosY(), this.getPosX() + 1, this.getPosY() + 1, true, 7);
                    movesGenerate.add(newMove);
                }
                if (lastMove.getPos1_Y() == 7 && lastMove.getPos2_Y() == 5 && lastMove.getPieceIndex() < 8 && this.getPosY() == 5 && (this.getPosX() - 1) == lastMove.getPos2_X()) {
                    Move newMove = new Move(numOfPiece, this.getPosX(), this.getPosY(), this.getPosX() - 1, this.getPosY() + 1, true, 7);
                    movesGenerate.add(newMove);
                }
            }
        }

        if (this.color == 'B') {

            if (this.isAlive()) {
                if ((this.isInBounds(this.getPosX(), this.getPosY() - 1)) && //eliminate OutOfBounds error
                        (position[this.getPosX()][this.getPosY() - 1] == 0)) //posY-1
                {
                    //PROMOTION:
                    if (this.getPosY() == 2) {

                        Move newMove = new Move(numOfPiece, this.getPosX(), 2, this.getPosX(), 1, false, 6);
                        movesGenerate.add(newMove);

                    } else {

                        Move newMove = new Move(numOfPiece, this.getPosX(), this.getPosY(), this.getPosX(), this.getPosY() - 1, false);
                        movesGenerate.add(newMove);
                    }
                }

                if ((this.isInBounds(this.getPosX(), this.getPosY() - 2) &&
                        (position[this.getPosX()][this.getPosY() - 1] == 0) &&
                        (position[this.getPosX()][this.getPosY() - 2] == 0) && (this.getPosY() == 7))) //posY-2
                {
                    Move newMove = new Move(numOfPiece, this.getPosX(), this.getPosY(), this.getPosX(), this.getPosY() - 2, false);
                    movesGenerate.add(newMove);
                }
                if ((this.isInBounds(this.getPosX() - 1, this.getPosY() - 1)) &&
                        (position[this.getPosX() - 1][this.getPosY() - 1] < 10) &&
                        (position[this.getPosX() - 1][this.getPosY() - 1] > 0)) //capture left
                {
                    Move newMove = new Move(numOfPiece, this.getPosX(), this.getPosY(), this.getPosX() - 1, this.getPosY() - 1, true);
                    movesGenerate.add(newMove);
                }
                if ((this.isInBounds(this.getPosX() + 1, this.getPosY() - 1)) &&
                        (position[this.getPosX() + 1][this.getPosY() - 1] < 10) &&
                        (position[this.getPosX() + 1][this.getPosY() - 1] > 0)) //capture right
                {
                    Move newMove = new Move(numOfPiece, this.getPosX(), this.getPosY(), this.getPosX() + 1, this.getPosY() - 1, true);
                    movesGenerate.add(newMove);
                }

                //EN PASSANT
                if (lastMove.getPos1_Y() == 2 && lastMove.getPos2_Y() == 4 && lastMove.getPieceIndex() < 8 && this.getPosY() == 4 && (this.getPosX() + 1) == lastMove.getPos2_X()) {
                    Move newMove = new Move(numOfPiece, this.getPosX(), this.getPosY(), this.getPosX() + 1, this.getPosY() - 1, true, 8);
                    movesGenerate.add(newMove);
                }
                if (lastMove.getPos1_Y() == 2 && lastMove.getPos2_Y() == 4 && lastMove.getPieceIndex() < 8 && this.getPosY() == 4 && (this.getPosX() - 1) == lastMove.getPos2_X()) {
                    Move newMove = new Move(numOfPiece, this.getPosX(), this.getPosY(), this.getPosX() - 1, this.getPosY() - 1, true, 8);
                    movesGenerate.add(newMove);
                }

            }

        }

        return movesGenerate;
    }

    public int numberOfMoves(int[][] position, int numOfPiece, Move lastMove) {
        ArrayList<Move> movesGenerate = this.generateMoves(position, numOfPiece, lastMove);
        return movesGenerate.size();

    }

    public double getScore() {
        double value = 0.0;

        if (this.alive) {

            //Pawn value = 1.0
            value += 1.0;

//WIP: comment out simply positional values

//            //Whites score:
//            if (this.color == 'W') {
//                //Position - center
//                if ((this.posX > 2 && this.posX < 7) && ((this.posY == 3) || (this.posY == 4))) {
//                    value += 0.001;
//                }
//                //Position - strict center
//                if ((this.posX == 4 || this.posX == 5) && ((this.posY == 4) || (this.posY == 5))) {
//                    value += 0.002;
//                }
//                //Position - moving foward
//                value += ((this.posY - 2.0) / 1000.0);
//                //Position - close to last line (2 lines)
//                if (this.posY == 6) {
//                    value += 0.01;
//                }
//                //Position - close to last line (1 line)
//                if (this.posY == 7) {
//                    value += 0.2;
//                }
//                //Position - last line -> change to Figure
//                if (this.posY == 8) {
//                    value += 7.0;
//                }
//                //+-Position - empty line ahead (witout opposite pawn)
//                //+-Defence - cover by other pawn
//            }
//
//            //Blacks score:
//            if (this.color == 'B') {
//                //Position - center
//                if ((this.posX > 2 && this.posX < 7) && ((this.posY == 6) || (this.posY == 5))) {
//                    value += 0.001;
//                }
//                //Position - strict center
//                if ((this.posX == 4 || this.posX == 5) && ((this.posY == 4) || (this.posY == 5))) {
//                    value += 0.002;
//                }
//                //Position - moving foward
//                value += ((7.0 - this.posY) / 1000.0);
//                //Position - close to last line (2 lines)
//                if (this.posY == 3) {
//                    value += 0.01;
//                }
//                //Position - close to last line (1 line)
//                if (this.posY == 2) {
//                    value += 0.2;
//                }
//                //Position - last line -> change to Figure
//                if (this.posY == 1) {
//                    value += 7.0;
//                }
//                //+-Position - empty line ahead (witout opposite pawn)
//                //+-Defence - cover by other pawn
//            }

            /*
            //Whites score:
            if (this.color == 'W') {
                //Position - center
                if ((this.posX > 2 && this.posX < 7) && ((this.posY == 3) || (this.posY == 4)))
                { value += 0.1; }
                //Position - strict center
                if ((this.posX == 4 || this.posX == 5) && ((this.posY == 4) || (this.posY == 5)))
                { value += 0.2; }
                //Position - moving foward
                value += ((this.posY-2.0)/20.0);
                //Position - close to last line (2 lines)
                if (this.posY == 6) { value += 0.5; }
                //Position - close to last line (1 line)
                if (this.posY == 7) { value += 1.0; }
                //Position - last line -> change to Figure
                if (this.posY == 8) { value += 9.0; }
                //+-Position - empty line ahead (witout opposite pawn)
                //+-Defence - cover by other pawn
            }

            //Blacks score:
            if (this.color == 'B') {
                //Position - center
                if ((this.posX > 2 && this.posX < 7) && ((this.posY == 6) || (this.posY == 5)))
                { value += 0.1; }
                //Position - strict center
                if ((this.posX == 4 || this.posX == 5) && ((this.posY == 4) || (this.posY == 5)))
                { value += 0.2; }
                //Position - moving foward
                value += ((7.0-this.posY)/20.0);
                //Position - close to last line (2 lines)
                if (this.posY == 3) { value += 0.5; }
                //Position - close to last line (1 line)
                if (this.posY == 2) { value += 1.0; }
                //Position - last line -> change to Figure
                if (this.posY == 1) { value += 9.0; }
                //+-Position - empty line ahead (witout opposite pawn)
                //+-Defence - cover by other pawn
            }*/


        }

        return value;
    }

}
