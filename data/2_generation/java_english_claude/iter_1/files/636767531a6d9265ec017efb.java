import java.util.Objects;

public class Bucket {
    private Bucket prev;
    private Bucket next;
    
    /**
     * Inserts this bucket in the data structure before the {@code bucket}.
     * @param bucket the bucket, that will be the next to this bucket.
     */
    void insertBefore(Bucket bucket) {
        Objects.requireNonNull(bucket, "Bucket cannot be null");
        
        // Set this bucket's next pointer to the given bucket
        this.next = bucket;
        
        // Set this bucket's prev pointer to the given bucket's previous
        this.prev = bucket.prev;
        
        // Update the given bucket's prev pointer to point to this bucket
        bucket.prev = this;
        
        // If there was a previous bucket, update its next pointer
        if (this.prev != null) {
            this.prev.next = this;
        }
    }
}