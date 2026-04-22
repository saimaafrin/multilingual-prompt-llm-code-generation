import java.util.Objects;

public class DataTable {
    // Assuming DataTable class has necessary fields and methods
    // For example, let's assume it has a field 'bucket'
    private String bucket;

    public DataTable(String bucket) {
        this.bucket = bucket;
    }

    public String getBucket() {
        return bucket;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DataTable dataTable = (DataTable) o;
        return Objects.equals(bucket, dataTable.bucket);
    }

    @Override
    public int hashCode() {
        return Objects.hash(bucket);
    }
}

public class Main {
    /**
     * @return true if the bucket is same.
     */
    public boolean isCompatible(DataTable dataset) {
        // Assuming 'this' refers to another DataTable object
        // For simplicity, let's assume 'this' is another DataTable object
        // with a 'bucket' field
        return this.getBucket().equals(dataset.getBucket());
    }

    public static void main(String[] args) {
        DataTable dataset1 = new DataTable("bucket1");
        DataTable dataset2 = new DataTable("bucket1");
        DataTable dataset3 = new DataTable("bucket2");

        Main main = new Main();
        System.out.println(main.isCompatible(dataset1, dataset2)); // true
        System.out.println(main.isCompatible(dataset1, dataset3)); // false
    }

    // Overloaded method to compare two DataTable objects
    public boolean isCompatible(DataTable dataset1, DataTable dataset2) {
        return dataset1.getBucket().equals(dataset2.getBucket());
    }
}