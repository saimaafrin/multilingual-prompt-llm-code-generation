import java.util.Collection;

public class InstanceChecker {
    /** 
     * 检查给定的集合是否包含给定的元素实例。<p>此方法要求集合中存在该具体实例，而不仅仅是一个相等的元素。
     * @param collection 要检查的集合
     * @param element 要查找的元素
     * @return 如果找到则返回 <code>true</code>，否则返回 <code>false</code>
     */
    public static boolean containsInstance(Collection collection, Object element) {
        for (Object obj : collection) {
            if (obj == element) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        // Example usage
        Collection<Object> myCollection = new java.util.ArrayList<>();
        String str1 = new String("Hello");
        String str2 = new String("Hello");
        myCollection.add(str1);

        System.out.println(containsInstance(myCollection, str1)); // true
        System.out.println(containsInstance(myCollection, str2)); // false
    }
}