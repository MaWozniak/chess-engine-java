import javax.swing.*;
import java.awt.*;

public class BoardDisplay2 extends JFrame {
    JPanel MAINPanel = new JPanel();

    JPanel boardDisplay = new JPanel();

    private ImageIcon PAWN_B, PAWN_W, FIELD, KING_B, KING_W, ROCK_W, ROCK_B;
    private ImageIcon KNIGHT_B, KNIGHT_W, BISHOP_B, BISHOP_W, QUEEN_W, QUEEN_B;
    private ImageIcon BOARD;
    private JLabel[] label = new JLabel[64];
    private JLabel labelTemp = new JLabel();
    private JLabel background = new JLabel();

    //arrays for easy transition from one-int position to XY position
    Trans trans = new Trans();

    public BoardDisplay2() {
        super("Fight!");
        setSize(720, 756); //setSize(720,756);
        setResizable(false);
        //setLocation(640,100); //center
        setLocation(1070, 100);

        // setUndecorated(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        FIELD = new ImageIcon(getClass().getResource("tex2/EMPTY.png"));
        PAWN_B = new ImageIcon(getClass().getResource("tex2/PAWN_B.png"));
        PAWN_W = new ImageIcon(getClass().getResource("tex2/PAWN_W.png"));
        KING_B = new ImageIcon(getClass().getResource("tex2/KING_B.png"));
        KING_W = new ImageIcon(getClass().getResource("tex2/KING_W.png"));
        ROCK_B = new ImageIcon(getClass().getResource("tex2/ROCK_B.png"));
        ROCK_W = new ImageIcon(getClass().getResource("tex2/ROCK_W.png"));
        KNIGHT_B = new ImageIcon(getClass().getResource("tex2/KNIGHT_B.png"));
        KNIGHT_W = new ImageIcon(getClass().getResource("tex2/KNIGHT_W.png"));
        BISHOP_B = new ImageIcon(getClass().getResource("tex2/BISHOP_B.png"));
        BISHOP_W = new ImageIcon(getClass().getResource("tex2/BISHOP_W.png"));
        QUEEN_B = new ImageIcon(getClass().getResource("tex2/QUEEN_B.png"));
        QUEEN_W = new ImageIcon(getClass().getResource("tex2/QUEEN_W.png"));
        BOARD = new ImageIcon(getClass().getResource("tex2/BOARD.png"));

        boardDisplay.setLayout(new GridLayout(8, 8));

        boardDisplay.setOpaque(false); //!!!!!!!!!!!

        // boardDisplay.setBackground(new Color(110,110,120,250));

        boardDisplay.setPreferredSize(new Dimension(720, 720));
        boardDisplay.setMaximumSize(boardDisplay.getPreferredSize());
        boardDisplay.setMinimumSize(boardDisplay.getPreferredSize());

        background.setIcon(BOARD);
        background.setOpaque(false);
        background.setPreferredSize(new Dimension(720, 720));


        for (int i = 0; i < 64; i++) // for BLACKS: for(int i=63; i>-1; i--)
        {
            label[i] = new JLabel(FIELD);
            boardDisplay.add(label[i]);
        }

        label[8].setIcon(PAWN_B);
        label[9].setIcon(PAWN_B);
        label[10].setIcon(PAWN_B);
        label[11].setIcon(PAWN_B);
        label[12].setIcon(PAWN_B);
        label[13].setIcon(PAWN_B);
        label[14].setIcon(PAWN_B);
        label[15].setIcon(PAWN_B);

        label[48].setIcon(PAWN_W);
        label[49].setIcon(PAWN_W);
        label[50].setIcon(PAWN_W);
        label[51].setIcon(PAWN_W);
        label[52].setIcon(PAWN_W);
        label[53].setIcon(PAWN_W);
        label[54].setIcon(PAWN_W);
        label[55].setIcon(PAWN_W);

        //  MAINPanel.setLayout(new BoxLayout(MAINPanel, BoxLayout.Y_AXIS));

        // MAINPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 0, -100));

        // FlowLayout f = new FlowLayout();


        //OverlayLayout OL = new OverlayLayout(MAINPanel);
        //SpringLayout layout = new SpringLayout();
        MAINPanel.setLayout(null);

        MAINPanel.setBackground(new Color(0, 0, 5));

        MAINPanel.add(boardDisplay);

        Dimension size = boardDisplay.getPreferredSize();

        boardDisplay.setBounds(0, 0, size.width, size.height - 3);

        //boardDisplay.setLocation(100,-100);

        MAINPanel.add(background);

        size = background.getPreferredSize();

        background.setBounds(0, 0, size.width, size.height - 2);


        add(MAINPanel);

        setVisible(true);
    }

    public void setPieces(Board board) {
        for (int i = 0; i < 64; i++) {
            label[i].setIcon(FIELD);
        }

        for (int j = 0; j < 19; j++) {
            if (board.getWhitePiece(j).isAlive() && board.getWhitePiece(j).getCODE() == 1) {
                label[trans.position[board.getWhitePiece(j).getPosX()][board.getWhitePiece(j).getPosY()]].setIcon(PAWN_W);
            }
            if (board.getWhitePiece(j).isAlive() && board.getWhitePiece(j).getCODE() == 2) {
                label[trans.position[board.getWhitePiece(j).getPosX()][board.getWhitePiece(j).getPosY()]].setIcon(KING_W);
            }
            if (board.getWhitePiece(j).isAlive() && board.getWhitePiece(j).getCODE() == 4) {
                label[trans.position[board.getWhitePiece(j).getPosX()][board.getWhitePiece(j).getPosY()]].setIcon(ROCK_W);
            }
            if (board.getWhitePiece(j).isAlive() && board.getWhitePiece(j).getCODE() == 3) {
                label[trans.position[board.getWhitePiece(j).getPosX()][board.getWhitePiece(j).getPosY()]].setIcon(QUEEN_W);
            }
            if (board.getWhitePiece(j).isAlive() && board.getWhitePiece(j).getCODE() == 5) {
                label[trans.position[board.getWhitePiece(j).getPosX()][board.getWhitePiece(j).getPosY()]].setIcon(BISHOP_W);
            }
            if (board.getWhitePiece(j).isAlive() && board.getWhitePiece(j).getCODE() == 6) {
                label[trans.position[board.getWhitePiece(j).getPosX()][board.getWhitePiece(j).getPosY()]].setIcon(KNIGHT_W);
            }

            if (board.getBlackPiece(j).isAlive() && board.getBlackPiece(j).getCODE() == 1) {
                label[trans.position[board.getBlackPiece(j).getPosX()][board.getBlackPiece(j).getPosY()]].setIcon(PAWN_B);
            }
            if (board.getBlackPiece(j).isAlive() && board.getBlackPiece(j).getCODE() == 2) {
                label[trans.position[board.getBlackPiece(j).getPosX()][board.getBlackPiece(j).getPosY()]].setIcon(KING_B);
            }
            if (board.getBlackPiece(j).isAlive() && board.getBlackPiece(j).getCODE() == 4) {
                label[trans.position[board.getBlackPiece(j).getPosX()][board.getBlackPiece(j).getPosY()]].setIcon(ROCK_B);
            }
            if (board.getBlackPiece(j).isAlive() && board.getBlackPiece(j).getCODE() == 3) {
                label[trans.position[board.getBlackPiece(j).getPosX()][board.getBlackPiece(j).getPosY()]].setIcon(QUEEN_B);
            }
            if (board.getBlackPiece(j).isAlive() && board.getBlackPiece(j).getCODE() == 5) {
                label[trans.position[board.getBlackPiece(j).getPosX()][board.getBlackPiece(j).getPosY()]].setIcon(BISHOP_B);
            }
            if (board.getBlackPiece(j).isAlive() && board.getBlackPiece(j).getCODE() == 6) {
                label[trans.position[board.getBlackPiece(j).getPosX()][board.getBlackPiece(j).getPosY()]].setIcon(KNIGHT_B);
            }
        }

        this.boardDisplay.repaint();
    }

    public void move(Move move) {
        int pos1 = trans.position[move.getPos1_X()][move.getPos1_Y()];
        int pos2 = trans.position[move.getPos2_X()][move.getPos2_Y()];

        this.labelTemp.setIcon(this.FIELD);
        this.label[pos2].setIcon(this.label[pos1].getIcon());
        this.label[pos1].setIcon(this.labelTemp.getIcon());
        this.boardDisplay.repaint();
    }

    /*public void paint(Graphics g){

        super.paint(g);
        g.drawImage(BOARD.getImage(),0,0,this);

    }*/

}

