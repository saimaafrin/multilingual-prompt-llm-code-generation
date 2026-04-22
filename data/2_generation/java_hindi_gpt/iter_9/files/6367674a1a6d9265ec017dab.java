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
        if (o1.equals(o2)) {
            return 0;
        }
        return o1 < o2 ? -1 : 1;
    }
}