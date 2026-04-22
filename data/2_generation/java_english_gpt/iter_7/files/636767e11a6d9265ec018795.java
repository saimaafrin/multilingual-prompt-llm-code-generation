import java.util.Objects;

public class DataTable {
    // Assuming DataTable has some properties to define its structure
    private String name;
    private int numberOfColumns;
    private int numberOfRows;

    public DataTable(String name, int numberOfColumns, int numberOfRows) {
        this.name = name;
        this.numberOfColumns = numberOfColumns;
        this.numberOfRows = numberOfRows;
    }

    // Getters for the properties
    public String getName() {
        return name;
    }

    public int getNumberOfColumns() {
        return numberOfColumns;
    }

    public int getNumberOfRows() {
        return numberOfRows;
    }

    /**
     * @return true if the bucket is same.
     */
    public boolean isCompatible(DataTable dataset) {
        if (dataset == null) {
            return false;
        }
        return this.numberOfColumns == dataset.getNumberOfColumns() &&
               this.numberOfRows == dataset.getNumberOfRows() &&
               Objects.equals(this.name, dataset.getName());
    }
}