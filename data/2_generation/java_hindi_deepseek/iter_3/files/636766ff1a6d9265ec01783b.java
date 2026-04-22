/**
 * निर्दिष्ट स्ट्रिंग से उपस्ट्रिंग प्राप्त करता है, अपवादों से बचते हुए।
 * 
 * @param str   मूल स्ट्रिंग
 * @param start उपस्ट्रिंग का प्रारंभिक सूचकांक (सम्मिलित)
 * @param end   उपस्ट्रिंग का अंतिम सूचकांक (असम्मिलित)
 * @return उपस्ट्रिंग, या खाली स्ट्रिंग यदि कोई अपवाद होता है
 */
public static String sub(String str, int start, int end) {
    if (str == null) {
        return "";
    }
    try {
        return str.substring(start, end);
    } catch (IndexOutOfBoundsException e) {
        return "";
    }
}