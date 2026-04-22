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
        
        this.next = bucket;
        this.prev = bucket.prev;
        
        if (bucket.prev != null) {
            bucket.prev.next = this;
        }
        
        bucket.prev = this;
    }
}