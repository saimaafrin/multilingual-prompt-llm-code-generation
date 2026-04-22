import java.util.Objects;

public class BucketCompatibilityChecker {

    /**
     * @param dataset the dataset to check for bucket compatibility
     * @return true if the buckets are compatible, false otherwise
     */
    public boolean isCompatible(DataTable dataset) {
        if (dataset == null) {
            return false;
        }

        // Assuming DataTable has a method getBuckets() that returns an array of buckets
        Bucket[] buckets = dataset.getBuckets();

        if (buckets == null || buckets.length == 0) {
            return false;
        }

        // Compare all buckets to the first one
        Bucket firstBucket = buckets[0];
        for (Bucket bucket : buckets) {
            if (!Objects.equals(bucket, firstBucket)) {
                return false;
            }
        }

        return true;
    }
}

// Assuming Bucket and DataTable classes are defined elsewhere
class Bucket {
    // Bucket properties and methods
}

class DataTable {
    private Bucket[] buckets;

    public DataTable(Bucket[] buckets) {
        this.buckets = buckets;
    }

    public Bucket[] getBuckets() {
        return buckets;
    }
}