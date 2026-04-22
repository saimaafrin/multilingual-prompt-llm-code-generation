import java.util.Comparator;

public class ObjectComparator implements Comparator<Object> {
    
    /** 
     * @see Comparator 
     */
    public int compare(Object aObj1, Object aObj2) {
        if (aObj1 == null && aObj2 == null) {
            return 0;
        }
        if (aObj1 == null) {
            return -1;
        }
        if (aObj2 == null) {
            return 1;
        }
        
        // Compare using toString() representation if objects are not null
        return aObj1.toString().compareTo(aObj2.toString());
    }
}