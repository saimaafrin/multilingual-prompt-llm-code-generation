public class Bucket {
    private Bucket next;
    private Bucket prev;

    public void insertBefore(Bucket bucket) {
        if (bucket == null) {
            throw new IllegalArgumentException("Bucket cannot be null");
        }

        // Set the previous of the new bucket to the previous of the current bucket
        bucket.prev = this.prev;

        // Set the next of the new bucket to the current bucket
        bucket.next = this;

        // If there is a previous bucket, set its next to the new bucket
        if (this.prev != null) {
            this.prev.next = bucket;
        }

        // Set the previous of the current bucket to the new bucket
        this.prev = bucket;
    }
}