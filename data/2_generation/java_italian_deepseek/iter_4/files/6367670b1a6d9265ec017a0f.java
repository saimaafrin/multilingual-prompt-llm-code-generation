import java.util.List;

public class StringUtils {

    /**
     * Controllo non sensibile al maiuscolo/minuscolo se la Stringa contiene uno qualsiasi dei caratteri nel set di stringhe fornito.
     * 
     * @param str La stringa da controllare.
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
        // Esempio di utilizzo
        List<String> searchStrings = List.of("abc", "def", "ghi");
        String input = "This is a test string with ABC in it.";
        boolean result = containsAnyIgnoreCase(input, searchStrings);
        System.out.println(result); // Output: true
    }
}