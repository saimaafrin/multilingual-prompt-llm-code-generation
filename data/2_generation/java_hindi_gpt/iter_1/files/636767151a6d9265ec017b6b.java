public class StringUtils {

    /** 
     * <p>जांचें कि एक String एक निर्दिष्ट उपसर्ग से शुरू होता है (वैकल्पिक रूप से केस-इंसेंसिटिव)।</p>
     * @see String#startsWith(String)
     * @param str  वह String जिसे जांचना है, यह null हो सकता है
     * @param prefix वह उपसर्ग जिसे खोजना है, यह null हो सकता है
     * @param ignoreCase यह दर्शाता है कि तुलना में केस को नजरअंदाज करना चाहिए या नहीं (केस-इंसेंसिटिव)।
     * @return <code>true</code> यदि String उपसर्ग से शुरू होता है या दोनों <code>null</code> हैं
     */
    private static boolean startsWith(final String str, final String prefix, final boolean ignoreCase) {
        if (str == null && prefix == null) {
            return true;
        }
        if (str == null || prefix == null) {
            return false;
        }
        if (ignoreCase) {
            return str.toLowerCase().startsWith(prefix.toLowerCase());
        } else {
            return str.startsWith(prefix);
        }
    }

    public static void main(String[] args) {
        System.out.println(startsWith("HelloWorld", "Hello", false)); // true
        System.out.println(startsWith("HelloWorld", "hello", true));  // true
        System.out.println(startsWith(null, null, false));            // true
        System.out.println(startsWith("HelloWorld", null, false));    // false
        System.out.println(startsWith(null, "Hello", false));         // false
    }
}