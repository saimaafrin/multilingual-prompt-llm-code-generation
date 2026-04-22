public class Bucket {
    private Bucket next;

    public void insertBefore(Bucket bucket) {
        if (bucket == null) {
            throw new IllegalArgumentException("Bucket cannot be null");
        }
        Bucket temp = this.next;
        this.next = bucket;
        bucket.next = temp;
    }

    public Bucket getNext() {
        return next;
    }

    public void setNext(Bucket next) {
        this.next = next;
    }
}