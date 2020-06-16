import java.util.ArrayList;

public class Sequence {

    private ArrayList<Move> sequence = new ArrayList<Move>();

    public boolean check = false;
    public boolean checkmate = false;

    public double firstValue = 0.0;
    public ArrayList<Double> firstResponces = new ArrayList<Double>();
    public double worthDepth4 = 200.0;
    public double worthDepth8 = 200.0;
    public double worthDepth12 = 200.0;
    public double bestBeta4 = 200.0;
    public double avrgBeta4 = 0.0;

    public Sequence() {

        for (int i = 0; i < 12; i++) {

            sequence.add(new Move());
        }
    }

    public void set(int index, Move move) {

        sequence.set(index, move);
    }

    public Move move(int index) {

        return sequence.get(index);
    }

    public void showSequence() {
        for (int i = 0; i < this.sequence.size(); i++) {
            this.sequence.get(i).introduceShort();
        }
    }
}
