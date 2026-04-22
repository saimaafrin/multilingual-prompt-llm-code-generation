public class StringUtils {
    /**
     * Devuelve {@code true} si la cadena dada comienza con el prefijo especificado sin distinguir entre mayúsculas y minúsculas, {@code false} en caso contrario.
     * @param str la cadena a verificar
     * @param prefix el prefijo a buscar
     * @return {@code true} si la cadena dada comienza con el prefijo especificado sin distinguir entre mayúsculas y minúsculas, {@code false} en caso contrario.
     * @see java.lang.String#startsWith
     */
    public static boolean startsWithIgnoreCase(String str, String prefix) {
        if (str == null || prefix == null) {
            return false;
        }
        if (prefix.length() > str.length()) {
            return false;
        }
        return str.substring(0, prefix.length()).toLowerCase().equals(prefix.toLowerCase());
    }
}