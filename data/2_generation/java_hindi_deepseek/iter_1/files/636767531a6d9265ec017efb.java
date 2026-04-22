class Bucket {
    Bucket next;

    // Constructor and other methods can be added here

    /**
     * इस बकेट को डेटा संरचना में {@code bucket} से पहले डालता है।
     * @param bucket वह बकेट है, जो इस बकेट के बाद आएगा।
     */
    void insertBefore(Bucket bucket) {
        if (bucket == null) {
            throw new IllegalArgumentException("Bucket cannot be null");
        }
        Bucket temp = this.next;
        this.next = bucket;
        bucket.next = temp;
    }
}