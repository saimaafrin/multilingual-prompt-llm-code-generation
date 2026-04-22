public class StringUtils {
    /**
     * 从给定的字符串中修剪所有出现的指定前导字符。
     * @param str 要检查的字符串
     * @param leadingCharacter 要修剪的前导字符
     * @return 修剪后的字符串
     */
    public static String trimLeadingCharacter(String str, char leadingCharacter) {
        if (str == null || str.isEmpty()) {
            return str;
        }

        int start = 0;
        while (start < str.length() && str.charAt(start) == leadingCharacter) {
            start++;
        }

        return str.substring(start);
    }
}