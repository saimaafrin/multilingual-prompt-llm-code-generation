public class StringUtils {

    /** 
     * यदि दिया गया स्ट्रिंग निर्दिष्ट केस-इंसेंसिटिव प्रीफिक्स से शुरू होता है, तो {@code true} लौटाता है, अन्यथा {@code false}।
     * @param str वह स्ट्रिंग जिसे जांचना है
     * @param prefix वह प्रीफिक्स जिसे खोजना है
     * @return {@code true} यदि दिया गया स्ट्रिंग निर्दिष्ट केस-इंसेंसिटिव प्रीफिक्स से शुरू होता है, अन्यथा {@code false}।
     * @see java.lang.String#startsWith
     */
    public static boolean startsWithIgnoreCase(String str, String prefix) {
        if (str == null || prefix == null) {
            return false;
        }
        if (prefix.length() > str.length()) {
            return false;
        }
        return str.substring(0, prefix.length()).equalsIgnoreCase(prefix);
    }

    public static void main(String[] args) {
        System.out.println(startsWithIgnoreCase("HelloWorld", "hello")); // true
        System.out.println(startsWithIgnoreCase("HelloWorld", "world")); // false
        System.out.println(startsWithIgnoreCase("HelloWorld", "Hello")); // true
        System.out.println(startsWithIgnoreCase("HelloWorld", "HELLO")); // true
        System.out.println(startsWithIgnoreCase(null, "prefix")); // false
        System.out.println(startsWithIgnoreCase("HelloWorld", null)); // false
    }
}