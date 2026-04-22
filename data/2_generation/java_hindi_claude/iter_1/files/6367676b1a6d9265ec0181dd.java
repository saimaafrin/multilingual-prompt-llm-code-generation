public class StringUtils {
    /**
     * Returns the number of occurrences the substring {@code sub} appears in string {@code str}.
     * @param str string to search in. Return 0 if this is null.
     * @param sub string to search for. Return 0 if this is null.
     * @return the number of occurrences the substring {@code sub} appears in string {@code str}.
     */
    public static int countOccurrences(String str, String sub) {
        if (str == null || sub == null || sub.isEmpty()) {
            return 0;
        }

        int count = 0;
        int lastIndex = 0;

        while (lastIndex != -1) {
            lastIndex = str.indexOf(sub, lastIndex);
            if (lastIndex != -1) {
                count++;
                lastIndex += 1;
            }
        }

        return count;
    }
}