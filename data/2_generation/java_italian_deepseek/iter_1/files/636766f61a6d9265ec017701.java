public class StringUtils {

    /**
     * Trova l'ultimo indice all'interno di una Stringa, gestendo <code>null</code>. Questo metodo utilizza {@link String#lastIndexOf(String)}.
     * 
     * @param str La stringa in cui cercare, può essere <code>null</code>.
     * @param searchStr La stringa da cercare, può essere <code>null</code>.
     * @return L'ultimo indice della stringa cercata, o -1 se non trovata o se una delle stringhe è <code>null</code>.
     */
    public static int lastIndexOf(String str, String searchStr) {
        if (str == null || searchStr == null) {
            return -1;
        }
        return str.lastIndexOf(searchStr);
    }

    public static void main(String[] args) {
        // Esempio di utilizzo
        String str = "Hello, world! Hello again!";
        String searchStr = "Hello";
        int index = lastIndexOf(str, searchStr);
        System.out.println("Last index of '" + searchStr + "' is: " + index);
    }
}