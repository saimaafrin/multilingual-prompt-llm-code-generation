public class Bucket {
    private Bucket next;

    public void insertBefore(Bucket bucket) {
        if (bucket == null) {
            throw new IllegalArgumentException("Bucket cannot be null");
        }
        // Save the next reference of the current bucket
        Bucket temp = this.next;
        // Set the next reference of the current bucket to the new bucket
        this.next = bucket;
        // Set the next reference of the new bucket to the saved reference
        bucket.next = temp;
    }
}