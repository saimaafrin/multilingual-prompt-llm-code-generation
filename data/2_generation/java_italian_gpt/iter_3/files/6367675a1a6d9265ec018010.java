public class Bucket {
    // Assuming there are some properties for the Bucket class
    private String name;
    private List<Bucket> subBuckets;

    public Bucket(String name) {
        this.name = name;
        this.subBuckets = new ArrayList<>();
    }

    /** 
     * Rimuove questo bucket dalla struttura dati.
     */
    public void removeSelf() {
        // Logic to remove this bucket from its parent
        // This is a placeholder as the actual removal logic depends on the data structure
        if (this.parent != null) {
            this.parent.removeSubBucket(this);
        }
    }

    private void removeSubBucket(Bucket bucket) {
        subBuckets.remove(bucket);
    }

    // Other methods and properties of the Bucket class
    private Bucket parent;

    public void setParent(Bucket parent) {
        this.parent = parent;
    }
}