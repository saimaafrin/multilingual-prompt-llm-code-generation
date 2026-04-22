import java.util.ArrayList;
import java.util.List;

public class Bucket<T> {
    private List<T> items;
    private Bucket<T> next;
    private Bucket<T> prev;
    
    /**
     * Removes this bucket from the data structure.
     */
    void removeSelf() {
        if (prev != null) {
            prev.next = next;
        }
        if (next != null) {
            next.prev = prev;
        }
        
        // Clear references to help garbage collection
        items = null;
        next = null;
        prev = null;
    }
}