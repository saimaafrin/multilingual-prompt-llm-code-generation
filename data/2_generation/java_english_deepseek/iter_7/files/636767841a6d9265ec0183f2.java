import java.util.Comparator;

public class CustomComparator implements Comparator<Object> {
    @Override
    public int compare(Object aObj1, Object aObj2) {
        // Assuming the objects are comparable, cast them to Comparable and compare
        if (aObj1 instanceof Comparable && aObj2 instanceof Comparable) {
            return ((Comparable) aObj1).compareTo(aObj2);
        } else {
            throw new IllegalArgumentException("Objects must implement Comparable");
        }
    }
}