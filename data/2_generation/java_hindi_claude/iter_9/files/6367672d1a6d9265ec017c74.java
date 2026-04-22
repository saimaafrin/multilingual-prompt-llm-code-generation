import java.util.HashSet;
import java.util.Set;

public class Solution {
    private Set<Integer> set;
    
    public Solution() {
        set = new HashSet<>();
    }
    
    /**
     * Removes a value from the set. Returns true if the set contained the specified element.
     */
    public boolean remove(int val) {
        return set.remove(val);
    }
}