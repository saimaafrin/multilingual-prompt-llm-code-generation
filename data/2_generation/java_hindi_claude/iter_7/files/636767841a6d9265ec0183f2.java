import java.util.Comparator;

public class MyComparator<T> implements Comparator<T> {
    
    @Override
    public int compare(T o1, T o2) {
        if (o1 == null && o2 == null) {
            return 0;
        }
        if (o1 == null) {
            return -1;
        }
        if (o2 == null) {
            return 1;
        }
        
        if (o1 instanceof Comparable) {
            return ((Comparable<T>) o1).compareTo(o2);
        }
        
        return o1.toString().compareTo(o2.toString());
    }
}