public class Bucket {
    private Bucket next;
    private Bucket prev;

    public void insertBefore(Bucket bucket) {
        if (bucket == null) {
            throw new IllegalArgumentException("Bucket cannot be null");
        }

        // Set this bucket's next to the given bucket
        this.next = bucket;

        // Set this bucket's prev to the given bucket's prev
        this.prev = bucket.prev;

        // If the given bucket had a previous bucket, update its next to this bucket
        if (bucket.prev != null) {
            bucket.prev.next = this;
        }

        // Update the given bucket's prev to this bucket
        bucket.prev = this;
    }
}