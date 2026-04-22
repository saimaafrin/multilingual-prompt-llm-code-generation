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

        // Assuming DataTable has a method getBuckets() that returns a list of buckets
        List<Bucket> buckets = dataset.getBuckets();

        if (buckets == null || buckets.isEmpty()) {
            return false;
        }

        // Get the first bucket to compare with the rest
        Bucket firstBucket = buckets.get(0);

        for (Bucket bucket : buckets) {
            if (!Objects.equals(firstBucket, bucket)) {
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
    private List<Bucket> buckets;

    public DataTable(List<Bucket> buckets) {
        this.buckets = buckets;
    }

    public List<Bucket> getBuckets() {
        return buckets;
    }
}