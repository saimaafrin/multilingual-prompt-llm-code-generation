public class StringUtils {
    /**
     * Elimina los espacios en blanco al inicio de la cadena dada.
     * @param str la cadena a verificar
     * @return la cadena sin espacios en blanco al inicio
     * @see java.lang.Character#isWhitespace
     */
    public static String trimLeadingWhitespace(String str) {
        if (str == null) {
            return null;
        }
        
        int len = str.length();
        int start = 0;
        
        while (start < len && Character.isWhitespace(str.charAt(start))) {
            start++;
        }
        
        return str.substring(start);
    }
}