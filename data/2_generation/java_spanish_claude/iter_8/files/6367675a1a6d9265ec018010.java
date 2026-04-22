import java.util.ArrayList;
import java.util.List;

public class Bucket<T> {
    private List<T> elements;
    private BucketCollection<T> collection;

    public Bucket(BucketCollection<T> collection) {
        this.elements = new ArrayList<>();
        this.collection = collection;
    }

    /**
     * Elimina este bucket de la estructura de datos.
     */
    public void removeSelf() {
        if (collection != null) {
            collection.removeBucket(this);
            elements.clear();
            collection = null;
        }
    }
}

// Helper class to demonstrate bucket collection
class BucketCollection<T> {
    private List<Bucket<T>> buckets;

    public BucketCollection() {
        buckets = new ArrayList<>();
    }

    public void removeBucket(Bucket<T> bucket) {
        buckets.remove(bucket);
    }
}