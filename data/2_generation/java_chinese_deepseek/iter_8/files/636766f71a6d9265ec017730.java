import java.util.Collection;
import java.util.ArrayList;
import java.util.List;

public class CollectionUtils {

    /**
     * 将给定的集合转换为字符串数组。返回的数组不包含 <code>null</code> 条目。请注意，{@link Arrays#sort(Object[])} 如果数组元素为 <code>null</code> 将抛出 {@link NullPointerException}。
     * @param collection 要转换的集合
     * @return 一个新的字符串数组。
     */
    public static String[] toNoNullStringArray(Collection<?> collection) {
        if (collection == null) {
            return new String[0];
        }

        List<String> nonNullList = new ArrayList<>();
        for (Object obj : collection) {
            if (obj != null) {
                nonNullList.add(obj.toString());
            }
        }

        return nonNullList.toArray(new String[0]);
    }
}