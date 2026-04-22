public class StringUtils {

    /**
     * Rimuove gli spazi bianchi finali dalla Stringa fornita.
     * @param str la Stringa da controllare
     * @return la Stringa senza spazi bianchi finali
     * @see java.lang.Character#isWhitespace
     */
    public static String trimTrailingWhitespace(String str) {
        if (str == null) {
            return null;
        }

        int length = str.length();
        while (length > 0 && Character.isWhitespace(str.charAt(length - 1))) {
            length--;
        }

        return str.substring(0, length);
    }

    public static void main(String[] args) {
        String testString = "Hello World   ";
        System.out.println("Original: '" + testString + "'");
        System.out.println("Trimmed: '" + trimTrailingWhitespace(testString) + "'");
    }
}