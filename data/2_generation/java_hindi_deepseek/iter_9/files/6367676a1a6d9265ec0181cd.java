public class StringUtils {

    /**
     * दिए गए स्ट्रिंग से अग्रणी व्हाइटस्पेस को हटाएं।
     * @param str वह स्ट्रिंग जिसे जांचना है
     * @return ट्रिम की गई स्ट्रिंग
     * @see java.lang.Character#isWhitespace
     */
    public static String trimLeadingWhitespace(String str) {
        if (str == null) {
            return null;
        }

        int length = str.length();
        int index = 0;

        while (index < length && Character.isWhitespace(str.charAt(index))) {
            index++;
        }

        return str.substring(index);
    }

    public static void main(String[] args) {
        String input = "   Hello World!";
        String result = trimLeadingWhitespace(input);
        System.out.println("'" + result + "'");  // Output: 'Hello World!'
    }
}