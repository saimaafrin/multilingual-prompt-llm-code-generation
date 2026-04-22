public class StringUtils {
    /**
     * 返回子字符串 {@code sub} 在字符串 {@code str} 中出现的次数。
     * @param str 要搜索的字符串。如果为空，则返回 0。
     * @param sub 要搜索的子字符串。如果为空，则返回 0。
     * @return 子字符串 {@code sub} 在字符串 {@code str} 中出现的次数。
     */
    public static int countOccurrencesOf(String str, String sub) {
        if (str == null || sub == null || str.isEmpty() || sub.isEmpty()) {
            return 0;
        }

        int count = 0;
        int pos = 0;
        int idx;
        
        while ((idx = str.indexOf(sub, pos)) != -1) {
            count++;
            pos = idx + sub.length();
        }
        
        return count;
    }
}