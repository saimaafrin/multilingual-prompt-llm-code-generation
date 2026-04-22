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
                        case 'u':
                            if (i + 5 < str.length()) {
                                String hex = str.substring(i + 2, i + 6);
                                try {
                                    int unicode = Integer.parseInt(hex, 16);
                                    sb.append((char) unicode);
                                    i += 5;
                                } catch (NumberFormatException e) {
                                    throw new Exception("Invalid Unicode escape sequence: \\u" + hex);
                                }
                            } else {
                                throw new Exception("Incomplete Unicode escape sequence");
                            }
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
}