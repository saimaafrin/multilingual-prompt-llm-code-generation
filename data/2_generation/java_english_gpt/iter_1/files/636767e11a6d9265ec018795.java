import java.util.Objects;

public class DataTable {
    private String bucketName;

    public DataTable(String bucketName) {
        this.bucketName = bucketName;
    }

    public String getBucketName() {
        return bucketName;
    }

    /**
     * @return true if the bucket is same.
     */
    public boolean isCompatible(DataTable dataset) {
        if (dataset == null) {
            return false;
        }
        return Objects.equals(this.bucketName, dataset.getBucketName());
    }
}