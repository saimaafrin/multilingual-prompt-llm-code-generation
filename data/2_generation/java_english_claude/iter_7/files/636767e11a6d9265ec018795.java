import java.util.Objects;

public class DataTable {
    private String bucket;
    
    public DataTable(String bucket) {
        this.bucket = bucket;
    }

    /**
     * @return true if the bucket is same.
     */
    public boolean isCompatible(DataTable dataset) {
        if (dataset == null) {
            return false;
        }
        return Objects.equals(this.bucket, dataset.bucket);
    }

    // Getter for bucket
    public String getBucket() {
        return bucket;
    }
}