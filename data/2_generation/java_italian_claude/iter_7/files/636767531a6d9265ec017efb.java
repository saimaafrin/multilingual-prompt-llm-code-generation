import java.util.Objects;

public class Bucket {
    private Bucket prev;
    private Bucket next;
    
    /**
     * Inserisce questo bucket nella struttura dati prima del {@code bucket}.
     * @param bucket il bucket, che sarà il successivo a questo bucket.
     */
    void insertBefore(Bucket bucket) {
        Objects.requireNonNull(bucket);
        
        // Set this bucket's next reference to the given bucket
        this.next = bucket;
        
        // Set this bucket's prev reference to the given bucket's previous
        this.prev = bucket.prev;
        
        // Update the given bucket's prev reference to point to this bucket
        bucket.prev = this;
        
        // If there was a previous bucket, update its next reference
        if (this.prev != null) {
            this.prev.next = this;
        }
    }
}