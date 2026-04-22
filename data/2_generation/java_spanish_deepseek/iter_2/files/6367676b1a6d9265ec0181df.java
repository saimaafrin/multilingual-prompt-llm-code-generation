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
        return str.regionMatches(true, 0, prefix, 0, prefix.length());
    }

    public static void main(String[] args) {
        // Ejemplo de uso
        System.out.println(startsWithIgnoreCase("Hola Mundo", "hola")); // true
        System.out.println(startsWithIgnoreCase("Hola Mundo", "Mundo")); // false
        System.out.println(startsWithIgnoreCase("Hola Mundo", "HOLA")); // true
        System.out.println(startsWithIgnoreCase("Hola Mundo", "hola mundo")); // false
    }
}