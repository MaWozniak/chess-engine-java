import java.util.ArrayList;

public class Knight extends Piece {
    protected int CODE = 6;

    public Knight(boolean live, char side, int X, int Y) {
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
//WIP: comment out simply positional values

//            if ((this.posX > 2 && this.posX < 7) && (this.posY > 2 && this.posY < 7)) {
//                value += 0.005;
//            }

            value += 3.0;
        }
        return value;
    }

    public ArrayList<Move> generateMoves(int[][] position, int numOfPiece, Move move) {
        this.movesGenerate.clear();

        if (this.isAlive()) {
            if (this.color == 'W') {

                for (int i = -2; i < 3; i++) {

                    for (int j = -2; j < 3; j++) {

                        if (!(i == j || i == -j || i == 0 || j == 0) && (this.isInBounds(this.getPosX() + i, this.getPosY() + j)) &&
                                (position[this.getPosX() + i][this.getPosY() + j] == 0)) {
                            Move newMove = new Move(numOfPiece, this.getPosX(), this.getPosY(), this.getPosX() + i, this.getPosY() + j, false);
                            movesGenerate.add(newMove);
                        }

                        if (!(i == j || i == -j || i == 0 || j == 0) && (this.isInBounds(this.getPosX() + i, this.getPosY() + j)) &&
                                (position[this.getPosX() + i][this.getPosY() + j] > 10)) {
                            Move newMove = new Move(numOfPiece, this.getPosX(), this.getPosY(), this.getPosX() + i, this.getPosY() + j, true);
                            movesGenerate.add(newMove);
                        }

                    }
                }


            }

            if (this.color == 'B') {
                for (int i = -2; i < 3; i++) {

                    for (int j = -2; j < 3; j++) {

                        if (!(i == j || i == -j || i == 0 || j == 0) && (this.isInBounds(this.getPosX() + i, this.getPosY() + j)) &&
                                (position[this.getPosX() + i][this.getPosY() + j] == 0)) {
                            Move newMove = new Move(numOfPiece, this.getPosX(), this.getPosY(), this.getPosX() + i, this.getPosY() + j, false);
                            movesGenerate.add(newMove);
                        }

                        if (!(i == j || i == -j || i == 0 || j == 0) && (this.isInBounds(this.getPosX() + i, this.getPosY() + j)) &&
                                (position[this.getPosX() + i][this.getPosY() + j] < 10) && (position[this.getPosX() + i][this.getPosY() + j] > 0)) {
                            Move newMove = new Move(numOfPiece, this.getPosX(), this.getPosY(), this.getPosX() + i, this.getPosY() + j, true);
                            movesGenerate.add(newMove);
                        }

                    }
                }

            }

        }

        return movesGenerate;
    }

}
