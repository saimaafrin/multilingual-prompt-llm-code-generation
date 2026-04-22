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
    
    public int getBucket() {
        return bucket;
    }
    
    public void setBucket(int bucket) {
        this.bucket = bucket;
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DataTable dataTable = (DataTable) o;
        return bucket == dataTable.bucket;
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(bucket);
    }
}