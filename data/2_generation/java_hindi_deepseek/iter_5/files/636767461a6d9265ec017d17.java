import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UnescapeIdExample {

    /**
     * एक स्ट्रिंग DOT पहचानकर्ता को अनएस्केप करें।
     * @param input इनपुट
     * @return अनएस्केप किया गया आउटपुट
     */
    private static String unescapeId(String input) {
        if (input == null) {
            return null;
        }
        
        // Replace escaped characters with their unescaped counterparts
        String unescaped = input.replace("\\\\.", ".");
        unescaped = unescaped.replace("\\\\", "\\");
        
        return unescaped;
    }

    public static void main(String[] args) {
        String input = "example\\.com";
        String output = unescapeId(input);
        System.out.println(output);  // Output: example.com
    }
}