import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UnescapeJava {
    public static String unescapeJava(String str) throws Exception {
        if (str == null) {
            return null;
        }

        StringBuilder sb = new StringBuilder();
        int i = 0;
        while (i < str.length()) {
            char c = str.charAt(i);
            if (c == '\\' && i + 1 < str.length()) {
                char nextChar = str.charAt(i + 1);
                switch (nextChar) {
                    case 'n':
                        sb.append('\n');
                        i += 2;
                        break;
                    case 't':
                        sb.append('\t');
                        i += 2;
                        break;
                    case 'r':
                        sb.append('\r');
                        i += 2;
                        break;
                    case 'b':
                        sb.append('\b');
                        i += 2;
                        break;
                    case 'f':
                        sb.append('\f');
                        i += 2;
                        break;
                    case '\'':
                        sb.append('\'');
                        i += 2;
                        break;
                    case '\"':
                        sb.append('\"');
                        i += 2;
                        break;
                    case '\\':
                        sb.append('\\');
                        i += 2;
                        break;
                    default:
                        sb.append(c);
                        i++;
                        break;
                }
            } else {
                sb.append(c);
                i++;
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