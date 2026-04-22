import java.util.Comparator;

public class DoubleComparator implements Comparator<Double> {
    /**
     * Compares two floating point values. Returns 0 if they are equal, -1 if  {@literal o1 < o2}, 1 otherwise
     * @param o1 the first value
     * @param o2 the second value
     * @return 0 if they are equal, -1 if {@literal o1 < o2}, 1 otherwise
     */
    @Override
    public int compare(Double o1, Double o2) {
        if (o1 == null && o2 == null) {
            return 0;
        } else if (o1 == null) {
            return -1;
        } else if (o2 == null) {
            return 1;
        }

        double epsilon = 1e-10; // Small epsilon value to account for floating point precision
        double diff = o1 - o2;

        if (Math.abs(diff) < epsilon) {
            return 0;
        } else if (diff < 0) {
            return -1;
        } else {
            return 1;
        }
    }
}