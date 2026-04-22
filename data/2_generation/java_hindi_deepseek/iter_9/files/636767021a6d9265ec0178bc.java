/**
 * एक स्ट्रिंग के भीतर पहला इंडेक्स खोजता है, <code>null</code> को संभालते हुए। यह विधि {@link String#indexOf(String)} का उपयोग करती है।
 * 
 * @param str वह स्ट्रिंग जिसमें खोज करनी है।
 * @param searchStr वह स्ट्रिंग जिसे खोजना है।
 * @return खोजी गई स्ट्रिंग का पहला इंडेक्स, या -1 यदि स्ट्रिंग नहीं मिली या <code>null</code> है।
 */
public static int indexOf(String str, String searchStr) {
    if (str == null || searchStr == null) {
        return -1;
    }
    return str.indexOf(searchStr);
}