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
        }
        if (o1 == null) {
            return -1;
        }
        if (o2 == null) {
            return 1;
        }
        if (Math.abs(o1 - o2) < 1e-9) {
            return 0;
        }
        return o1 < o2 ? -1 : 1;
    }
}