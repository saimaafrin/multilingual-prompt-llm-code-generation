import java.util.List;

public class StringUtils {
    /** 
     * केस-संवेदनशीलता की परवाह किए बिना जांच करता है कि स्ट्रिंग में दिए गए स्ट्रिंग सेट में कोई भी वर्ण है या नहीं। 
     */
    public static boolean containsAnyIgnoreCase(String str, List<String> searchStrArray) {
        if (str == null || searchStrArray == null) {
            return false;
        }
        
        String lowerStr = str.toLowerCase();
        
        for (String searchStr : searchStrArray) {
            if (searchStr != null && lowerStr.contains(searchStr.toLowerCase())) {
                return true;
            }
        }
        
        return false;
    }

    public static void main(String[] args) {
        List<String> searchStrArray = List.of("a", "b", "c");
        String str = "Hello World";
        boolean result = containsAnyIgnoreCase(str, searchStrArray);
        System.out.println(result); // Output: true
    }
}