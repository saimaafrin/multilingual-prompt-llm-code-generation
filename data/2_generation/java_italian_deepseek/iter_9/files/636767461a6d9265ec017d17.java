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

        // Pattern per trovare sequenze di escape come \", \\, \n, \r, \t, etc.
        Pattern pattern = Pattern.compile("\\\\([\"\\\\ntr])");
        Matcher matcher = pattern.matcher(input);

        StringBuffer result = new StringBuffer();
        while (matcher.find()) {
            String escapeSequence = matcher.group(1);
            String replacement;
            switch (escapeSequence) {
                case "\"":
                    replacement = "\"";
                    break;
                case "\\":
                    replacement = "\\";
                    break;
                case "n":
                    replacement = "\n";
                    break;
                case "r":
                    replacement = "\r";
                    break;
                case "t":
                    replacement = "\t";
                    break;
                default:
                    replacement = escapeSequence; // Se non riconosciuto, lascia invariato
            }
            matcher.appendReplacement(result, replacement);
        }
        matcher.appendTail(result);

        return result.toString();
    }

    public static void main(String[] args) {
        String input = "Ciao\\nMondo\\t!";
        String output = unescapeId(input);
        System.out.println(output);  // Output: Ciao
                                     //         Mondo	!
    }
}