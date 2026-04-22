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
        // Clear the data in the bucket
        data.clear();
        // Optionally, you can also set the reference to null if needed
        // data = null;
    }

    public List<Object> getData() {
        return data;
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