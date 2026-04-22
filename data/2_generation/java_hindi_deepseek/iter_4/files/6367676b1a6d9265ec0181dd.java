public class StringUtils {
    /**
     * स्ट्रिंग {@code str} में उपस्ट्रिंग {@code sub} की उपस्थिति की संख्या लौटाता है।
     * @param str वह स्ट्रिंग जिसमें खोज करनी है। यदि यह null है तो 0 लौटाएं।
     * @param sub वह स्ट्रिंग जिसे खोजा जाना है। यदि यह null है तो 0 लौटाएं।
     * @return स्ट्रिंग {@code str} में उपस्ट्रिंग {@code sub} की उपस्थिति की संख्या।
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
        String str = "ababababab";
        String sub = "ab";
        System.out.println(countOccurrencesOf(str, sub)); // Output: 5
    }
}