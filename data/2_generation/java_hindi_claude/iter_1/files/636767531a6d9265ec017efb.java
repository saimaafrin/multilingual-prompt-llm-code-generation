import java.util.LinkedList;

public class Bucket {
    private Bucket next;
    private Bucket prev;
    
    /**
     * Inserts this bucket in the data structure before the {@code bucket}.
     * @param bucket the bucket, that will be the next to this bucket.
     */
    public void insertBefore(Bucket bucket) {
        if (bucket == null) {
            return;
        }
        
        // Set this bucket's next pointer
        this.next = bucket;
        
        // Set this bucket's prev pointer to bucket's previous
        this.prev = bucket.prev;
        
        // Update bucket's prev pointer to point to this
        bucket.prev = this;
        
        // If there was a previous bucket, update its next pointer
        if (this.prev != null) {
            this.prev.next = this;
        }
    }
}