import java.util.HashSet;

public class MyCollection {
    private HashSet<Integer> set;

    public MyCollection() {
        set = new HashSet<>();
    }

    /**
     * 从集合中移除一个值。如果集合中包含指定的元素，则返回真。
     */
    public boolean remove(int val) {
        return set.remove(val);
    }

    public void add(int val) {
        set.add(val);
    }

    public boolean contains(int val) {
        return set.contains(val);
    }
}