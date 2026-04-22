public class StringUtils {
    /**
     * Returns the number of occurrences the substring  {@code sub} appears in string {@code str}.
     * @param str string to search in. Return 0 if this is null.
     * @param sub string to search for. Return 0 if this is null.
     * @return the number of occurrences the substring {@code sub} appears in string {@code str}.
     */
    public static int countOccurrencesOf(String str, String sub) {
        if (str == null || sub == null || sub.isEmpty()) {
            return 0;
        }
        
        int count = 0;
        int index = 0;
        while ((index = str.indexOf(sub, index)) != -1) {
            count++;
            index += sub.length();
        }
        return count;
    }

    public static void main(String[] args) {
        // Example usage
        String str = "hello world, hello universe";
        String sub = "hello";
        System.out.println(countOccurrencesOf(str, sub)); // Output: 2
    }
}