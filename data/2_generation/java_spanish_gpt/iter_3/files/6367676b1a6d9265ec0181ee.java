public class StringUtil {
    
    /** 
     * Elimina los espacios en blanco al final del String dado.
     * @param str el String a verificar
     * @return el String sin espacios en blanco al final
     * @see java.lang.Character#isWhitespace
     */
    public static String trimTrailingWhitespace(String str) {
        if (str == null) {
            return null;
        }
        int end = str.length();
        while (end > 0 && Character.isWhitespace(str.charAt(end - 1))) {
            end--;
        }
        return str.substring(0, end);
    }

    public static void main(String[] args) {
        String testString = "Hello World!   ";
        String trimmedString = trimTrailingWhitespace(testString);
        System.out.println("'" + trimmedString + "'"); // Output: 'Hello World!'
    }
}