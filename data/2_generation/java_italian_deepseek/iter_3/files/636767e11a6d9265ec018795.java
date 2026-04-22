import java.util.Objects;

public class DataTable {
    // Assuming DataTable class has some fields and methods
    // For the purpose of this example, let's assume it has a field called 'bucket'
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
    public static boolean isCompatible(DataTable dataset) {
        // Assuming 'this' refers to another DataTable instance
        // For the purpose of this example, let's assume we have a reference to another DataTable
        DataTable otherDataset = new DataTable("exampleBucket");

        return dataset.equals(otherDataset);
    }

    public static void main(String[] args) {
        DataTable dataset = new DataTable("exampleBucket");
        System.out.println(isCompatible(dataset)); // Should print true if buckets are the same
    }
}