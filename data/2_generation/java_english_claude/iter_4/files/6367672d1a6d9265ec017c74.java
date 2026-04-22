import java.util.HashSet;

public class Solution {
    private HashSet<Integer> set;
    
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