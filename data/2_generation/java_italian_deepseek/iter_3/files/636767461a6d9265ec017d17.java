import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DotUnescape {

    /**
     * Decomprime un identificatore di stringa DOT.
     * @param input l'input
     * @return l'output decompresso
     */
    private static String unescapeId(String input) {
        if (input == null) {
            return null;
        }

        // Pattern per identificare sequenze di escape
        Pattern pattern = Pattern.compile("\\\\([\\\\\"])");
        Matcher matcher = pattern.matcher(input);

        // Sostituisce le sequenze di escape con i caratteri corrispondenti
        StringBuffer result = new StringBuffer();
        while (matcher.find()) {
            matcher.appendReplacement(result, matcher.group(1));
        }
        matcher.appendTail(result);

        return result.toString();
    }

    public static void main(String[] args) {
        String input = "\\\\escaped\\\"string\\\"";
        String output = unescapeId(input);
        System.out.println(output);  // Output: \escaped"string"
    }
}