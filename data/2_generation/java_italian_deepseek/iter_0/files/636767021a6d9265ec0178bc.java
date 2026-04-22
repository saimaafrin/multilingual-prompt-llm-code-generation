public class StringUtils {

    /**
     * Trova il primo indice all'interno di una Stringa, gestendo <code>null</code>. Questo metodo utilizza {@link String#indexOf(String)}.
     * 
     * @param str La stringa in cui cercare, può essere <code>null</code>.
     * @param searchStr La stringa da cercare, può essere <code>null</code>.
     * @return L'indice della prima occorrenza di <code>searchStr</code> in <code>str</code>, oppure -1 se non trovato o se una delle stringhe è <code>null</code>.
     */
    public static int indexOf(String str, String searchStr) {
        if (str == null || searchStr == null) {
            return -1;
        }
        return str.indexOf(searchStr);
    }

    public static void main(String[] args) {
        // Esempi di utilizzo
        System.out.println(indexOf("Hello World", "World")); // Output: 6
        System.out.println(indexOf("Hello World", "Java"));  // Output: -1
        System.out.println(indexOf(null, "World"));         // Output: -1
        System.out.println(indexOf("Hello World", null));    // Output: -1
    }
}