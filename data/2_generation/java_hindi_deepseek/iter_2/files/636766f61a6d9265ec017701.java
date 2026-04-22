/**
 * एक स्ट्रिंग के भीतर अंतिम अनुक्रमांक खोजता है, <code>null</code> को संभालते हुए। यह विधि {@link String#lastIndexOf(String)} का उपयोग करती है।
 * 
 * @param str वह स्ट्रिंग जिसमें खोज करनी है, यदि <code>null</code> है तो -1 लौटाता है।
 * @param searchStr वह स्ट्रिंग जिसे खोजना है, यदि <code>null</code> है तो -1 लौटाता है।
 * @return अंतिम अनुक्रमांक, यदि नहीं मिलता है तो -1 लौटाता है।
 */
public static int lastIndexOf(String str, String searchStr) {
    if (str == null || searchStr == null) {
        return -1;
    }
    return str.lastIndexOf(searchStr);
}