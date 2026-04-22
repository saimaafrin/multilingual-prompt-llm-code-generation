public class StringUtils {

    /** 
     * <p>Check if a String ends with a specified suffix (optionally case insensitive).</p>
     * @see String#endsWith(String)
     * @param str  the String to check, may be null
     * @param suffix the suffix to find, may be null
     * @param ignoreCase indicates whether the compare should ignore case(case insensitive) or not.
     * @return <code>true</code> if the String ends with the suffix or both <code>null</code>
     */
    private static boolean endsWith(final String str, final String suffix, final boolean ignoreCase) {
        if (str == null || suffix == null) {
            return str == null && suffix == null;
        }
        if (ignoreCase) {
            return str.toLowerCase().endsWith(suffix.toLowerCase());
        } else {
            return str.endsWith(suffix);
        }
    }

    public static void main(String[] args) {
        System.out.println(endsWith("HelloWorld", "world", true)); // true
        System.out.println(endsWith("HelloWorld", "World", false)); // true
        System.out.println(endsWith("HelloWorld", "Hello", false)); // false
        System.out.println(endsWith(null, null, true)); // true
        System.out.println(endsWith(null, "test", true)); // false
    }
}