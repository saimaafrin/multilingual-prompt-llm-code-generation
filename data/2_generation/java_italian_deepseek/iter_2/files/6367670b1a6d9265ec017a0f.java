import java.util.List;

public class StringUtils {

    /**
     * Controllo non sensibile al maiuscolo/minuscolo se la Stringa contiene uno qualsiasi dei caratteri nel set di stringhe fornito.
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
        // Example usage
        List<String> searchStrings = List.of("hello", "world", "java");
        String input = "Hello, this is a test string.";
        boolean result = containsAnyIgnoreCase(input, searchStrings);
        System.out.println(result); // Output: true
    }
}