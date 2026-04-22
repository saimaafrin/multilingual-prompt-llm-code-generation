import java.util.Objects;

public class DataTable {
    // Assuming DataTable has some fields and methods
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
     * @return verdadero si el bucket es el mismo.
     */
    public boolean isCompatible(DataTable dataset) {
        // Assuming 'this' refers to another DataTable instance
        // For example, let's assume 'this' has a field 'bucket'
        String thisBucket = this.getBucket();
        String otherBucket = dataset.getBucket();
        return thisBucket.equals(otherBucket);
    }

    public static void main(String[] args) {
        DataTable table1 = new DataTable("bucket1");
        DataTable table2 = new DataTable("bucket1");
        DataTable table3 = new DataTable("bucket2");

        Main main = new Main();
        System.out.println(main.isCompatible(table2)); // true
        System.out.println(main.isCompatible(table3)); // false
    }
}