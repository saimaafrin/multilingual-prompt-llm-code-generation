import java.util.Objects;

public class DataTableComparator {
    
    private DataTable currentTable;
    
    /**
     * Checks if two DataTables have compatible bucket structures
     * @param dataset The DataTable to compare with
     * @return true if the bucket structure is the same
     */
    public boolean isCompatible(DataTable dataset) {
        if (dataset == null) {
            return false;
        }
        
        if (this.currentTable == null) {
            return false;
        }
        
        // Check if both tables reference the same object
        if (this.currentTable == dataset) {
            return true;
        }
        
        // Compare bucket properties
        return Objects.equals(this.currentTable.getBucket(), dataset.getBucket());
    }
}