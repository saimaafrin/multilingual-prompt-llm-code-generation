public class StringUtils {

    /**
     * दिए गए String से अंतिमWhitespace को हटाएं।
     * @param str वह String जिसे जांचना है
     * @return ट्रिम किया हुआ String
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
        String input = "Hello World   ";
        String output = trimTrailingWhitespace(input);
        System.out.println("'" + output + "'");  // Output: 'Hello World'
    }
}