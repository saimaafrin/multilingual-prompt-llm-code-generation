import java.util.HashSet;

public class Solution {
    private HashSet<Integer> set;
    
    public Solution() {
        set = new HashSet<>();
    }
    
    public boolean insert(int val) {
        return set.add(val);
    }
}