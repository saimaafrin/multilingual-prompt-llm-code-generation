import java.util.*;

class Bucket {
    private List<Object> data;

    public Bucket() {
        this.data = new ArrayList<>();
    }

    public void add(Object item) {
        data.add(item);
    }

    public void removeSelf() {
        // Clear all data in the bucket
        data.clear();
    }

    public List<Object> getData() {
        return new ArrayList<>(data);
    }
}

// Example usage
public class Main {
    public static void main(String[] args) {
        Bucket bucket = new Bucket();
        bucket.add("Item1");
        bucket.add("Item2");

        System.out.println("Before removal: " + bucket.getData());
        bucket.removeSelf();
        System.out.println("After removal: " + bucket.getData());
    }
}