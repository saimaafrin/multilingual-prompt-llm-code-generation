import java.util.*;

class Bucket {
    private List<Bucket> buckets;

    public Bucket(List<Bucket> buckets) {
        this.buckets = buckets;
    }

    /**
     * Removes this bucket from the data structure.
     */
    void removeSelf() {
        if (buckets != null) {
            buckets.remove(this);
        }
    }
}