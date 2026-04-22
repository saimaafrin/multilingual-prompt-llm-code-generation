import java.util.HashSet;
import java.util.Set;

public class StringUtils {

    public static String deleteAny(String inString, String charsToDelete) {
        if (inString == null || charsToDelete == null) {
            return inString;
        }

        // Create a set of characters to delete for quick lookup
        Set<Character> charsToDeleteSet = new HashSet<>();
        for (char c : charsToDelete.toCharArray()) {
            charsToDeleteSet.add(c);
        }

        // Build the resulting string by skipping characters in the delete set
        StringBuilder result = new StringBuilder();
        for (char c : inString.toCharArray()) {
            if (!charsToDeleteSet.contains(c)) {
                result.append(c);
            }
        }

        return result.toString();
    }

    public static void main(String[] args) {
        String input = "Hello, World!";
        String charsToDelete = "lo";
        System.out.println(deleteAny(input, charsToDelete)); // Output: He, Wrd!
    }
}