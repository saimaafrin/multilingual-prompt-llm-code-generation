import java.util.HashSet;
import java.util.Set;

public class CustomSet {
    private Set<Integer> set;

    public CustomSet() {
        this.set = new HashSet<>();
    }

    /**
     * Inserts a value to the set. Returns true if the set did not already contain the specified element.
     */
    public boolean insert(int val) {
        return set.add(val);
    }
}