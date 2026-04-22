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

        // Save the next reference of the current bucket
        Bucket temp = this.next;

        // Set the next reference of the current bucket to the new bucket
        this.next = bucket;

        // Set the next reference of the new bucket to the saved reference
        bucket.next = temp;
    }
}