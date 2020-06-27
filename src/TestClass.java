import java.util.ArrayList;

public class TestClass extends Piece {
    protected int CODE = 2;

    public TestClass(boolean live, char side, int X, int Y) {
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

            value += 100.0;
        }
        return value;
    }

    public ArrayList<Move> generateMoves(int[][] position, int numOfPiece, Move move) {
        this.movesGenerate.clear();

        if (this.isAlive()) {
            if (this.color == 'W') {

                for (int i = -1; i < 2; i++) {
                    for (int j = -1; j < 2; j++) {
                        if ((this.isInBounds(this.getPosX() + i, this.getPosY() + j)) &&
                                (position[this.getPosX() + i][this.getPosY() + j] == 0) && !(i == 0 && j == 0)) {
                            Move newMove = new Move(numOfPiece, this.getPosX(), this.getPosY(), this.getPosX() + i, this.getPosY() + j, false);
                            movesGenerate.add(newMove);
                        }

                        if ((this.isInBounds(this.getPosX() + i, this.getPosY() + j)) &&
                                (position[this.getPosX() + i][this.getPosY() + j] > 9) && !(i == 0 && j == 0)) {
                            Move newMove = new Move(numOfPiece, this.getPosX(), this.getPosY(), this.getPosX() + i, this.getPosY() + j, true);
                            movesGenerate.add(newMove);
                        }
                    }
                }

                //CASTLING:

                if (this.getPosX() == 5 && this.getPosY() == 1 && position[8][1] == 4 && position[6][1] == 0 && position[7][1] == 0) {
                    Move newMove = new Move(numOfPiece, 5, 1, 7, 1, false, 1);
                    movesGenerate.add(newMove);
                }

                if (this.getPosX() == 5 && this.getPosY() == 1 && position[1][1] == 4 && position[2][1] == 0 && position[3][1] == 0 && position[4][1] == 0) {
                    Move newMove = new Move(numOfPiece, 5, 1, 3, 1, false, 2);
                    movesGenerate.add(newMove);
                }

            }

            if (this.color == 'B') {

                for (int i = -1; i < 2; i++) {
                    for (int j = -1; j < 2; j++) {
                        if ((this.isInBounds(this.getPosX() + i, this.getPosY() + j)) &&
                                (position[this.getPosX() + i][this.getPosY() + j] == 0) && !(i == 0 && j == 0)) {
                            Move newMove = new Move(numOfPiece, this.getPosX(), this.getPosY(), this.getPosX() + i, this.getPosY() + j, false);
                            movesGenerate.add(newMove);
                        }

                        if ((this.isInBounds(this.getPosX() + i, this.getPosY() + j)) &&
                                (position[this.getPosX() + i][this.getPosY() + j] > 0) && (position[this.getPosX() + i][this.getPosY() + j] < 10) && !(i == 0 && j == 0)) {
                            Move newMove = new Move(numOfPiece, this.getPosX(), this.getPosY(), this.getPosX() + i, this.getPosY() + j, true);
                            movesGenerate.add(newMove);
                        }
                    }
                }

                //CASTLING:

                if (this.getPosX() == 5 && this.getPosY() == 8 && position[8][8] == 14 && position[6][8] == 0 && position[7][8] == 0) {
                    Move newMove = new Move(numOfPiece, 5, 8, 7, 8, false, 3);
                    movesGenerate.add(newMove);
                }

                if (this.getPosX() == 5 && this.getPosY() == 8 && position[1][8] == 14 && position[2][8] == 0 && position[3][8] == 0 && position[4][8] == 0) {
                    Move newMove = new Move(numOfPiece, 5, 8, 3, 8, false, 4);
                    movesGenerate.add(newMove);
                }

            }


        }


        return movesGenerate;
    }

}
