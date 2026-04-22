public class FloatComparator {
    /**
     * Compares two floating point values. Returns 0 if they are equal, -1 if {@literal o1 < o2}, 1 otherwise
     * @param o1 the first value 
     * @param o2 the second value
     * @return 0 if they are equal, -1 if {@literal o1 < o2}, 1 otherwise
     */
    public static int compare(float o1, float o2) {
        if (o1 == o2) {
            return 0;
        }
        else if (o1 < o2) {
            return -1;
        }
        else {
            return 1;
        }
    }
}