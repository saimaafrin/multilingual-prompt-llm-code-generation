public class DataTable {
    // Assuming DataTable has a method to get buckets
    private String[] buckets;

    public DataTable(String[] buckets) {
        this.buckets = buckets;
    }

    public String[] getBuckets() {
        return buckets;
    }
}

public class CompatibilityChecker {
    private String[] myBuckets;

    public CompatibilityChecker(String[] myBuckets) {
        this.myBuckets = myBuckets;
    }

    /** 
     * @return यदि बकेट समान है तो true लौटाता है।
     */
    public boolean isCompatible(DataTable dataset) {
        String[] datasetBuckets = dataset.getBuckets();
        if (myBuckets.length != datasetBuckets.length) {
            return false;
        }
        for (int i = 0; i < myBuckets.length; i++) {
            if (!myBuckets[i].equals(datasetBuckets[i])) {
                return false;
            }
        }
        return true;
    }
}