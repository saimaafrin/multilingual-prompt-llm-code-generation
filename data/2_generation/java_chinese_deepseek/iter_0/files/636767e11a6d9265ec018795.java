import java.util.Objects;

public class DataTable {
    // Assuming DataTable class has necessary fields and methods
    // For example, let's assume it has a field 'bucket' to represent the bucket
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
     * @param dataset The dataset to compare with.
     * @return 如果桶相同则返回真。
     */
    public boolean isCompatible(DataTable dataset) {
        // Assuming 'this' refers to another DataTable instance
        // For example, let's assume 'this' is another DataTable instance
        DataTable currentDataset = new DataTable("exampleBucket"); // Replace with actual instance
        return currentDataset.equals(dataset);
    }

    public static void main(String[] args) {
        Main main = new Main();
        DataTable dataset1 = new DataTable("exampleBucket");
        DataTable dataset2 = new DataTable("differentBucket");

        System.out.println(main.isCompatible(dataset1)); // Should print true if buckets are the same
        System.out.println(main.isCompatible(dataset2)); // Should print false if buckets are different
    }
}