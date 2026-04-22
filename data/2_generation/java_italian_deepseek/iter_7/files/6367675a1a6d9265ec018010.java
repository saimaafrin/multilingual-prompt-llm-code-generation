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
        // Clear the list of buckets this bucket is associated with
        buckets.clear();
    }

    @Override
    public String toString() {
        return "Bucket{" +
                "name='" + name + '\'' +
                '}';
    }

    public static void main(String[] args) {
        Bucket bucket1 = new Bucket("Bucket1");
        Bucket bucket2 = new Bucket("Bucket2");

        bucket1.addBucket(bucket2);
        System.out.println("Before removal: " + bucket2.buckets);
        bucket2.removeSelf();
        System.out.println("After removal: " + bucket2.buckets);
    }
}