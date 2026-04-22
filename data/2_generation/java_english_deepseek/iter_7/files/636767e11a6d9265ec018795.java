import java.util.Objects;

public class DataTable {
    // Assuming DataTable class has some fields and methods
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
     * @param dataset The dataset to check.
     * @return true if the bucket is the same.
     */
    public boolean isCompatible(DataTable dataset) {
        if (dataset == null) {
            return false;
        }
        // Assuming we have a reference bucket to compare against
        DataTable referenceDataset = new DataTable("referenceBucket");
        return referenceDataset.equals(dataset);
    }
}