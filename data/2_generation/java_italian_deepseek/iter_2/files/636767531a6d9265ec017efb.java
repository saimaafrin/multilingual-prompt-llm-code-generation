public class Bucket {
    private Bucket next;

    public void insertBefore(Bucket bucket) {
        if (bucket == null) {
            throw new IllegalArgumentException("Bucket cannot be null");
        }
        // Save the current next of this bucket
        Bucket temp = this.next;
        // Set this bucket's next to the given bucket
        this.next = bucket;
        // Set the given bucket's next to the previously saved next
        bucket.next = temp;
    }
}