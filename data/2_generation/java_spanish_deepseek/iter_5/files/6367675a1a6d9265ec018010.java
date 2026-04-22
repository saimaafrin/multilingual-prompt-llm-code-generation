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
        // Clear the list of buckets to remove all references
        buckets.clear();
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