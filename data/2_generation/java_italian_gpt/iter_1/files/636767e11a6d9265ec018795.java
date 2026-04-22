public class DataTable {
    // Assuming DataTable has a method to get the bucket
    private String bucket;

    public DataTable(String bucket) {
        this.bucket = bucket;
    }

    public String getBucket() {
        return bucket;
    }
}

public class CompatibilityChecker {
    private String bucket;

    public CompatibilityChecker(String bucket) {
        this.bucket = bucket;
    }

    /** 
     * @return true se il bucket è lo stesso.
     */
    public boolean isCompatible(DataTable dataset) {
        return this.bucket.equals(dataset.getBucket());
    }

    public static void main(String[] args) {
        DataTable dataset1 = new DataTable("bucket1");
        DataTable dataset2 = new DataTable("bucket1");
        DataTable dataset3 = new DataTable("bucket2");

        CompatibilityChecker checker = new CompatibilityChecker("bucket1");

        System.out.println(checker.isCompatible(dataset1)); // true
        System.out.println(checker.isCompatible(dataset2)); // true
        System.out.println(checker.isCompatible(dataset3)); // false
    }
}