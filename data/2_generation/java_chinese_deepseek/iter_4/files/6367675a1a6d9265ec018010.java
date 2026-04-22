import java.util.*;

class Bucket {
    // Assuming this is part of a larger data structure like a LinkedList or similar
    private Bucket next;
    private Bucket prev;

    public void removeSelf() {
        if (prev != null) {
            prev.next = next;
        }
        if (next != null) {
            next.prev = prev;
        }
        // Optionally, you can nullify the references to help with garbage collection
        next = null;
        prev = null;
    }
}