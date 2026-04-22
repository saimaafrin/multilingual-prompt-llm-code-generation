public class Bucket {
    // Assuming there is a data structure that holds the buckets
    private static List<Bucket> bucketList = new ArrayList<>();

    public void removeSelf() {
        // Remove this bucket from the bucketList
        bucketList.remove(this);
    }
}