public class StringUnescaper {

    /** 
     * <p>对<code>String</code>中找到的任何Java字面量进行反转义。例如，它将把一系列<code>'\'</code>和<code>'n'</code>转换为换行符，除非<code>'\'</code>前面有另一个<code>'\'</code>。</p>
     * @param str 要反转义的<code>String</code>，可以为空
     * @return 一个新的反转义<code>String</code>，如果输入字符串为空，则返回<code>null</code>
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
                    case '\"':
                        result.append('\"');
                        break;
                    case '\'':
                        result.append('\'');
                        break;
                    case '\\':
                        result.append('\\');
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

        return result.toString();
    }

    public static void main(String[] args) throws Exception {
        String testString = "Hello\\nWorld! This is a test string with a tab:\\t and a backslash: \\\\";
        String unescapedString = unescapeJava(testString);
        System.out.println(unescapedString);
    }
}