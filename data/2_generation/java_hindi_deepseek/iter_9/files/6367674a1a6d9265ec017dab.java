import java.util.Comparator;

public class FloatComparator implements Comparator<Double> {
    /**
     * दो फ्लोटिंग पॉइंट मानों की तुलना करता है। यदि वे समान हैं तो 0 लौटाता है, -1 यदि {@literal o1 < o2} है, अन्यथा 1 लौटाता है।
     * @param o1 पहला मान
     * @param o2 दूसरा मान
     * @return यदि वे समान हैं तो 0, -1 यदि {@literal o1 < o2} है, अन्यथा 1
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

        double epsilon = 0.000001; // Tolerance for floating point comparison
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