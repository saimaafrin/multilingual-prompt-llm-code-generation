public class StringUtils {
    /**
     * Elimina todas las ocurrencias del carácter inicial proporcionado de la cadena dada.
     * @param str la cadena a verificar
     * @param leadingCharacter el carácter inicial que se debe eliminar
     * @return la cadena sin el carácter inicial
     */
    public static String trimLeadingCharacter(String str, char leadingCharacter) {
        if (str == null || str.isEmpty()) {
            return str;
        }
        
        int i = 0;
        while (i < str.length() && str.charAt(i) == leadingCharacter) {
            i++;
        }
        
        return str.substring(i);
    }
}