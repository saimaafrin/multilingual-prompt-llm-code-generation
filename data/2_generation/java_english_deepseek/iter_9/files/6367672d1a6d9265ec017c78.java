import java.util.HashSet;
import java.util.Set;

public class CustomSet {
    private Set<Integer> set;

    public CustomSet() {
        this.set = new HashSet<>();
    }

    /**
     * Inserts a value to the set. Returns true if the set did not already contain the specified element.
     * @param val the value to be inserted into the set
     * @return true if the set did not already contain the specified element, false otherwise
     */
    public boolean insert(int val) {
        return set.add(val);
    }
}