public class StringUtils {

    /**
     * Elimina los espacios en blanco al inicio de la cadena dada.
     * @param str la cadena a verificar
     * @return la cadena sin espacios en blanco al inicio
     * @see java.lang.Character#isWhitespace
     */
    public static String trimLeadingWhitespace(String str) {
        if (str == null) {
            return null;
        }

        int len = str.length();
        int st = 0;

        while ((st < len) && (Character.isWhitespace(str.charAt(st)))) {
            st++;
        }

        return (st > 0) ? str.substring(st) : str;
    }

    public static void main(String[] args) {
        String testString = "   Hello, World!";
        System.out.println("Original: '" + testString + "'");
        System.out.println("Trimmed: '" + trimLeadingWhitespace(testString) + "'");
    }
}