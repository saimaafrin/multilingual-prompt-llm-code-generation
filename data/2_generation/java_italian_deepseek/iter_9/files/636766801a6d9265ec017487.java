import java.util.HashMap;
import java.util.Map;

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

        // Mappa per la codifica dei caratteri speciali
        Map<Character, String> encodingMap = new HashMap<>();
        encodingMap.put('{', "%7B");
        encodingMap.put('}', "%7D");

        StringBuilder encodedString = new StringBuilder();

        for (char c : s.toCharArray()) {
            if (encodingMap.containsKey(c)) {
                encodedString.append(encodingMap.get(c));
            } else {
                encodedString.append(c);
            }
        }

        return encodedString.toString();
    }

    public static void main(String[] args) {
        String input = "This is a {template} string with {parameters}.";
        String encoded = encodeTemplateNames(input);
        System.out.println(encoded);  // Output: This is a %7Btemplate%7D string with %7Bparameters%7D.
    }
}