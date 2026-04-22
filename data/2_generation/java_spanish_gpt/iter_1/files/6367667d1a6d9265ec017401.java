public class StringUnescaper {

    /** 
     * <p>Remueve el "escape" de cualquier literal de Java encontrado en el <code>String</code>. Por ejemplo, convertirá una secuencia de <code>'\'</code> y <code>'n'</code> en un carácter de nueva línea, a menos que el <code>'\'</code> esté precedido por otro <code>'\'</code>.</p>
     * @param str el <code>String</code> a procesar, puede ser nulo
     * @return un nuevo <code>String</code> sin carácteres "escape", <code>null</code> si la entrada es un string nulo
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
                    case '"':
                        result.append('"');
                        break;
                    case '\'':
                        result.append('\'');
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

    public static void main(String[] args) {
        try {
            String input = "Hello\\nWorld! This is a test\\tstring with escaped characters.";
            String output = unescapeJava(input);
            System.out.println(output);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}