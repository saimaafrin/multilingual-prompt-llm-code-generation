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
        System.out.println(length("Hello")); // Output: 5
        System.out.println(length(null));     // Output: 0
    }
}