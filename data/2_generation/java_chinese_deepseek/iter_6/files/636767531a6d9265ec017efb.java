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

        // Set the previous of the new bucket to the previous of the current bucket
        bucket.prev = this.prev;

        // If the current bucket has a previous, set its next to the new bucket
        if (this.prev != null) {
            this.prev.next = bucket;
        }

        // Set the next of the new bucket to the current bucket
        bucket.next = this;

        // Set the previous of the current bucket to the new bucket
        this.prev = bucket;
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