import java.util.HashSet;
import java.util.Set;

public class StringUtils {

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
        String input = "Hello, World!";
        String charsToDelete = "lo";
        String result = deleteAny(input, charsToDelete);
        System.out.println(result);  // Output: He, Wrd!
    }
}