import java.util.HashSet;
import java.util.Set;

public class Solution {
    private Set<Integer> set;
    
    public Solution() {
        set = new HashSet<>();
    }
    
    public boolean remove(int val) {
        return set.remove(val);
    }
}