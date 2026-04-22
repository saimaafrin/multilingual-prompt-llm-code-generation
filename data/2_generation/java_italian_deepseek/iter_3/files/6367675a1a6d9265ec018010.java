import java.util.*;

class Bucket {
    private Set<Bucket> bucketSet;

    public Bucket(Set<Bucket> bucketSet) {
        this.bucketSet = bucketSet;
    }

    /**
     * Rimuove questo bucket dalla struttura dati.
     */
    void removeSelf() {
        if (bucketSet != null) {
            bucketSet.remove(this);
        }
    }

    public static void main(String[] args) {
        Set<Bucket> buckets = new HashSet<>();
        Bucket bucket = new Bucket(buckets);
        buckets.add(bucket);

        System.out.println("Before removal: " + buckets.size()); // Output: 1
        bucket.removeSelf();
        System.out.println("After removal: " + buckets.size()); // Output: 0
    }
}