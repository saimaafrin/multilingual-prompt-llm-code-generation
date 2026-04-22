public class StringUtils {
    /**
     * Elimina cualquier carácter en una cadena dada.
     * @param inString la cadena original
     * @param charsToDelete un conjunto de caracteres a eliminar. Por ejemplo, "az\n" eliminará las 'a', 'z' y los saltos de línea.
     * @return la cadena resultante
     */
    public static String deleteAny(String inString, String charsToDelete) {
        if (inString == null || charsToDelete == null) {
            return inString;
        }
        
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < inString.length(); i++) {
            char ch = inString.charAt(i);
            if (charsToDelete.indexOf(ch) == -1) {
                sb.append(ch);
            }
        }
        return sb.toString();
    }
}