public class Bucket {
    private Bucket next;

    public Bucket(Bucket next) {
        this.next = next;
    }

    public Bucket getNext() {
        return next;
    }

    public void setNext(Bucket next) {
        this.next = next;
    }

    public void insertBefore(Bucket bucket) {
        if (bucket == null) {
            throw new IllegalArgumentException("Bucket cannot be null");
        }

        Bucket currentNext = this.next;
        this.next = bucket;
        bucket.setNext(currentNext);
    }
}