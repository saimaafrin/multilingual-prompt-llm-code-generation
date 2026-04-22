import java.util.Objects;

public class DataTable {
    private List<String> buckets;

    /**
     * Checks if two DataTable objects have the same buckets
     * @param dataset The DataTable to compare with
     * @return true if the buckets are the same, false otherwise
     */
    public boolean isCompatible(DataTable dataset) {
        if (dataset == null) {
            return false;
        }
        
        if (this == dataset) {
            return true;
        }

        if (this.buckets == null && dataset.buckets == null) {
            return true;
        }

        if (this.buckets == null || dataset.buckets == null) {
            return false;
        }

        return Objects.equals(this.buckets, dataset.buckets);
    }
}