import java.util.ArrayList;
import java.util.Collection;

public class CollectionToStringArray {

    /** 
     * 将给定的集合转换为字符串数组。返回的数组不包含 <code>null</code> 条目。请注意，{@link Arrays#sort(Object[])} 如果数组元素为 <code>null</code> 将抛出 {@link NullPointerException}。
     * @param collection 要转换的集合
     * @return 一个新的字符串数组。
     */
    static String[] toNoNullStringArray(Collection<?> collection) {
        if (collection == null) {
            return new String[0];
        }
        
        ArrayList<String> list = new ArrayList<>();
        for (Object obj : collection) {
            if (obj != null) {
                list.add(obj.toString());
            }
        }
        
        return list.toArray(new String[0]);
    }

    public static void main(String[] args) {
        // Example usage
        Collection<Object> collection = new ArrayList<>();
        collection.add("Hello");
        collection.add(null);
        collection.add("World");
        
        String[] result = toNoNullStringArray(collection);
        for (String str : result) {
            System.out.println(str);
        }
    }
}