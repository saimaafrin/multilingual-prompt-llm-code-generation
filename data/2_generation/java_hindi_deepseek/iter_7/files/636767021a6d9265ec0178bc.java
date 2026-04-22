public class StringUtils {

    /**
     * एक स्ट्रिंग के भीतर पहला इंडेक्स खोजता है, <code>null</code> को संभालते हुए। यह विधि {@link String#indexOf(String)} का उपयोग करती है।
     * 
     * @param str वह स्ट्रिंग जिसमें खोज करनी है, यदि <code>null</code> है तो -1 लौटाता है।
     * @param searchStr वह स्ट्रिंग जिसे खोजना है, यदि <code>null</code> है तो -1 लौटाता है।
     * @return पहला मिलान इंडेक्स, या -1 यदि कोई मिलान नहीं है या इनपुट <code>null</code> है।
     */
    public static int indexOf(String str, String searchStr) {
        if (str == null || searchStr == null) {
            return -1;
        }
        return str.indexOf(searchStr);
    }

    public static void main(String[] args) {
        // Test cases
        System.out.println(indexOf("Hello World", "World")); // 6
        System.out.println(indexOf("Hello World", "Java"));  // -1
        System.out.println(indexOf(null, "World"));          // -1
        System.out.println(indexOf("Hello World", null));    // -1
    }
}