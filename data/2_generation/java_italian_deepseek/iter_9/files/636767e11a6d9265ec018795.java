import java.util.Objects;

public class DataTable {
    // Assuming DataTable class has some fields and methods
    // For the purpose of this example, let's assume it has a field 'bucket'
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
     * @return true se il bucket è lo stesso.
     */
    public boolean isCompatible(DataTable dataset) {
        // Assuming 'this' refers to another DataTable object
        // For the purpose of this example, let's assume 'this' is a DataTable object
        // with a 'bucket' field
        return this.getBucket().equals(dataset.getBucket());
    }

    public static void main(String[] args) {
        DataTable dt1 = new DataTable("bucket1");
        DataTable dt2 = new DataTable("bucket1");
        DataTable dt3 = new DataTable("bucket2");

        Main main = new Main();
        System.out.println(main.isCompatible(dt1)); // true
        System.out.println(main.isCompatible(dt2)); // true
        System.out.println(main.isCompatible(dt3)); // false
    }
}