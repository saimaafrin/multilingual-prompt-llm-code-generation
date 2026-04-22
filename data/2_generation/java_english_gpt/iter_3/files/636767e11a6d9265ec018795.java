import java.util.Objects;

public class DataTable {
    // Assuming DataTable has some properties to define its structure
    private String name;
    private int size;

    public DataTable(String name, int size) {
        this.name = name;
        this.size = size;
    }

    public String getName() {
        return name;
    }

    public int getSize() {
        return size;
    }

    /**
     * @return true if the bucket is same.
     */
    public boolean isCompatible(DataTable dataset) {
        if (dataset == null) {
            return false;
        }
        return Objects.equals(this.name, dataset.getName()) && this.size == dataset.getSize();
    }
}