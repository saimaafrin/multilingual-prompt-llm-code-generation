import java.util.*;

class Bucket {
    private List<Bucket> bucketList;

    public Bucket(List<Bucket> bucketList) {
        this.bucketList = bucketList;
    }

    /**
     * Rimuove questo bucket dalla struttura dati.
     */
    void removeSelf() {
        if (bucketList != null) {
            bucketList.remove(this);
        }
    }

    public static void main(String[] args) {
        List<Bucket> buckets = new ArrayList<>();
        Bucket bucket1 = new Bucket(buckets);
        Bucket bucket2 = new Bucket(buckets);

        buckets.add(bucket1);
        buckets.add(bucket2);

        System.out.println("Before removal: " + buckets.size()); // Output: 2
        bucket1.removeSelf();
        System.out.println("After removal: " + buckets.size());  // Output: 1
    }
}