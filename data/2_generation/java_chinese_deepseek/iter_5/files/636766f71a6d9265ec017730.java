import java.util.Collection;
import java.util.ArrayList;
import java.util.Iterator;

public class CollectionUtils {

    /**
     * 将给定的集合转换为字符串数组。返回的数组不包含 <code>null</code> 条目。请注意，{@link Arrays#sort(Object[])} 如果数组元素为 <code>null</code> 将抛出 {@link NullPointerException}。
     * @param collection 要转换的集合
     * @return 一个新的字符串数组。
     */
    static String[] toNoNullStringArray(Collection<?> collection) {
        if (collection == null) {
            return new String[0];
        }

        // 过滤掉 null 元素
        ArrayList<String> filteredList = new ArrayList<>();
        Iterator<?> iterator = collection.iterator();
        while (iterator.hasNext()) {
            Object element = iterator.next();
            if (element != null) {
                filteredList.add(element.toString());
            }
        }

        // 转换为数组
        String[] result = new String[filteredList.size()];
        for (int i = 0; i < filteredList.size(); i++) {
            result[i] = filteredList.get(i);
        }

        return result;
    }
}