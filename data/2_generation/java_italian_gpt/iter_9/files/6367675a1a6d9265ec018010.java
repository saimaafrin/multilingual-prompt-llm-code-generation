public class Bucket {
    // Assuming there is a structure to hold the buckets, e.g., a list or a map
    private static List<Bucket> bucketList = new ArrayList<>();

    public void removeSelf() {
        // Remove this bucket from the bucketList
        bucketList.remove(this);
    }

    // Method to add a bucket to the list for demonstration purposes
    public static void addBucket(Bucket bucket) {
        bucketList.add(bucket);
    }

    // Main method for testing
    public static void main(String[] args) {
        Bucket bucket1 = new Bucket();
        Bucket bucket2 = new Bucket();
        
        addBucket(bucket1);
        addBucket(bucket2);
        
        System.out.println("Buckets before removal: " + bucketList.size()); // Should print 2
        
        bucket1.removeSelf();
        
        System.out.println("Buckets after removal: " + bucketList.size()); // Should print 1
    }
}