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
        if (str == null || searchStrArray == null) {
            return false;
        }

        for (String searchStr : searchStrArray) {
            if (searchStr != null && str.toLowerCase().contains(searchStr.toLowerCase())) {
                return true;
            }
        }

        return false;
    }
}