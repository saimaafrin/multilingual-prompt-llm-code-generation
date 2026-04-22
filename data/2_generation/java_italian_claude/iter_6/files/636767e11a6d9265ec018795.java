import java.util.Objects;

public class DataTable {
    private String bucket;
    
    /**
     * @return true se il bucket è lo stesso.
     */
    public boolean isCompatible(DataTable dataset) {
        if (dataset == null) {
            return false;
        }
        return Objects.equals(this.bucket, dataset.bucket);
    }
}