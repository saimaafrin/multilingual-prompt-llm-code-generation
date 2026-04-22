import java.util.LinkedList;

public class Bucket<T> {
    private T data;
    private Bucket<T> next;
    private Bucket<T> prev;

    public void insertBefore(Bucket<T> bucket) {
        if (bucket == null) {
            return;
        }

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