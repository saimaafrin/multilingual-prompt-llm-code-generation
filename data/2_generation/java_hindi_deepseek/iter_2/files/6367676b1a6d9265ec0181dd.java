public class StringUtils {
    /**
     * स्ट्रिंग {@code str} में उपस्ट्रिंग {@code sub} की उपस्थिति की संख्या लौटाता है।
     * @param str वह स्ट्रिंग जिसमें खोज करनी है। यदि यह null है तो 0 लौटाएं।
     * @param sub वह स्ट्रिंग जिसे खोजा जाना है। यदि यह null है तो 0 लौटाएं।
     * @return स्ट्रिंग {@code str} में उपस्ट्रिंग {@code sub} की उपस्थिति की संख्या।
     */
    public static int countOccurrencesOf(String str, String sub) {
        if (str == null || sub == null || str.isEmpty() || sub.isEmpty()) {
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
        // Test cases
        System.out.println(countOccurrencesOf("ababababab", "ab")); // 5
        System.out.println(countOccurrencesOf("hello world", "o")); // 2
        System.out.println(countOccurrencesOf(null, "abc")); // 0
        System.out.println(countOccurrencesOf("abc", null)); // 0
        System.out.println(countOccurrencesOf("", "abc")); // 0
        System.out.println(countOccurrencesOf("abc", "")); // 0
    }
}