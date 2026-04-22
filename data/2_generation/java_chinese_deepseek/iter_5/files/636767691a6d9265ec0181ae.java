import java.util.Enumeration;
import java.util.ArrayList;
import java.util.List;

public class EnumerationUtils {

    /**
     * 将给定的枚举值复制到字符串数组中。枚举值必须仅包含字符串元素。
     * @param enumeration 要复制的枚举值
     * @return 字符串数组（如果传入的枚举为 <code>null</code>，则返回 <code>null</code>）
     */
    public static String[] toStringArray(Enumeration<String> enumeration) {
        if (enumeration == null) {
            return null;
        }

        List<String> list = new ArrayList<>();
        while (enumeration.hasMoreElements()) {
            list.add(enumeration.nextElement());
        }

        return list.toArray(new String[0]);
    }
}