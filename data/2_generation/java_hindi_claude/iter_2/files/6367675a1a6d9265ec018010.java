import java.util.ArrayList;
import java.util.List;

public class Bucket {
    private List<Object> items;
    private boolean removed;

    public Bucket() {
        items = new ArrayList<>();
        removed = false;
    }

    /**
     * Removes this bucket from the data structure.
     */
    public void remove() {
        items.clear();
        removed = true;
    }
}