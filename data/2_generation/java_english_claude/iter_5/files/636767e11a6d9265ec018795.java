import java.util.Objects;

public class DataTableUtils {
    private List<String> buckets;
    
    /**
     * Checks if the bucket is compatible with the given dataset
     * @param dataset The dataset to compare buckets with
     * @return true if the bucket is same
     */
    public boolean isCompatible(DataTable dataset) {
        if (dataset == null) {
            return false;
        }
        
        // Compare buckets
        return Objects.equals(this.buckets, dataset.getBuckets());
    }
}