import java.util.Objects;

public class DataTableComparator {
    
    private DataTable bucket;
    
    /**
     * @return verdadero si el bucket es el mismo.
     */
    public boolean isCompatible(DataTable dataset) {
        if (dataset == null) {
            return false;
        }
        
        return Objects.equals(this.bucket, dataset.getBucket());
    }
}