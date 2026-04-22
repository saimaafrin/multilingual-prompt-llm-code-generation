import java.util.Comparator;

public class CustomComparator implements Comparator<Object> {
    @Override
    public int compare(Object aObj1, Object aObj2) {
        if (aObj1 == null && aObj2 == null) {
            return 0;
        } else if (aObj1 == null) {
            return -1;
        } else if (aObj2 == null) {
            return 1;
        } else {
            // Assuming the objects are comparable, cast them to Comparable and compare
            if (aObj1 instanceof Comparable && aObj2 instanceof Comparable) {
                return ((Comparable) aObj1).compareTo(aObj2);
            } else {
                // If objects are not Comparable, compare their hash codes
                return Integer.compare(aObj1.hashCode(), aObj2.hashCode());
            }
        }
    }
}