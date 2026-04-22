import java.util.*;

class Bucket {
    private List<Bucket> buckets;

    public Bucket() {
        this.buckets = new ArrayList<>();
    }

    public void addBucket(Bucket bucket) {
        this.buckets.add(bucket);
    }

    /**
     * Rimuove questo bucket dalla struttura dati.
     */
    public void removeSelf() {
        for (Bucket bucket : buckets) {
            bucket.buckets.remove(this);
        }
        this.buckets.clear();
    }
}