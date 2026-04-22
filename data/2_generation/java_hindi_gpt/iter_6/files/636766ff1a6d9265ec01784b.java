public class DigitChecker {
    /** 
     * <p>जांचता है कि <code>String</code> में केवल अंक के अक्षर हैं या नहीं।</p> 
     * <p><code>Null</code> और खाली String <code>false</code> लौटाएगा。</p>
     * @param str  जांचने के लिए <code>String</code>
     * @return <code>true</code> यदि str में केवल यूनिकोड संख्या है
     */
    public static boolean isDigits(String str) {
        if (str == null || str.isEmpty()) {
            return false;
        }
        for (char c : str.toCharArray()) {
            if (!Character.isDigit(c)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isDigits("12345")); // true
        System.out.println(isDigits("123a5")); // false
        System.out.println(isDigits(""));      // false
        System.out.println(isDigits(null));    // false
    }
}