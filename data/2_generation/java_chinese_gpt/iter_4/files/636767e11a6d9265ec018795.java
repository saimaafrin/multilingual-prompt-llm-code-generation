import java.util.Objects;

public class DataTable {
    // Assuming DataTable has a method to get the bucket identifier
    private String bucketId;

    public DataTable(String bucketId) {
        this.bucketId = bucketId;
    }

    public String getBucketId() {
        return bucketId;
    }
}

public class CompatibilityChecker {
    private DataTable currentDataset;

    public CompatibilityChecker(DataTable dataset) {
        this.currentDataset = dataset;
    }

    /**
     * @return 如果桶相同则返回真。
     */
    public boolean isCompatible(DataTable dataset) {
        return Objects.equals(this.currentDataset.getBucketId(), dataset.getBucketId());
    }
}