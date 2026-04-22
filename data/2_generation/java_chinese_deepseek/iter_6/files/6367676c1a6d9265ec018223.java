import java.util.Collection;

public class CollectionUtils {

    /**
     * 检查给定的集合是否包含给定的元素实例。<p>此方法要求集合中存在该具体实例，而不仅仅是一个相等的元素。
     * @param collection 要检查的集合
     * @param element 要查找的元素
     * @return 如果找到则返回 <code>true</code>，否则返回 <code>false</code>
     */
    public static boolean containsInstance(Collection<?> collection, Object element) {
        if (collection == null || element == null) {
            return false;
        }
        for (Object item : collection) {
            if (item == element) {
                return true;
            }
        }
        return false;
    }
}