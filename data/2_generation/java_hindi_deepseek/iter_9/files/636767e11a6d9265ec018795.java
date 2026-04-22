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

        // Compare all buckets to the first one
        Bucket firstBucket = buckets.get(0);
        for (Bucket bucket : buckets) {
            if (!Objects.equals(firstBucket, bucket)) {
                return false;
            }
        }

        return true;
    }
}

// Assuming DataTable and Bucket classes are defined elsewhere
class DataTable {
    private List<Bucket> buckets;

    public DataTable(List<Bucket> buckets) {
        this.buckets = buckets;
    }

    public List<Bucket> getBuckets() {
        return buckets;
    }
}

class Bucket {
    // Define the properties and methods of a Bucket
    // For example:
    private String name;
    private int size;

    public Bucket(String name, int size) {
        this.name = name;
        this.size = size;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Bucket bucket = (Bucket) o;
        return size == bucket.size && Objects.equals(name, bucket.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, size);
    }
}