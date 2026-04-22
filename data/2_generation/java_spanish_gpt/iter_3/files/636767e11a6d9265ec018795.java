public class DataTable {
    private String bucketName;

    public DataTable(String bucketName) {
        this.bucketName = bucketName;
    }

    public String getBucketName() {
        return bucketName;
    }
}

public class CompatibilityChecker {
    private String bucketName;

    public CompatibilityChecker(String bucketName) {
        this.bucketName = bucketName;
    }

    /** 
     * @return verdadero si el bucket es el mismo.
     */
    public boolean isCompatible(DataTable dataset) {
        return this.bucketName.equals(dataset.getBucketName());
    }

    public static void main(String[] args) {
        CompatibilityChecker checker = new CompatibilityChecker("bucket1");
        DataTable dataset = new DataTable("bucket1");
        
        System.out.println(checker.isCompatible(dataset)); // Should print true
    }
}