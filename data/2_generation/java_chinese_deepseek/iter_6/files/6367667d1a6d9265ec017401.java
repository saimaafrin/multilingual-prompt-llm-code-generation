import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringUnescape {

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
                        // Handle octal and unicode escapes
                        if (nextChar >= '0' && nextChar <= '7') {
                            // Octal escape
                            int code = 0;
                            int j = i + 1;
                            while (j < str.length() && str.charAt(j) >= '0' && str.charAt(j) <= '7' && j - i - 1 < 3) {
                                code = code * 8 + (str.charAt(j) - '0');
                                j++;
                            }
                            sb.append((char) code);
                            i = j;
                        } else if (nextChar == 'u') {
                            // Unicode escape
                            if (i + 5 < str.length()) {
                                String hex = str.substring(i + 2, i + 6);
                                try {
                                    int code = Integer.parseInt(hex, 16);
                                    sb.append((char) code);
                                    i += 6;
                                } catch (NumberFormatException e) {
                                    throw new Exception("Invalid unicode escape sequence: " + hex);
                                }
                            } else {
                                throw new Exception("Incomplete unicode escape sequence");
                            }
                        } else {
                            // Unknown escape sequence, treat as literal
                            sb.append(c);
                            i++;
                        }
                        break;
                }
            } else {
                sb.append(c);
                i++;
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        try {
            String input = "Hello\\nWorld\\t\\u0041";
            String output = unescapeJava(input);
            System.out.println(output);  // Output: Hello
                                        // World   A
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}