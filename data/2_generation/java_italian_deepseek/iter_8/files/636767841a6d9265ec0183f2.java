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
            // Assuming the objects are Comparable, otherwise, you need to handle the case
            return ((Comparable) aObj1).compareTo(aObj2);
        }
    }
}