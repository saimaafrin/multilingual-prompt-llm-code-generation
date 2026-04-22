import java.util.Objects;

public class Bucket {
    private Bucket prev;
    private Bucket next;
    
    /**
     * 在数据结构中将此桶插入到 {@code bucket} 之前。
     * @param bucket 作为当前桶下一个的桶。
     */
    void insertBefore(Bucket bucket) {
        Objects.requireNonNull(bucket, "bucket cannot be null");
        
        // Set this bucket's next reference
        this.next = bucket;
        
        // Set this bucket's prev reference to bucket's previous
        this.prev = bucket.prev;
        
        // Update bucket's prev reference to this
        bucket.prev = this;
        
        // If there was a previous bucket, update its next reference
        if (this.prev != null) {
            this.prev.next = this;
        }
    }
}