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
        // Remove this bucket from its parent's list of buckets
        for (Bucket parent : buckets) {
            parent.buckets.remove(this);
        }
        // Clear the list of buckets to remove references to other buckets
        buckets.clear();
    }

    public static void main(String[] args) {
        Bucket parentBucket = new Bucket("Parent");
        Bucket childBucket = new Bucket("Child");

        parentBucket.addBucket(childBucket);
        System.out.println("Before removal: " + parentBucket.buckets.contains(childBucket));
        
        childBucket.removeSelf();
        System.out.println("After removal: " + parentBucket.buckets.contains(childBucket));
    }
}