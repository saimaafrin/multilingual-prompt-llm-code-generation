import java.util.Objects;

public class DataTable {
    // Assuming DataTable has some fields and methods
    // For the purpose of this example, let's assume it has a field 'bucket'
    private String bucket;

    public DataTable(String bucket) {
        this.bucket = bucket;
    }

    public String getBucket() {
        return bucket;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DataTable dataTable = (DataTable) o;
        return Objects.equals(bucket, dataTable.bucket);
    }

    @Override
    public int hashCode() {
        return Objects.hash(bucket);
    }
}

public class BucketChecker {
    /**
     * @return true se il bucket è lo stesso.
     */
    public boolean isCompatible(DataTable dataset) {
        // Assuming 'this' refers to another DataTable instance
        // For the purpose of this example, let's assume 'this' has a field 'bucket'
        String thisBucket = this.getBucket();
        String otherBucket = dataset.getBucket();
        return Objects.equals(thisBucket, otherBucket);
    }

    // Assuming this class has a field 'bucket'
    private String bucket;

    public BucketChecker(String bucket) {
        this.bucket = bucket;
    }

    public String getBucket() {
        return bucket;
    }
}