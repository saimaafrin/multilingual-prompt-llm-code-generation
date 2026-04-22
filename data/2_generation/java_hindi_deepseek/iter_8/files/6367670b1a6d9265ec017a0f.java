import java.util.List;

public class StringUtils {

    /**
     * केस-संवेदनशीलता की परवाह किए बिना जांच करता है कि स्ट्रिंग में दिए गए स्ट्रिंग सेट में कोई भी वर्ण है या नहीं।
     * 
     * @param str जांच की जाने वाली स्ट्रिंग
     * @param searchStrArray खोजे जाने वाले स्ट्रिंग्स की सूची
     * @return true यदि स्ट्रिंग में कोई भी स्ट्रिंग सेट में मौजूद है, अन्यथा false
     */
    public static boolean containsAnyIgnoreCase(String str, List<String> searchStrArray) {
        if (str == null || searchStrArray == null || searchStrArray.isEmpty()) {
            return false;
        }

        String lowerCaseStr = str.toLowerCase();
        for (String searchStr : searchStrArray) {
            if (searchStr != null && lowerCaseStr.contains(searchStr.toLowerCase())) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        // Example usage
        List<String> searchStrings = List.of("hello", "world", "java");
        String inputString = "Hello, this is a test string!";
        boolean result = containsAnyIgnoreCase(inputString, searchStrings);
        System.out.println("Contains any: " + result); // Output: Contains any: true
    }
}