import java.util.Objects;

public class DataTableComparator {
    
    private DataTable currentTable;
    
    /**
     * Checks if two DataTables have compatible bucket structures
     * @param dataset The DataTable to compare with
     * @return true if the bucket is the same
     */
    public boolean isCompatible(DataTable dataset) {
        if (dataset == null) {
            return false;
        }
        
        if (this.currentTable == null) {
            return false;
        }
        
        return Objects.equals(this.currentTable.getBucket(), dataset.getBucket());
    }
}