import java.util.Objects;

public class BucketCompatibilityChecker {

    /**
     * @param dataset डेटा टेबल जिसकी जांच की जानी है
     * @return यदि बकेट समान है तो true लौटाता है।
     */
    public boolean isCompatible(DataTable dataset) {
        // Assuming DataTable has a method getBucket() that returns the bucket identifier
        String bucket1 = dataset.getBucket();
        String bucket2 = this.getBucket(); // Assuming this class also has a getBucket() method

        // Compare the two bucket identifiers
        return Objects.equals(bucket1, bucket2);
    }

    // Assuming this class has a method to get the bucket identifier
    public String getBucket() {
        // Return the bucket identifier for this instance
        return "defaultBucket"; // Replace with actual implementation
    }
}

// Assuming DataTable class is defined as follows:
class DataTable {
    private String bucket;

    public DataTable(String bucket) {
        this.bucket = bucket;
    }

    public String getBucket() {
        return bucket;
    }
}