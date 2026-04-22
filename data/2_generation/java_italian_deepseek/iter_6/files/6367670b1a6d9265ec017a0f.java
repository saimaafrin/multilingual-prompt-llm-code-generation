import java.util.List;

public class StringUtils {

    /**
     * Controllo non sensibile al maiuscolo/minuscolo se la Stringa contiene uno qualsiasi dei caratteri nel set di stringhe fornito.
     * 
     * @param str La stringa in cui cercare.
     * @param searchStrArray La lista di stringhe da cercare.
     * @return true se la stringa contiene almeno una delle stringhe nella lista, false altrimenti.
     */
    public static boolean containsAnyIgnoreCase(String str, List<String> searchStrArray) {
        if (str == null || searchStrArray == null || searchStrArray.isEmpty()) {
            return false;
        }

        String lowerCaseStr = str.toLowerCase();
        for (String searchStr : searchStrArray) {
            if (searchStr != null && lowerCaseStr.contains(searchStr.toLowerCase())) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        List<String> searchStrings = List.of("hello", "world", "java");
        String input = "Hello, this is a test string.";
        System.out.println(containsAnyIgnoreCase(input, searchStrings)); // Output: true
    }
}