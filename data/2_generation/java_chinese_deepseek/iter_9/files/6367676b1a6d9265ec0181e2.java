import java.util.Collection;
import java.util.Iterator;

public class CollectionUtils {
    /**
     * 返回在 '<code>source</code>' 中包含的 '<code>candidates</code>' 的第一个元素。如果 '<code>candidates</code>' 中没有任何元素出现在 '<code>source</code>' 中，则返回 <code>null</code>。迭代顺序取决于 {@link Collection} 的具体实现。
     * @param source 源集合
     * @param candidates 要搜索的候选项
     * @return 第一个匹配的对象，如果未找到则返回 <code>null</code>
     */
    public static Object findFirstMatch(Collection source, Collection candidates) {
        if (source == null || candidates == null) {
            return null;
        }

        for (Object candidate : candidates) {
            if (source.contains(candidate)) {
                return candidate;
            }
        }

        return null;
    }
}