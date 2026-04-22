public class StringUtils {

    /**
     * एक स्ट्रिंग के भीतर पहला इंडेक्स खोजता है, <code>null</code> को संभालते हुए। यह विधि {@link String#indexOf(String)} का उपयोग करती है।
     *
     * @param str       वह स्ट्रिंग जिसमें खोज करनी है, यह <code>null</code> हो सकती है।
     * @param searchStr वह स्ट्रिंग जिसे खोजना है, यह <code>null</code> हो सकती है।
     * @return खोजी गई स्ट्रिंग का पहला इंडेक्स, या -1 यदि स्ट्रिंग नहीं मिली या <code>null</code> इनपुट है।
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
        System.out.println(indexOf("Hello World", "Java")); // -1
        System.out.println(indexOf(null, "World")); // -1
        System.out.println(indexOf("Hello World", null)); // -1
    }
}