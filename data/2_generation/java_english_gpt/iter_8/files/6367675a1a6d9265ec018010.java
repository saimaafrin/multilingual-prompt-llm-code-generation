public class Bucket {
    // Assuming there is a data structure that holds the buckets
    private DataStructure dataStructure;

    public Bucket(DataStructure dataStructure) {
        this.dataStructure = dataStructure;
    }

    /** 
     * Removes this bucket from the data structure.
     */
    public void removeSelf() {
        dataStructure.removeBucket(this);
    }
}

class DataStructure {
    // A list to hold the buckets
    private List<Bucket> buckets;

    public DataStructure() {
        buckets = new ArrayList<>();
    }

    public void addBucket(Bucket bucket) {
        buckets.add(bucket);
    }

    public void removeBucket(Bucket bucket) {
        buckets.remove(bucket);
    }
}