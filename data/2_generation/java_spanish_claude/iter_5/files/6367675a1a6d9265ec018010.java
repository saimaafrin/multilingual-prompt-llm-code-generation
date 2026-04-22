import java.util.ArrayList;
import java.util.List;

public class Bucket<T> {
    private List<T> elements;
    private BucketCollection<T> parent;

    public Bucket(BucketCollection<T> parent) {
        this.elements = new ArrayList<>();
        this.parent = parent;
    }

    /**
     * Elimina este bucket de la estructura de datos.
     */
    public void removeSelf() {
        if (parent != null) {
            parent.removeBucket(this);
            parent = null;
        }
        elements.clear();
        elements = null;
    }
}

// Helper class to represent the collection that contains buckets
class BucketCollection<T> {
    private List<Bucket<T>> buckets;

    public BucketCollection() {
        buckets = new ArrayList<>();
    }

    public void removeBucket(Bucket<T> bucket) {
        buckets.remove(bucket);
    }
}