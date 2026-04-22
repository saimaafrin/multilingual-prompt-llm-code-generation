import java.util.HashSet;

public class Solution {
    private HashSet<Integer> set;
    
    public Solution() {
        set = new HashSet<>();
    }
    
    /** 
     * Inserts a value to the set. Returns true if the set did not already contain the specified element. 
     */
    public boolean insert(int val) {
        return set.add(val);
    }
}