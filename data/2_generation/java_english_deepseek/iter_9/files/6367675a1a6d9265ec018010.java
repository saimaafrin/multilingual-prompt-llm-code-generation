import java.util.*;

class Bucket {
    private Set<Bucket> bucketSet;

    public Bucket(Set<Bucket> bucketSet) {
        this.bucketSet = bucketSet;
    }

    /**
     * Removes this bucket from the data structure.
     */
    void removeSelf() {
        if (bucketSet != null) {
            bucketSet.remove(this);
        }
    }
}