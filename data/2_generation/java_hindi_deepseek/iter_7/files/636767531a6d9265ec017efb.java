class Bucket {
    Bucket next;
    Bucket prev;

    // Constructor and other methods can be added here

    void insertBefore(Bucket bucket) {
        if (bucket == null) {
            throw new IllegalArgumentException("Bucket cannot be null");
        }

        // Set the previous of the new bucket to the previous of the current bucket
        this.prev = bucket.prev;

        // If the previous of the current bucket is not null, set its next to the new bucket
        if (bucket.prev != null) {
            bucket.prev.next = this;
        }

        // Set the next of the new bucket to the current bucket
        this.next = bucket;

        // Set the previous of the current bucket to the new bucket
        bucket.prev = this;
    }
}