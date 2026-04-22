import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UnescapeJava {
    public static String unescapeJava(String str) throws Exception {
        if (str == null) {
            return null;
        }

        StringBuilder sb = new StringBuilder(str.length());
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (ch == '\\') {
                if (i + 1 < str.length()) {
                    char nextChar = str.charAt(i + 1);
                    switch (nextChar) {
                        case '\\':
                            sb.append('\\');
                            i++;
                            break;
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
                        default:
                            sb.append(ch);
                            break;
                    }
                } else {
                    sb.append(ch);
                }
            } else {
                sb.append(ch);
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) throws Exception {
        String input = "This is a test\\nstring with\\tescape\\rsequences\\b.";
        String unescaped = unescapeJava(input);
        System.out.println(unescaped);
    }
}