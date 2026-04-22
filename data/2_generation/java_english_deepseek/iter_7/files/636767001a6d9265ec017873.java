public class StringUtils {

    /**
     * <p>Reverses a String as per  {@link StringBuilder#reverse()}.</p> <p>A <code>null</code> String returns <code>null</code>.</p> <pre> StringUtils.reverse(null)  = null StringUtils.reverse("")    = "" StringUtils.reverse("bat") = "tab" </pre>
     * @param str  the String to reverse, may be null
     * @return the reversed String, <code>null</code> if null String input
     */
    public static String reverse(final String str) {
        if (str == null) {
            return null;
        }
        return new StringBuilder(str).reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println(reverse(null));   // null
        System.out.println(reverse(""));     // ""
        System.out.println(reverse("bat"));  // "tab"
    }
}