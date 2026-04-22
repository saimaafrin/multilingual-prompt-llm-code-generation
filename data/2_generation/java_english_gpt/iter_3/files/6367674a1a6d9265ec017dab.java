import java.util.Comparator;

public class FloatComparator implements Comparator<Double> {
    /** 
     * Compares two floating point values. Returns 0 if they are equal, -1 if  {@literal o1 < o2}, 1 otherwise
     * @param o1 the first value
     * @param o2 the second value
     * @return 0 if they are equal, -1 if {@literal o1 < o2}, 1 otherwise
     */
    @Override 
    public int compare(Double o1, Double o2) {
        if (o1.equals(o2)) {
            return 0;
        }
        return o1 < o2 ? -1 : 1;
    }
}