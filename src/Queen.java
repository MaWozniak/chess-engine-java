import java.util.ArrayList;

public class Queen extends Piece {
    protected int CODE = 3;

    public Queen(boolean live, char side, int X, int Y) {
        this.alive = live;
        this.color = side;
        this.posX = X;
        this.posY = Y;
    }

    public int getCODE() {
        return CODE;
    }

    public double getScore() {
        double value = 0.0;

        if (this.alive) {

            value += 9.0;
        }
        return value;
    }

    public ArrayList<Move> generateMoves(int[][] position, int numOfPiece, Move move) {
        this.movesGenerate.clear();

        if (this.isAlive()) {
            if (this.color == 'W') {

                for (int i = 1; i < 8; i++) //move right direction
                {
                    if (!(this.isInBounds(this.getPosX() + i, this.getPosY()) &&
                            ((position[this.getPosX() + i][this.getPosY()] == 0) || (position[this.getPosX() + i][this.getPosY()] > 10)))) {
                        break;
                    }

                    if ((this.isInBounds(this.getPosX() + i, this.getPosY())) &&
                            (position[this.getPosX() + i][this.getPosY()] == 0)) {
                        Move newMove = new Move(numOfPiece, this.getPosX(), this.getPosY(), this.getPosX() + i, this.getPosY(), false);
                        movesGenerate.add(newMove);
                    }

                    if ((this.isInBounds(this.getPosX() + i, this.getPosY())) &&
                            (position[this.getPosX() + i][this.getPosY()] > 10)) {
                        Move newMove = new Move(numOfPiece, this.getPosX(), this.getPosY(), this.getPosX() + i, this.getPosY(), true);
                        movesGenerate.add(newMove);

                        break;
                    }
                }

                for (int i = -1; i > -8; i--) //move left direction
                {
                    if (!(this.isInBounds(this.getPosX() + i, this.getPosY()) &&
                            ((position[this.getPosX() + i][this.getPosY()] == 0) || (position[this.getPosX() + i][this.getPosY()] > 10)))) {
                        break;
                    }

                    if ((this.isInBounds(this.getPosX() + i, this.getPosY())) &&
                            (position[this.getPosX() + i][this.getPosY()] == 0)) {
                        Move newMove = new Move(numOfPiece, this.getPosX(), this.getPosY(), this.getPosX() + i, this.getPosY(), false);
                        movesGenerate.add(newMove);
                    }

                    if ((this.isInBounds(this.getPosX() + i, this.getPosY())) &&
                            (position[this.getPosX() + i][this.getPosY()] > 10)) {
                        Move newMove = new Move(numOfPiece, this.getPosX(), this.getPosY(), this.getPosX() + i, this.getPosY(), true);
                        movesGenerate.add(newMove);

                        break;
                    }
                }

                for (int i = 1; i < 8; i++) //move up direction
                {
                    if (!(this.isInBounds(this.getPosX(), this.getPosY() + i) &&
                            ((position[this.getPosX()][this.getPosY() + i] == 0) || (position[this.getPosX()][this.getPosY() + i] > 10)))) {
                        break;
                    }

                    if ((this.isInBounds(this.getPosX(), this.getPosY() + i)) &&
                            (position[this.getPosX()][this.getPosY() + i] == 0)) {
                        Move newMove = new Move(numOfPiece, this.getPosX(), this.getPosY(), this.getPosX(), this.getPosY() + i, false);
                        movesGenerate.add(newMove);
                    }

                    if ((this.isInBounds(this.getPosX(), this.getPosY() + i)) &&
                            (position[this.getPosX()][this.getPosY() + i] > 10)) {
                        Move newMove = new Move(numOfPiece, this.getPosX(), this.getPosY(), this.getPosX(), this.getPosY() + i, true);
                        movesGenerate.add(newMove);

                        break;
                    }
                }

                for (int i = -1; i > -8; i--) //move down direction
                {
                    if (!(this.isInBounds(this.getPosX(), this.getPosY() + i) &&
                            ((position[this.getPosX()][this.getPosY() + i] == 0) || (position[this.getPosX()][this.getPosY() + i] > 10)))) {
                        break;
                    }

                    if ((this.isInBounds(this.getPosX(), this.getPosY() + i)) &&
                            (position[this.getPosX()][this.getPosY() + i] == 0)) {
                        Move newMove = new Move(numOfPiece, this.getPosX(), this.getPosY(), this.getPosX(), this.getPosY() + i, false);
                        movesGenerate.add(newMove);
                    }

                    if ((this.isInBounds(this.getPosX(), this.getPosY() + i)) &&
                            (position[this.getPosX()][this.getPosY() + i] > 10)) {
                        Move newMove = new Move(numOfPiece, this.getPosX(), this.getPosY(), this.getPosX(), this.getPosY() + i, true);
                        movesGenerate.add(newMove);

                        break;
                    }
                }

                for (int i = 1; i < 8; i++) //move right-up direction
                {
                    if (!(this.isInBounds(this.getPosX() + i, this.getPosY() + i) &&
                            ((position[this.getPosX() + i][this.getPosY() + i] == 0) || (position[this.getPosX() + i][this.getPosY() + i] > 10)))) {
                        break;
                    }

                    if ((this.isInBounds(this.getPosX() + i, this.getPosY() + i)) &&
                            (position[this.getPosX() + i][this.getPosY() + i] == 0)) {
                        Move newMove = new Move(numOfPiece, this.getPosX(), this.getPosY(), this.getPosX() + i, this.getPosY() + i, false);
                        movesGenerate.add(newMove);
                    }

                    if ((this.isInBounds(this.getPosX() + i, this.getPosY() + i)) &&
                            (position[this.getPosX() + i][this.getPosY() + i] > 10)) {
                        Move newMove = new Move(numOfPiece, this.getPosX(), this.getPosY(), this.getPosX() + i, this.getPosY() + i, true);
                        movesGenerate.add(newMove);

                        break;
                    }
                }

                for (int i = -1; i > -8; i--) //move left-down direction
                {
                    if (!(this.isInBounds(this.getPosX() + i, this.getPosY() + i) &&
                            ((position[this.getPosX() + i][this.getPosY() + i] == 0) || (position[this.getPosX() + i][this.getPosY() + i] > 10)))) {
                        break;
                    }

                    if ((this.isInBounds(this.getPosX() + i, this.getPosY() + i)) &&
                            (position[this.getPosX() + i][this.getPosY() + i] == 0)) {
                        Move newMove = new Move(numOfPiece, this.getPosX(), this.getPosY(), this.getPosX() + i, this.getPosY() + i, false);
                        movesGenerate.add(newMove);
                    }

                    if ((this.isInBounds(this.getPosX() + i, this.getPosY() + i)) &&
                            (position[this.getPosX() + i][this.getPosY() + i] > 10)) {
                        Move newMove = new Move(numOfPiece, this.getPosX(), this.getPosY(), this.getPosX() + i, this.getPosY() + i, true);
                        movesGenerate.add(newMove);

                        break;
                    }
                }

                for (int i = 1; i < 8; i++) //move left-up direction
                {
                    if (!(this.isInBounds(this.getPosX() - i, this.getPosY() + i) &&
                            ((position[this.getPosX() - i][this.getPosY() + i] == 0) || (position[this.getPosX() - i][this.getPosY() + i] > 10)))) {
                        break;
                    }

                    if ((this.isInBounds(this.getPosX() - i, this.getPosY() + i)) &&
                            (position[this.getPosX() - i][this.getPosY() + i] == 0)) {
                        Move newMove = new Move(numOfPiece, this.getPosX(), this.getPosY(), this.getPosX() - i, this.getPosY() + i, false);
                        movesGenerate.add(newMove);
                    }

                    if ((this.isInBounds(this.getPosX() - i, this.getPosY() + i)) &&
                            (position[this.getPosX() - i][this.getPosY() + i] > 10)) {
                        Move newMove = new Move(numOfPiece, this.getPosX(), this.getPosY(), this.getPosX() - i, this.getPosY() + i, true);
                        movesGenerate.add(newMove);

                        break;
                    }
                }

                for (int i = -1; i > -8; i--) //move right-down direction
                {
                    if (!(this.isInBounds(this.getPosX() - i, this.getPosY() + i) &&
                            ((position[this.getPosX() - i][this.getPosY() + i] == 0) || (position[this.getPosX() - i][this.getPosY() + i] > 10)))) {
                        break;
                    }

                    if ((this.isInBounds(this.getPosX() - i, this.getPosY() + i)) &&
                            (position[this.getPosX() - i][this.getPosY() + i] == 0)) {
                        Move newMove = new Move(numOfPiece, this.getPosX(), this.getPosY(), this.getPosX() - i, this.getPosY() + i, false);
                        movesGenerate.add(newMove);
                    }

                    if ((this.isInBounds(this.getPosX() - i, this.getPosY() + i)) &&
                            (position[this.getPosX() - i][this.getPosY() + i] > 10)) {
                        Move newMove = new Move(numOfPiece, this.getPosX(), this.getPosY(), this.getPosX() - i, this.getPosY() + i, true);
                        movesGenerate.add(newMove);

                        break;
                    }
                }
            }

            if (this.color == 'B') {
                //change values from >10 to <10 && >0

                for (int i = 1; i < 8; i++) //move right direction
                {
                    if (!(this.isInBounds(this.getPosX() + i, this.getPosY()) &&
                            ((position[this.getPosX() + i][this.getPosY()] == 0) || ((position[this.getPosX() + i][this.getPosY()] < 10)
                                    && (position[this.getPosX() + i][this.getPosY()] > 0))))) {
                        break;
                    }

                    if ((this.isInBounds(this.getPosX() + i, this.getPosY())) &&
                            (position[this.getPosX() + i][this.getPosY()] == 0)) {
                        Move newMove = new Move(numOfPiece, this.getPosX(), this.getPosY(), this.getPosX() + i, this.getPosY(), false);
                        movesGenerate.add(newMove);
                    }

                    if ((this.isInBounds(this.getPosX() + i, this.getPosY())) &&
                            (position[this.getPosX() + i][this.getPosY()] < 10) && (position[this.getPosX() + i][this.getPosY()] > 0)) {
                        Move newMove = new Move(numOfPiece, this.getPosX(), this.getPosY(), this.getPosX() + i, this.getPosY(), true);
                        movesGenerate.add(newMove);

                        break;
                    }
                }

                for (int i = -1; i > -8; i--) //move left direction
                {
                    if (!(this.isInBounds(this.getPosX() + i, this.getPosY()) &&
                            ((position[this.getPosX() + i][this.getPosY()] == 0) || ((position[this.getPosX() + i][this.getPosY()] < 10)
                                    && (position[this.getPosX() + i][this.getPosY()] > 0))))) {
                        break;
                    }

                    if ((this.isInBounds(this.getPosX() + i, this.getPosY())) &&
                            (position[this.getPosX() + i][this.getPosY()] == 0)) {
                        Move newMove = new Move(numOfPiece, this.getPosX(), this.getPosY(), this.getPosX() + i, this.getPosY(), false);
                        movesGenerate.add(newMove);
                    }

                    if ((this.isInBounds(this.getPosX() + i, this.getPosY())) && (position[this.getPosX() + i][this.getPosY()] < 10)
                            && (position[this.getPosX() + i][this.getPosY()] > 0)) {
                        Move newMove = new Move(numOfPiece, this.getPosX(), this.getPosY(), this.getPosX() + i, this.getPosY(), true);
                        movesGenerate.add(newMove);

                        break;
                    }
                }

                for (int i = 1; i < 8; i++) //move up direction
                {
                    if (!(this.isInBounds(this.getPosX(), this.getPosY() + i) &&
                            ((position[this.getPosX()][this.getPosY() + i] == 0) || ((position[this.getPosX()][this.getPosY() + i] < 10)
                                    && (position[this.getPosX()][this.getPosY() + i] > 0))))) {
                        break;
                    }

                    if ((this.isInBounds(this.getPosX(), this.getPosY() + i)) &&
                            (position[this.getPosX()][this.getPosY() + i] == 0)) {
                        Move newMove = new Move(numOfPiece, this.getPosX(), this.getPosY(), this.getPosX(), this.getPosY() + i, false);
                        movesGenerate.add(newMove);
                    }

                    if ((this.isInBounds(this.getPosX(), this.getPosY() + i)) && (position[this.getPosX()][this.getPosY() + i] < 10)
                            && (position[this.getPosX()][this.getPosY() + i] > 0)) {
                        Move newMove = new Move(numOfPiece, this.getPosX(), this.getPosY(), this.getPosX(), this.getPosY() + i, true);
                        movesGenerate.add(newMove);

                        break;
                    }
                }

                for (int i = -1; i > -8; i--) //move down direction
                {
                    if (!(this.isInBounds(this.getPosX(), this.getPosY() + i) &&
                            ((position[this.getPosX()][this.getPosY() + i] == 0) || ((position[this.getPosX()][this.getPosY() + i] < 10)
                                    && (position[this.getPosX()][this.getPosY() + i] > 0))))) {
                        break;
                    }

                    if ((this.isInBounds(this.getPosX(), this.getPosY() + i)) &&
                            (position[this.getPosX()][this.getPosY() + i] == 0)) {
                        Move newMove = new Move(numOfPiece, this.getPosX(), this.getPosY(), this.getPosX(), this.getPosY() + i, false);
                        movesGenerate.add(newMove);
                    }

                    if ((this.isInBounds(this.getPosX(), this.getPosY() + i)) && (position[this.getPosX()][this.getPosY() + i] < 10)
                            && (position[this.getPosX()][this.getPosY() + i] > 0)) {
                        Move newMove = new Move(numOfPiece, this.getPosX(), this.getPosY(), this.getPosX(), this.getPosY() + i, true);
                        movesGenerate.add(newMove);

                        break;
                    }
                }

                for (int i = 1; i < 8; i++) //move right-up direction
                {
                    if (!(this.isInBounds(this.getPosX() + i, this.getPosY() + i) &&
                            ((position[this.getPosX() + i][this.getPosY() + i] == 0) || (position[this.getPosX() + i][this.getPosY() + i] < 10)
                                    && (position[this.getPosX() + i][this.getPosY() + i] > 0)))) {
                        break;
                    }

                    if ((this.isInBounds(this.getPosX() + i, this.getPosY() + i)) &&
                            (position[this.getPosX() + i][this.getPosY() + i] == 0)) {
                        Move newMove = new Move(numOfPiece, this.getPosX(), this.getPosY(), this.getPosX() + i, this.getPosY() + i, false);
                        movesGenerate.add(newMove);
                    }

                    if ((this.isInBounds(this.getPosX() + i, this.getPosY() + i)) &&
                            (position[this.getPosX() + i][this.getPosY() + i] < 10) && (position[this.getPosX() + i][this.getPosY() + i] > 0)) {
                        Move newMove = new Move(numOfPiece, this.getPosX(), this.getPosY(), this.getPosX() + i, this.getPosY() + i, true);
                        movesGenerate.add(newMove);

                        break;
                    }
                }

                for (int i = -1; i > -8; i--) //move left-down direction
                {
                    if (!(this.isInBounds(this.getPosX() + i, this.getPosY() + i) &&
                            ((position[this.getPosX() + i][this.getPosY() + i] == 0) || (position[this.getPosX() + i][this.getPosY() + i] < 10)
                                    && (position[this.getPosX() + i][this.getPosY() + i] > 0)))) {
                        break;
                    }

                    if ((this.isInBounds(this.getPosX() + i, this.getPosY() + i)) &&
                            (position[this.getPosX() + i][this.getPosY() + i] == 0)) {
                        Move newMove = new Move(numOfPiece, this.getPosX(), this.getPosY(), this.getPosX() + i, this.getPosY() + i, false);
                        movesGenerate.add(newMove);
                    }

                    if ((this.isInBounds(this.getPosX() + i, this.getPosY() + i)) &&
                            (position[this.getPosX() + i][this.getPosY() + i] < 10) && (position[this.getPosX() + i][this.getPosY() + i] > 0)) {
                        Move newMove = new Move(numOfPiece, this.getPosX(), this.getPosY(), this.getPosX() + i, this.getPosY() + i, true);
                        movesGenerate.add(newMove);

                        break;
                    }
                }

                for (int i = 1; i < 8; i++) //move left-up direction
                {
                    if (!(this.isInBounds(this.getPosX() - i, this.getPosY() + i) &&
                            ((position[this.getPosX() - i][this.getPosY() + i] == 0) || (position[this.getPosX() - i][this.getPosY() + i] < 10)
                                    && (position[this.getPosX() - i][this.getPosY() + i] > 0)))) {
                        break;
                    }

                    if ((this.isInBounds(this.getPosX() - i, this.getPosY() + i)) &&
                            (position[this.getPosX() - i][this.getPosY() + i] == 0)) {
                        Move newMove = new Move(numOfPiece, this.getPosX(), this.getPosY(), this.getPosX() - i, this.getPosY() + i, false);
                        movesGenerate.add(newMove);
                    }

                    if ((this.isInBounds(this.getPosX() - i, this.getPosY() + i)) &&
                            (position[this.getPosX() - i][this.getPosY() + i] < 10) && (position[this.getPosX() - i][this.getPosY() + i] > 0)) {
                        Move newMove = new Move(numOfPiece, this.getPosX(), this.getPosY(), this.getPosX() - i, this.getPosY() + i, true);
                        movesGenerate.add(newMove);

                        break;
                    }
                }

                for (int i = -1; i > -8; i--) //move right-down direction
                {
                    if (!(this.isInBounds(this.getPosX() - i, this.getPosY() + i) &&
                            ((position[this.getPosX() - i][this.getPosY() + i] == 0) || (position[this.getPosX() - i][this.getPosY() + i] < 10)
                                    && (position[this.getPosX() - i][this.getPosY() + i] > 0)))) {
                        break;
                    }

                    if ((this.isInBounds(this.getPosX() - i, this.getPosY() + i)) &&
                            (position[this.getPosX() - i][this.getPosY() + i] == 0)) {
                        Move newMove = new Move(numOfPiece, this.getPosX(), this.getPosY(), this.getPosX() - i, this.getPosY() + i, false);
                        movesGenerate.add(newMove);
                    }

                    if ((this.isInBounds(this.getPosX() - i, this.getPosY() + i)) &&
                            (position[this.getPosX() - i][this.getPosY() + i] < 10) && (position[this.getPosX() - i][this.getPosY() + i] > 0)) {
                        Move newMove = new Move(numOfPiece, this.getPosX(), this.getPosY(), this.getPosX() - i, this.getPosY() + i, true);
                        movesGenerate.add(newMove);

                        break;
                    }
                }
            }

        }

        return movesGenerate;
    }

}
