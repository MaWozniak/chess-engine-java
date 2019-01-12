public class Trans {

    //arrays for easy transition from one-int position to XY position

    public int[] posX = new int[64];
    public int[] posY = new int[64];
    public int[][] position = new int[9][9];

    Trans() {
        for (int i = 0; i < 64; i++) {
            posX[i] = (i % 8) + 1;
            posY[i] = 8 - i / 8;
        }
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                position[i][j] = (i - 1) + (8 - j) * 8;
            }
        }
    }

    public static void main(String[] args) {
        Trans trans = new Trans();
        System.out.println(trans.position[1][8]);
        int positionOneInt = 0;
        System.out.println(trans.posX[positionOneInt] + " " + trans.posY[positionOneInt]);
    }
}
