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
    private String[] buckets;

    public CompatibilityChecker(String[] buckets) {
        this.buckets = buckets;
    }

    /** 
     * @return यदि बकेट समान है तो true लौटाता है।
     */
    public boolean isCompatible(DataTable dataset) {
        String[] datasetBuckets = dataset.getBuckets();
        if (buckets.length != datasetBuckets.length) {
            return false;
        }
        for (int i = 0; i < buckets.length; i++) {
            if (!buckets[i].equals(datasetBuckets[i])) {
                return false;
            }
        }
        return true;
    }
}