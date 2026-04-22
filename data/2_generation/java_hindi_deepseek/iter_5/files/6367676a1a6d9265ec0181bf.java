public class StringQuoter {

    /**
     * दिए गए ऑब्जेक्ट को एक स्ट्रिंग में बदलें यदि यह एक स्ट्रिंग है; अन्यथा ऑब्जेक्ट को जैसा है वैसा ही रखें।
     * @param obj इनपुट ऑब्जेक्ट (जैसे "myString")
     * @return उद्धृत स्ट्रिंग (जैसे "'myString'"), या यदि यह स्ट्रिंग नहीं है तो इनपुट ऑब्जेक्ट को जैसा है वैसा ही
     */
    public static Object quoteIfString(Object obj) {
        if (obj instanceof String) {
            return "'" + obj + "'";
        }
        return obj;
    }

    public static void main(String[] args) {
        // Test cases
        System.out.println(quoteIfString("Hello")); // Output: 'Hello'
        System.out.println(quoteIfString(123));    // Output: 123
        System.out.println(quoteIfString(true));    // Output: true
    }
}