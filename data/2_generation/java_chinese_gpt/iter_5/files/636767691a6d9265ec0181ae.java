import java.util.Enumeration;
import java.util.Vector;

public class EnumToStringArray {

    /** 
     * 将给定的枚举值复制到字符串数组中。枚举值必须仅包含字符串元素。
     * @param enumeration 要复制的枚举值
     * @return 字符串数组（如果传入的枚举为 <code>null</code>，则返回 <code>null</code>）
     */
    public static String[] toStringArray(Enumeration<String> enumeration) {
        if (enumeration == null) {
            return null;
        }

        Vector<String> vector = new Vector<>();
        while (enumeration.hasMoreElements()) {
            vector.add(enumeration.nextElement());
        }

        return vector.toArray(new String[0]);
    }

    public static void main(String[] args) {
        // Example usage
        Vector<String> vector = new Vector<>();
        vector.add("One");
        vector.add("Two");
        vector.add("Three");
        
        Enumeration<String> enumeration = vector.elements();
        String[] result = toStringArray(enumeration);
        
        for (String str : result) {
            System.out.println(str);
        }
    }
}