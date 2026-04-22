import java.util.Objects;

public class DataTable {
    // Assuming DataTable has some properties to define its structure
    private String name;
    private int[] data;

    public DataTable(String name, int[] data) {
        this.name = name;
        this.data = data;
    }

    public String getName() {
        return name;
    }

    public int[] getData() {
        return data;
    }

    /**
     * @return true if the bucket is same.
     */
    public boolean isCompatible(DataTable dataset) {
        if (dataset == null) {
            return false;
        }
        return Objects.equals(this.name, dataset.getName()) && 
               this.data.length == dataset.getData().length;
    }
}