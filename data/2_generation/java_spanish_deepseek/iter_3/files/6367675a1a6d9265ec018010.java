import java.util.*;

class Bucket {
    private String name;
    private List<Bucket> buckets;

    public Bucket(String name) {
        this.name = name;
        this.buckets = new ArrayList<>();
    }

    public void addBucket(Bucket bucket) {
        buckets.add(bucket);
    }

    public void removeSelf() {
        // Remove this bucket from all parent buckets
        for (Bucket parent : buckets) {
            parent.buckets.remove(this);
        }
        // Clear the list of buckets
        buckets.clear();
    }

    public static void main(String[] args) {
        Bucket bucket1 = new Bucket("Bucket1");
        Bucket bucket2 = new Bucket("Bucket2");

        bucket1.addBucket(bucket2);
        bucket2.addBucket(bucket1);

        System.out.println("Before removal:");
        System.out.println("Bucket1 contains Bucket2: " + bucket1.buckets.contains(bucket2));
        System.out.println("Bucket2 contains Bucket1: " + bucket2.buckets.contains(bucket1));

        bucket1.removeSelf();

        System.out.println("After removal:");
        System.out.println("Bucket1 contains Bucket2: " + bucket1.buckets.contains(bucket2));
        System.out.println("Bucket2 contains Bucket1: " + bucket2.buckets.contains(bucket1));
    }
}