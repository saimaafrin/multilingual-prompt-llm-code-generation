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
        String test1 = "Hello, World!";
        String test2 = null;
        String test3 = "";

        System.out.println(length(test1)); // Output: 13
        System.out.println(length(test2)); // Output: 0
        System.out.println(length(test3)); // Output: 0
    }
}