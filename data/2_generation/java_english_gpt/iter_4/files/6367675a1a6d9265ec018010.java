public class Bucket {
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
    // Assume there's a list or set of buckets
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