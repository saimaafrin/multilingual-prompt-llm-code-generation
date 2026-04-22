import java.util.Collection;

public class CollectionUtils {

    /**
     * 从集合中移除一个值。如果集合中包含指定的元素，则返回真。
     *
     * @param collection 要操作的集合
     * @param val 要移除的值
     * @return 如果集合中包含指定的元素，则返回真
     */
    public static boolean remove(Collection<Integer> collection, int val) {
        return collection.remove(Integer.valueOf(val));
    }
}