import java.util.HashSet;
import java.util.Set;

public class StringUtils {

    /**
     * दिए गए String में से किसी भी चरित्र को हटाएं।
     * @param inString मूल String
     * @param charsToDelete हटाने के लिए चरित्रों का सेट। उदाहरण के लिए, "az\n" 'a', 'z' और नए लाइनों को हटा देगा।
     * @return परिणामस्वरूप String
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
        String result = deleteAny(input, charsToDelete);
        System.out.println(result);  // Output: Hll, Wrld!Ths s  tst.
    }
}