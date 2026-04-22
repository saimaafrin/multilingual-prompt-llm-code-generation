public class Bucket {
    private Bucket next;
    private Bucket prev;

    public void insertBefore(Bucket bucket) {
        if (bucket == null) {
            throw new IllegalArgumentException("Bucket cannot be null");
        }

        // Set the previous of the new bucket to the previous of this bucket
        bucket.prev = this.prev;

        // If there is a previous bucket, set its next to the new bucket
        if (this.prev != null) {
            this.prev.next = bucket;
        }

        // Set the next of the new bucket to this bucket
        bucket.next = this;

        // Set the previous of this bucket to the new bucket
        this.prev = bucket;
    }
}