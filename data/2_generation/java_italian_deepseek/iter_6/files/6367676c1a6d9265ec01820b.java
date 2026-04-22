import java.util.HashSet;
import java.util.Set;

public class StringUtils {

    /**
     * Elimina qualsiasi carattere in una Stringa data.
     * @param inString la Stringa originale
     * @param charsToDelete un insieme di caratteri da eliminare. Ad esempio, "az\n" eliminerà le 'a', le 'z' e le nuove righe.
     * @return la Stringa risultante
     */
    public static String deleteAny(String inString, String charsToDelete) {
        if (inString == null || charsToDelete == null) {
            return inString;
        }

        // Convert the characters to delete into a set for quick lookup
        Set<Character> charsToRemove = new HashSet<>();
        for (char c : charsToDelete.toCharArray()) {
            charsToRemove.add(c);
        }

        // Build the resulting string by skipping characters in the set
        StringBuilder result = new StringBuilder();
        for (char c : inString.toCharArray()) {
            if (!charsToRemove.contains(c)) {
                result.append(c);
            }
        }

        return result.toString();
    }

    public static void main(String[] args) {
        String input = "Hello, World!\nThis is a test.";
        String charsToDelete = "aeiou\n";
        String result = deleteAny(input, charsToDelete);
        System.out.println(result);  // Output: Hll, Wrld!Ths s  tst.
    }
}