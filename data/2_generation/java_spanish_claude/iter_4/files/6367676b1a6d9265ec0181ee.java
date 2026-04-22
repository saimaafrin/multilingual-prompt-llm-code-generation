public class StringUtils {
    /**
     * Elimina los espacios en blanco al final del String dado.
     * @param str el String a verificar
     * @return el String sin espacios en blanco al final
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