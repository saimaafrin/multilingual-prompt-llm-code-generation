public class StringUtils {
    /**
     * Returns the number of occurrences the substring {@code sub} appears in string {@code str}.
     * @param str string to search in. Return 0 if this is null.
     * @param sub string to search for. Return 0 if this is null.
     * @return the number of occurrences the substring {@code sub} appears in string {@code str}.
     */
    public static int countOccurrencesOf(String str, String sub) {
        if (str == null || sub == null || sub.length() == 0) {
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