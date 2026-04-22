import java.util.Objects;

public class BucketComparator {
    
    private String bucketName;
    private String bucketRegion;
    
    public BucketComparator(String name, String region) {
        this.bucketName = name;
        this.bucketRegion = region;
    }

    /**
     * @return true if the bucket is same.
     */
    public boolean isSameBucket(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        
        BucketComparator other = (BucketComparator) obj;
        return Objects.equals(bucketName, other.bucketName) && 
               Objects.equals(bucketRegion, other.bucketRegion);
    }
}