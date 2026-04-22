import java.util.Objects;

public class StringArrayUtils {

    /**
     * 此方法创建提供数组的一个副本，并确保新创建的数组中的所有字符串仅包含小写字母。
     * 使用此方法复制字符串数组意味着对源数组的更改不会修改目标数组。
     *
     * @param src 源字符串数组
     * @return 包含小写字母的新字符串数组副本
     */
    private static String[] copyStrings(final String[] src) {
        // Handle null input
        if (src == null) {
            return null;
        }

        // Create new array with same length
        String[] dest = new String[src.length];

        // Copy and convert each string to lowercase
        for (int i = 0; i < src.length; i++) {
            dest[i] = src[i] == null ? null : src[i].toLowerCase();
        }

        return dest;
    }
}