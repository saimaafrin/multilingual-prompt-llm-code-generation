import java.util.ArrayList;
import java.util.List;

public class Bucket<T> {
    private List<T> elements;
    private Bucket<T> next;
    private Bucket<T> prev;
    
    /**
     * Rimuove questo bucket dalla struttura dati.
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
        this.elements = null;
    }
}