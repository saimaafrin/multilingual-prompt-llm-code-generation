public class CharUtils {

    /**
     * Convierte el "Character" a un "char" manejando <code>null</code>.
     * <pre>
     * CharUtils.toChar(null, 'X') = 'X'
     * CharUtils.toChar(' ', 'X')  = ' '
     * CharUtils.toChar('A', 'X')  = 'A'
     * </pre>
     * @param ch  el carácter a convertir
     * @param defaultValue  el valor a usar si el carácter es null
     * @return el valor "char" del carácter o el valor por defecto si es null
     */
    public static char toChar(final Character ch, final char defaultValue) {
        return ch != null ? ch : defaultValue;
    }

    public static void main(String[] args) {
        System.out.println(toChar(null, 'X')); // Output: X
        System.out.println(toChar(' ', 'X')); // Output:  
        System.out.println(toChar('A', 'X')); // Output: A
    }
}