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
        // Assuming the bucket is part of a larger structure, we need to remove it from its parent.
        // This is a simplified example where we assume the bucket is part of a list in a parent bucket.
        // In a real-world scenario, you would need to handle the parent reference.
        for (Bucket bucket : buckets) {
            if (bucket == this) {
                buckets.remove(this);
                break;
            }
        }
    }

    @Override
    public String toString() {
        return "Bucket{" +
                "name='" + name + '\'' +
                '}';
    }

    public static void main(String[] args) {
        Bucket parentBucket = new Bucket("Parent");
        Bucket childBucket = new Bucket("Child");
        parentBucket.addBucket(childBucket);

        System.out.println("Before removal: " + parentBucket.buckets);
        childBucket.removeSelf();
        System.out.println("After removal: " + parentBucket.buckets);
    }
}