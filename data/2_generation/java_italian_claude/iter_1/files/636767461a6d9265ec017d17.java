import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class DotUtils {

    /**
     * Decomprime un identificatore di stringa DOT.
     * @param input l'input
     * @return l'output decompresso
     */
    private String unescapeId(String input) {
        if (input == null || input.isEmpty()) {
            return input;
        }

        // Remove quotes if present
        if (input.startsWith("\"") && input.endsWith("\"")) {
            input = input.substring(1, input.length() - 1);
        }

        // Replace escaped characters
        StringBuilder result = new StringBuilder();
        Pattern pattern = Pattern.compile("\\\\(.)");
        Matcher matcher = pattern.matcher(input);
        
        int lastEnd = 0;
        while (matcher.find()) {
            result.append(input.substring(lastEnd, matcher.start()));
            result.append(matcher.group(1));
            lastEnd = matcher.end();
        }
        result.append(input.substring(lastEnd));

        return result.toString();
    }
}