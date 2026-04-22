public class Bucket {
    private Bucket next;
    private Bucket prev;

    public void insertBefore(Bucket bucket) {
        if (bucket == null) {
            throw new IllegalArgumentException("Bucket cannot be null");
        }

        // Set the previous of the new bucket to the previous of the current bucket
        this.prev = bucket.prev;

        // Set the next of the new bucket to the current bucket
        this.next = bucket;

        // If the current bucket has a previous, set its next to the new bucket
        if (bucket.prev != null) {
            bucket.prev.next = this;
        }

        // Set the previous of the current bucket to the new bucket
        bucket.prev = this;
    }
}