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

    // Optional: Method to add elements to the set for testing
    public void add(int val) {
        set.add(val);
    }

    public static void main(String[] args) {
        CollectionRemover remover = new CollectionRemover();
        remover.add(10);
        remover.add(20);
        remover.add(30);

        System.out.println(remover.remove(20)); // true
        System.out.println(remover.remove(40)); // false
    }
}