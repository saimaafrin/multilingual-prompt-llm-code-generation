import java.util.Comparator;

public class DoubleComparator implements Comparator<Double> {
    private static final double EPSILON = 1e-10;

    @Override
    public int compare(Double o1, Double o2) {
        if (Math.abs(o1 - o2) < EPSILON) {
            return 0;
        } else if (o1 < o2) {
            return -1;
        } else {
            return 1;
        }
    }
}