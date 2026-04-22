public class Bucket {
    private Bucket next;
    private Bucket prev;

    public Bucket() {
        this.next = null;
        this.prev = null;
    }

    public void insertBefore(Bucket bucket) {
        if (bucket == null) {
            throw new IllegalArgumentException("Bucket cannot be null");
        }

        // Set this bucket's previous to the new bucket's previous
        this.prev = bucket.prev;

        // If the new bucket's previous is not null, set its next to this bucket
        if (bucket.prev != null) {
            bucket.prev.next = this;
        }

        // Set this bucket's next to the new bucket
        this.next = bucket;

        // Set the new bucket's previous to this bucket
        bucket.prev = this;
    }

    // Getters and setters for next and prev (if needed)
    public Bucket getNext() {
        return next;
    }

    public void setNext(Bucket next) {
        this.next = next;
    }

    public Bucket getPrev() {
        return prev;
    }

    public void setPrev(Bucket prev) {
        this.prev = prev;
    }
}