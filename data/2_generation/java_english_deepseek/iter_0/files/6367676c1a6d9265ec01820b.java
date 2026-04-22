import java.util.HashSet;
import java.util.Set;

public class StringUtils {

    /**
     * Delete any character in a given String.
     * @param inString the original String
     * @param charsToDelete a set of characters to delete. E.g. "az\n" will delete 'a's, 'z's and new lines.
     * @return the resulting String
     */
    public static String deleteAny(String inString, String charsToDelete) {
        if (inString == null || charsToDelete == null) {
            return inString;
        }

        Set<Character> charsToRemove = new HashSet<>();
        for (char c : charsToDelete.toCharArray()) {
            charsToRemove.add(c);
        }

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
        System.out.println(deleteAny(input, charsToDelete)); // Output: Hll, Wrld!Ths s  tst.
    }
}