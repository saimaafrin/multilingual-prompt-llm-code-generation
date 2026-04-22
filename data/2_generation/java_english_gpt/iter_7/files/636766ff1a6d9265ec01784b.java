public class StringUtils {
    
    /** 
     * <p>Checks whether the <code>String</code> contains only digit characters.</p> 
     * <p><code>Null</code> and empty String will return <code>false</code>.</p>
     * @param str  the <code>String</code> to check
     * @return <code>true</code> if str contains only unicode numeric
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