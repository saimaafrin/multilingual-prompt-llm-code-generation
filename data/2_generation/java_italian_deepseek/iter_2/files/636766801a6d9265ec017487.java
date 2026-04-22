import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class TemplateEncoder {

    /**
     * Codifica una stringa con nomi di parametri di template presenti, in particolare i caratteri '{' e '}' verranno codificati in percentuale.
     * @param s la stringa con zero o più nomi di parametri di template
     * @return la stringa con i nomi di parametri di template codificati.
     */
    public static String encodeTemplateNames(String s) {
        if (s == null) {
            return null;
        }

        // Pattern per trovare i caratteri '{' e '}'
        Pattern pattern = Pattern.compile("[{}]");
        Matcher matcher = pattern.matcher(s);

        // StringBuffer per costruire la stringa risultante
        StringBuffer result = new StringBuffer();

        while (matcher.find()) {
            // Sostituisci '{' con '%7B' e '}' con '%7D'
            String replacement = matcher.group().equals("{") ? "%7B" : "%7D";
            matcher.appendReplacement(result, replacement);
        }
        matcher.appendTail(result);

        return result.toString();
    }

    public static void main(String[] args) {
        String input = "This is a {template} string with {parameters}.";
        String encoded = encodeTemplateNames(input);
        System.out.println(encoded);  // Output: This is a %7Btemplate%7D string with %7Bparameters%7D.
    }
}