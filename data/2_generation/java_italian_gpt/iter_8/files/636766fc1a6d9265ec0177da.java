public class ParameterSeparatorChecker {

    /** 
     * Determina se un nome di parametro termina nella posizione attuale, cioè se il carattere fornito può essere considerato un separatore. 
     */
    private static boolean isParameterSeparator(final char c) {
        // Define a set of characters that are considered as parameter separators
        return c == ',' || c == ';' || c == ' ' || c == '\n' || c == '\t' || c == '\r' || c == '=' || c == '&';
    }

    public static void main(String[] args) {
        // Test the isParameterSeparator method
        char testChar1 = ',';
        char testChar2 = 'a';
        
        System.out.println(isParameterSeparator(testChar1)); // true
        System.out.println(isParameterSeparator(testChar2)); // false
    }
}