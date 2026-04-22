public class StringUtils {
    /**
     * <p>Controlla se una Stringa inizia con un prefisso specificato (opzionalmente senza distinzione tra maiuscole e minuscole).</p>
     * @see String#startsWith(String)
     * @param str  la Stringa da controllare, può essere null
     * @param prefix il prefisso da trovare, può essere null
     * @param ignoreCase indica se il confronto deve ignorare le maiuscole e minuscole (senza distinzione tra maiuscole e minuscole) o meno.
     * @return <code>true</code> se la Stringa inizia con il prefisso o entrambi <code>null</code>
     */
    private static boolean startsWith(final String str, final String prefix, final boolean ignoreCase) {
        if (str == null && prefix == null) {
            return true;
        }
        if (str == null || prefix == null) {
            return false;
        }
        if (prefix.length() > str.length()) {
            return false;
        }
        
        if (ignoreCase) {
            return str.regionMatches(true, 0, prefix, 0, prefix.length());
        } else {
            return str.startsWith(prefix);
        }
    }
}