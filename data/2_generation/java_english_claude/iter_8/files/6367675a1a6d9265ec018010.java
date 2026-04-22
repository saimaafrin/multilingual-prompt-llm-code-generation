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
            prev.next = this.next;
        }
        
        if (next != null) {
            next.prev = this.prev;
        }
        
        // Clear references to help garbage collection
        this.next = null;
        this.prev = null;
        this.items = null;
    }
}