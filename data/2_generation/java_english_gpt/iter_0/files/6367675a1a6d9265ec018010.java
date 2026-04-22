public class Bucket {
    private Bucket next; // Reference to the next bucket in the data structure

    // Constructor
    public Bucket() {
        this.next = null;
    }

    /** 
     * Removes this bucket from the data structure.
     */
    public void removeSelf() {
        if (next != null) {
            // If there is a next bucket, we can skip this bucket
            next = next.next;
        }
        // If this is the last bucket, we simply set next to null
        // This bucket will be eligible for garbage collection
    }
}