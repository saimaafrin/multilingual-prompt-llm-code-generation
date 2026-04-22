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
        int strOffset = str.length() - suffix.length();
        
        if (ignoreCase) {
            return str.regionMatches(true, strOffset, suffix, 0, suffix.length());
        } else {
            return str.regionMatches(false, strOffset, suffix, 0, suffix.length());
        }
    }
}