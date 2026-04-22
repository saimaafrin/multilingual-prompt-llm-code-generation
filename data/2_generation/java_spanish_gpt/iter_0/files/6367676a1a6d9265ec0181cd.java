public class StringUtil {

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
        int startIndex = 0;
        while (startIndex < str.length() && Character.isWhitespace(str.charAt(startIndex))) {
            startIndex++;
        }
        return str.substring(startIndex);
    }

    public static void main(String[] args) {
        String testString = "   Hello, World!";
        String result = trimLeadingWhitespace(testString);
        System.out.println(result); // Output: "Hello, World!"
    }
}