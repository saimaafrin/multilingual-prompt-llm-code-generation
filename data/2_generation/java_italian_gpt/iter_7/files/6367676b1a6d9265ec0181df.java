public class StringUtils {

    /** 
     * Restituisce {@code true} se la stringa fornita inizia con il prefisso specificato, ignorando le maiuscole, {@code false} altrimenti.
     * @param str la String da controllare
     * @param prefix il prefisso da cercare
     * @return {@code true} se la stringa fornita inizia con il prefisso specificato, ignorando le maiuscole, {@code false} altrimenti.
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
        System.out.println(startsWithIgnoreCase("Hello World", "hello")); // true
        System.out.println(startsWithIgnoreCase("Hello World", "world")); // false
        System.out.println(startsWithIgnoreCase("Hello World", "Hello")); // true
        System.out.println(startsWithIgnoreCase("Hello World", "HELLO")); // true
        System.out.println(startsWithIgnoreCase(null, "prefix")); // false
        System.out.println(startsWithIgnoreCase("Hello World", null)); // false
    }
}