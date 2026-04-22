import java.util.regex.Pattern;

public class DotUtils {

    /**
     * Remueve el "escape" de un identificador de cadena DOT.
     * @param input la entrada
     * @return la salida sin carácteres "escape"
     */
    private String unescapeId(String input) {
        if (input == null || input.isEmpty()) {
            return input;
        }

        // Remove quotes if present at start/end
        if (input.startsWith("\"") && input.endsWith("\"")) {
            input = input.substring(1, input.length() - 1);
        }

        // Replace escaped characters
        return input.replaceAll(Pattern.quote("\\\""), "\"")  // Escaped quotes
                   .replaceAll(Pattern.quote("\\\\"), "\\")   // Escaped backslashes
                   .replaceAll(Pattern.quote("\\n"), "\n")    // Escaped newlines
                   .replaceAll(Pattern.quote("\\r"), "\r")    // Escaped carriage returns
                   .replaceAll(Pattern.quote("\\t"), "\t");   // Escaped tabs
    }
}