import java.util.Objects;

public class DataTableUtils {
    private List<String> buckets;
    
    /**
     * Checks if the bucket configuration is compatible between two DataTables
     * @param dataset The dataset to compare buckets with
     * @return true if the bucket is same
     */
    public boolean isCompatible(DataTable dataset) {
        if (dataset == null) {
            return false;
        }
        
        // Check if buckets match
        return Objects.equals(this.buckets, dataset.getBuckets());
    }
}