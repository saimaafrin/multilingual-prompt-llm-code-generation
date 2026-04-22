public class StringUtils {

    /**
     * <p>जांचता है कि <code>String</code> में केवल अंक के अक्षर हैं या नहीं।</p> 
     * <p><code>Null</code> और खाली String <code>false</code> लौटाएगा।</p>
     * @param str  जांचने के लिए <code>String</code>
     * @return <code>true</code> यदि str में केवल यूनिकोड संख्या है
     */
    public static boolean isDigits(String str) {
        if (str == null || str.isEmpty()) {
            return false;
        }
        for (int i = 0; i < str.length(); i++) {
            if (!Character.isDigit(str.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        // Test cases
        System.out.println(isDigits("12345")); // true
        System.out.println(isDigits("123a45")); // false
        System.out.println(isDigits("")); // false
        System.out.println(isDigits(null)); // false
    }
}