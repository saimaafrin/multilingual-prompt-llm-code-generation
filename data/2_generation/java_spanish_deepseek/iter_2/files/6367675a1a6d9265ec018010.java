import java.util.*;

class Bucket {
    private List<Bucket> buckets;

    public Bucket() {
        this.buckets = new ArrayList<>();
    }

    public void addBucket(Bucket bucket) {
        this.buckets.add(bucket);
    }

    public void removeSelf() {
        // Remove this bucket from all other buckets that reference it
        for (Bucket bucket : buckets) {
            bucket.buckets.remove(this);
        }
        // Clear the list of buckets this bucket references
        this.buckets.clear();
    }

    public static void main(String[] args) {
        Bucket bucket1 = new Bucket();
        Bucket bucket2 = new Bucket();
        Bucket bucket3 = new Bucket();

        bucket1.addBucket(bucket2);
        bucket2.addBucket(bucket3);
        bucket3.addBucket(bucket1);

        System.out.println("Before removal:");
        System.out.println("Bucket1 references: " + bucket1.buckets.size());
        System.out.println("Bucket2 references: " + bucket2.buckets.size());
        System.out.println("Bucket3 references: " + bucket3.buckets.size());

        bucket2.removeSelf();

        System.out.println("After removal:");
        System.out.println("Bucket1 references: " + bucket1.buckets.size());
        System.out.println("Bucket2 references: " + bucket2.buckets.size());
        System.out.println("Bucket3 references: " + bucket3.buckets.size());
    }
}