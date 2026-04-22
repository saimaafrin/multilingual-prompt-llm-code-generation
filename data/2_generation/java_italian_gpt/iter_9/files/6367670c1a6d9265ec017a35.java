public class StringUtils {

    /** 
     * <p>Controlla se una Stringa termina con un suffisso specificato (opzionalmente senza distinzione tra maiuscole e minuscole).</p>
     * @see String#endsWith(String)
     * @param str  la Stringa da controllare, può essere null
     * @param suffix il suffisso da trovare, può essere null
     * @param ignoreCase indica se il confronto deve ignorare le maiuscole e minuscole (senza distinzione) o meno.
     * @return <code>true</code> se la Stringa termina con il suffisso o entrambi sono <code>null</code>
     */
    private static boolean endsWith(final String str, final String suffix, final boolean ignoreCase) {
        if (str == null && suffix == null) {
            return true;
        }
        if (str == null || suffix == null) {
            return false;
        }
        if (suffix.length() > str.length()) {
            return false;
        }
        String strEnd = str.substring(str.length() - suffix.length());
        return ignoreCase ? strEnd.equalsIgnoreCase(suffix) : strEnd.equals(suffix);
    }

    public static void main(String[] args) {
        // Test cases
        System.out.println(endsWith("HelloWorld", "World", false)); // true
        System.out.println(endsWith("HelloWorld", "world", true));  // true
        System.out.println(endsWith("HelloWorld", "Hello", false)); // false
        System.out.println(endsWith(null, null, false));             // true
        System.out.println(endsWith(null, "test", false));           // false
        System.out.println(endsWith("test", null, false));           // false
    }
}