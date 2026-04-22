class Bucket {
    Bucket next;

    void insertBefore(Bucket bucket) {
        if (bucket == null) {
            throw new IllegalArgumentException("Bucket cannot be null");
        }
        Bucket temp = this.next;
        this.next = bucket;
        bucket.next = temp;
    }
}