import java.util.Objects;

public class BucketComparator {
    /**
     * @return true if the bucket is same.
     */
    public boolean isSameBucket(Object bucket1, Object bucket2) {
        if (bucket1 == null && bucket2 == null) {
            return true;
        }
        if (bucket1 == null || bucket2 == null) {
            return false;
        }
        return Objects.equals(bucket1, bucket2);
    }
}