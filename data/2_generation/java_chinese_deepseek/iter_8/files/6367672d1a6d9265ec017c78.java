import java.util.HashSet;
import java.util.Set;

public class InsertValue {
    private Set<Integer> set;

    public InsertValue() {
        this.set = new HashSet<>();
    }

    /**
     * 将一个值插入集合。如果集合中尚未包含指定元素，则返回真。
     */
    public boolean insert(int val) {
        if (set.contains(val)) {
            return false;
        } else {
            set.add(val);
            return true;
        }
    }
}