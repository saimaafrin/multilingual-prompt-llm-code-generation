import java.util.Objects;

public class DataTable {
    private int bucket;
    
    public DataTable(int bucket) {
        this.bucket = bucket;
    }

    /**
     * @return true se il bucket è lo stesso.
     */
    public boolean isCompatible(DataTable dataset) {
        if (dataset == null) {
            return false;
        }
        return this.bucket == dataset.bucket;
    }

    // Getter for bucket
    public int getBucket() {
        return bucket;
    }
}