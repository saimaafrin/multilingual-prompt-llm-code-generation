public class StringUtils {

    /**
     * Obtiene la longitud de una cadena o <code>0</code> si la cadena es <code>null</code>.
     * @param str una cadena o <code>null</code>
     * @return longitud de la cadena o <code>0</code> si la cadena es <code>null</code>.
     * @since 2.4
     */
    public static int length(final String str) {
        return str == null ? 0 : str.length();
    }

    public static void main(String[] args) {
        // Ejemplo de uso
        String testString = "Hola, mundo!";
        System.out.println("Longitud de la cadena: " + length(testString)); // Debería imprimir 12

        String nullString = null;
        System.out.println("Longitud de la cadena nula: " + length(nullString)); // Debería imprimir 0
    }
}