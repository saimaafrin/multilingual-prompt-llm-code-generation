public class StringUtil {
    
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