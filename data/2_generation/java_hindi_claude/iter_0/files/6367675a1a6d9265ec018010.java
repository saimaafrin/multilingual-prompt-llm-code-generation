import java.util.ArrayList;
import java.util.List;

public class Bucket {
    private List<Object> items;
    private boolean isRemoved;

    public Bucket() {
        items = new ArrayList<>();
        isRemoved = false;
    }

    /**
     * Removes this bucket from the data structure.
     */
    public void remove() {
        items.clear();
        isRemoved = true;
    }
}