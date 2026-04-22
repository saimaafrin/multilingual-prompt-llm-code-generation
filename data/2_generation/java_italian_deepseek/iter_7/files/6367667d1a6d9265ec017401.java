import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringUtils {

    /**
     * <p>Rimuove l'escape da qualsiasi letterale Java trovato nella <code>String</code>. Ad esempio, trasformerà una sequenza di <code>'\'</code> e <code>'n'</code> in un carattere di nuova linea, a meno che il <code>'\'</code> non sia preceduto da un altro <code>'\'</code>.</p>
     * @param str la <code>String</code> da desescapare, può essere null
     * @return una nuova <code>String</code> desescapata, <code>null</code> se l'input è una stringa null
     */
    public static String unescapeJava(String str) throws Exception {
        if (str == null) {
            return null;
        }

        StringBuilder sb = new StringBuilder();
        int length = str.length();
        for (int i = 0; i < length; i++) {
            char c = str.charAt(i);
            if (c == '\\' && i + 1 < length) {
                char nextChar = str.charAt(i + 1);
                switch (nextChar) {
                    case 'n':
                        sb.append('\n');
                        i++;
                        break;
                    case 't':
                        sb.append('\t');
                        i++;
                        break;
                    case 'r':
                        sb.append('\r');
                        i++;
                        break;
                    case 'b':
                        sb.append('\b');
                        i++;
                        break;
                    case 'f':
                        sb.append('\f');
                        i++;
                        break;
                    case '\'':
                        sb.append('\'');
                        i++;
                        break;
                    case '\"':
                        sb.append('\"');
                        i++;
                        break;
                    case '\\':
                        sb.append('\\');
                        i++;
                        break;
                    default:
                        sb.append(c);
                        break;
                }
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) throws Exception {
        String input = "Ciao\\nMondo\\t!";
        String output = unescapeJava(input);
        System.out.println(output);  // Output: Ciao
                                      //         Mondo    !
    }
}