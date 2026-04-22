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

public class CompatibilityChecker {
    /**
     * @param dataset The dataset to check for compatibility.
     * @return true if the buckets are the same.
     */
    public boolean isCompatible(DataTable dataset) {
        // Assuming 'this' refers to another DataTable instance
        return this.equals(dataset);
    }
}