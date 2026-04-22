import java.util.Objects;

public class Bucket {
    private Bucket prev;
    private Bucket next;
    
    /**
     * Inserta este "bucket" en la estructura de datos antes del {@code bucket}.
     * @param bucket el "bucket", que será el siguiente a este "bucket".
     */
    void insertBefore(Bucket bucket) {
        Objects.requireNonNull(bucket, "bucket cannot be null");
        
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