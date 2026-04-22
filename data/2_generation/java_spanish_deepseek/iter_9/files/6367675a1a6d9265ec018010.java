import java.util.*;

class Bucket {
    private String name;
    private List<Bucket> buckets;

    public Bucket(String name) {
        this.name = name;
        this.buckets = new ArrayList<>();
    }

    public void addBucket(Bucket bucket) {
        this.buckets.add(bucket);
    }

    public void removeSelf() {
        // Assuming this bucket is part of a larger structure, we need to remove it from its parent.
        // This is a simplified example where we assume the parent is managing the list of buckets.
        // In a real-world scenario, you would need to handle the parent reference.
        for (Bucket bucket : buckets) {
            bucket.removeSelf();
        }
        // Clear the list of buckets
        buckets.clear();
        // Additional cleanup if needed
    }

    public static void main(String[] args) {
        Bucket parentBucket = new Bucket("Parent");
        Bucket childBucket = new Bucket("Child");
        parentBucket.addBucket(childBucket);

        System.out.println("Before removal:");
        System.out.println("Parent has " + parentBucket.buckets.size() + " buckets.");

        childBucket.removeSelf();

        System.out.println("After removal:");
        System.out.println("Parent has " + parentBucket.buckets.size() + " buckets.");
    }
}