public class SubstringExample {
    /**
     * निर्दिष्ट स्ट्रिंग से उपस्ट्रिंग प्राप्त करता है, अपवादों से बचते हुए।
     * 
     * @param str   मूल स्ट्रिंग
     * @param start उपस्ट्रिंग का प्रारंभिक सूचकांक
     * @param end   उपस्ट्रिंग का अंतिम सूचकांक
     * @return उपस्ट्रिंग, यदि सूचकांक मान्य हैं; अन्यथा, एक खाली स्ट्रिंग
     */
    public static String sub(String str, int start, int end) {
        if (str == null) {
            return "";
        }
        int length = str.length();
        if (start < 0 || end > length || start > end) {
            return "";
        }
        return str.substring(start, end);
    }

    public static void main(String[] args) {
        String str = "Hello, World!";
        System.out.println(sub(str, 7, 12)); // Output: World
        System.out.println(sub(str, -1, 5));  // Output: (empty string)
        System.out.println(sub(str, 5, 20));  // Output: (empty string)
        System.out.println(sub(null, 0, 5));  // Output: (empty string)
    }
}