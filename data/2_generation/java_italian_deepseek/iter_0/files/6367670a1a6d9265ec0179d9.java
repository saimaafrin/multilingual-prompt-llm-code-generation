public class StringUtils {

    /**
     * Ottiene la lunghezza di una Stringa o <code>0</code> se la Stringa è <code>null</code>.
     * @param str una Stringa o <code>null</code>
     * @return lunghezza della Stringa o <code>0</code> se la Stringa è <code>null</code>.
     * @since 2.4
     */
    public static int length(final String str) {
        return str == null ? 0 : str.length();
    }

    public static void main(String[] args) {
        // Test cases
        System.out.println(length(null));      // Output: 0
        System.out.println(length(""));         // Output: 0
        System.out.println(length("Hello"));    // Output: 5
        System.out.println(length("Java"));     // Output: 4
    }
}