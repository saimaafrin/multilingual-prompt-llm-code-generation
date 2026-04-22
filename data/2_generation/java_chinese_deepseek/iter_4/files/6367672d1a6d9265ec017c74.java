import java.util.HashSet;
import java.util.Set;

public class CollectionRemover {
    private Set<Integer> set;

    public CollectionRemover() {
        this.set = new HashSet<>();
    }

    /**
     * 从集合中移除一个值。如果集合中包含指定的元素，则返回真。
     * @param val 要移除的值
     * @return 如果集合中包含指定的元素，则返回真；否则返回假
     */
    public boolean remove(int val) {
        return set.remove(val);
    }

    // 可选：添加一个方法来向集合中添加元素
    public void add(int val) {
        set.add(val);
    }

    // 可选：添加一个方法来检查集合是否包含某个元素
    public boolean contains(int val) {
        return set.contains(val);
    }
}