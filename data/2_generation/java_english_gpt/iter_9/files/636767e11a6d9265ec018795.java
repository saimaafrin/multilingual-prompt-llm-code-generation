public class DataTable {
    // Assuming DataTable has some properties to compare
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

    // Other methods and properties of DataTable
}

public class Bucket {
    private DataTable dataTable;

    public Bucket(DataTable dataTable) {
        this.dataTable = dataTable;
    }

    /**
     * @return true if the bucket is same.
     */
    public boolean isCompatible(DataTable dataset) {
        if (dataset == null) {
            return false;
        }
        return this.dataTable.getName().equals(dataset.getName()) &&
               this.dataTable.getSize() == dataset.getSize();
    }
}