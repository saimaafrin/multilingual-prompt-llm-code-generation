import java.util.HashSet;

public class Solution {
    private HashSet<Integer> set;
    
    public Solution() {
        set = new HashSet<>();
    }
    
    /**
     * 将一个值插入集合。如果集合中尚未包含指定元素，则返回真。
     */
    public boolean insert(int val) {
        return set.add(val);
    }
}