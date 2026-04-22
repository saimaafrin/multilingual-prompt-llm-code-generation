import java.util.Objects;

public class DataTable {
    // Assuming DataTable class has necessary fields and methods

    public boolean isCompatible(DataTable dataset) {
        // Assuming compatibility is determined by comparing the buckets of the datasets
        // For simplicity, let's assume the bucket is represented by a String field called 'bucket'
        return Objects.equals(this.bucket, dataset.bucket);
    }

    // Example field for bucket
    private String bucket;

    // Constructor and other methods for DataTable class
    public DataTable(String bucket) {
        this.bucket = bucket;
    }

    public String getBucket() {
        return bucket;
    }

    public void setBucket(String bucket) {
        this.bucket = bucket;
    }
}