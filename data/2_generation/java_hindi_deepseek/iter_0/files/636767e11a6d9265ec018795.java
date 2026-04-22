import java.util.HashMap;
import java.util.Map;

public class DataTable {
    private Map<String, Integer> bucketCounts;

    public DataTable() {
        this.bucketCounts = new HashMap<>();
    }

    public void addBucket(String bucketName, int count) {
        bucketCounts.put(bucketName, count);
    }

    public Map<String, Integer> getBucketCounts() {
        return bucketCounts;
    }
}

public class Main {
    /**
     * @return यदि बकेट समान है तो true लौटाता है।
     */
    public static boolean isCompatible(DataTable dataset) {
        Map<String, Integer> bucketCounts = dataset.getBucketCounts();
        if (bucketCounts.isEmpty()) {
            return true;
        }

        int firstCount = bucketCounts.values().iterator().next();
        for (int count : bucketCounts.values()) {
            if (count != firstCount) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        DataTable dataset = new DataTable();
        dataset.addBucket("Bucket1", 10);
        dataset.addBucket("Bucket2", 10);
        dataset.addBucket("Bucket3", 10);

        System.out.println(isCompatible(dataset)); // Output: true
    }
}