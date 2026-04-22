public class StringUtils {
    /**
     * Rimuove gli spazi bianchi finali dalla Stringa fornita.
     * @param str la Stringa da controllare
     * @return la Stringa senza spazi bianchi finali
     * @see java.lang.Character#isWhitespace
     */
    public static String trimTrailingWhitespace(String str) {
        if (str == null) {
            return null;
        }
        
        int len = str.length();
        while (len > 0 && Character.isWhitespace(str.charAt(len - 1))) {
            len--;
        }
        
        return str.substring(0, len);
    }
}