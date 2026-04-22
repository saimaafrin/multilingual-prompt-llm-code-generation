public class StringUtils {

    /**
     * Rimuove gli spazi bianchi iniziali dalla Stringa fornita.
     * @param str la Stringa da controllare
     * @return la Stringa senza spazi bianchi iniziali
     * @see java.lang.Character#isWhitespace
     */
    public static String trimLeadingWhitespace(String str) {
        if (str == null) {
            return null;
        }
        
        int len = str.length();
        int start = 0;
        
        while (start < len && Character.isWhitespace(str.charAt(start))) {
            start++;
        }
        
        return str.substring(start);
    }

    public static void main(String[] args) {
        String testString = "   Hello, World!";
        System.out.println("Original: '" + testString + "'");
        System.out.println("Trimmed: '" + trimLeadingWhitespace(testString) + "'");
    }
}