public class StringUtil {
    
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
        
        int startIndex = 0;
        while (startIndex < str.length() && Character.isWhitespace(str.charAt(startIndex))) {
            startIndex++;
        }
        
        return str.substring(startIndex);
    }

    public static void main(String[] args) {
        String testString = "   Hello, World!";
        String trimmedString = trimLeadingWhitespace(testString);
        System.out.println("Trimmed String: '" + trimmedString + "'");
    }
}