import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UnescapeJava {

    /**
     * <p>किसी भी Java लिटरल को <code>String</code> में अनएस्केप करता है। उदाहरण के लिए, यह <code>'\'</code> और <code>'n'</code> के अनुक्रम को एक नई पंक्ति के चर में बदल देगा, जब तक कि <code>'\'</code> के पहले कोई अन्य <code>'\'</code> न हो।</p>
     * @param str वह <code>String</code> जिसे अनएस्केप करना है, यह null हो सकता है
     * @return एक नई अनएस्केप की गई <code>String</code>, यदि इनपुट स्ट्रिंग null है तो <code>null</code>
     */
    public static String unescapeJava(String str) throws Exception {
        if (str == null) {
            return null;
        }

        StringBuilder result = new StringBuilder();
        boolean isEscaped = false;

        for (char c : str.toCharArray()) {
            if (isEscaped) {
                switch (c) {
                    case 'n':
                        result.append('\n');
                        break;
                    case 't':
                        result.append('\t');
                        break;
                    case 'r':
                        result.append('\r');
                        break;
                    case 'b':
                        result.append('\b');
                        break;
                    case 'f':
                        result.append('\f');
                        break;
                    case '\\':
                        result.append('\\');
                        break;
                    case '\'':
                        result.append('\'');
                        break;
                    case '\"':
                        result.append('\"');
                        break;
                    default:
                        result.append(c);
                        break;
                }
                isEscaped = false;
            } else {
                if (c == '\\') {
                    isEscaped = true;
                } else {
                    result.append(c);
                }
            }
        }

        // If the string ends with an escape character, append it as is
        if (isEscaped) {
            result.append('\\');
        }

        return result.toString();
    }

    public static void main(String[] args) throws Exception {
        String escapedString = "Hello\\nWorld! This is a test\\tstring.";
        String unescapedString = unescapeJava(escapedString);
        System.out.println(unescapedString);
    }
}