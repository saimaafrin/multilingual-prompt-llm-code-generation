import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UnescapeJava {
    public static String unescapeJava(String str) throws Exception {
        if (str == null) {
            return null;
        }

        StringBuilder sb = new StringBuilder(str.length());
        int i = 0;
        while (i < str.length()) {
            char c = str.charAt(i);
            if (c == '\\' && i + 1 < str.length()) {
                char nextChar = str.charAt(i + 1);
                switch (nextChar) {
                    case '\\':
                        sb.append('\\');
                        i += 2;
                        break;
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
                    case 'u':
                        if (i + 5 < str.length()) {
                            String hex = str.substring(i + 2, i + 6);
                            try {
                                int unicode = Integer.parseInt(hex, 16);
                                sb.append((char) unicode);
                                i += 6;
                            } catch (NumberFormatException e) {
                                throw new Exception("Invalid Unicode escape sequence: " + hex);
                            }
                        } else {
                            throw new Exception("Invalid Unicode escape sequence: incomplete sequence");
                        }
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