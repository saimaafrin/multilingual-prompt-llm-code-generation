import java.util.Objects;

public class FileUtils {
    /**
     * दिए गए पथ से फ़ाइल नाम का एक्सटेंशन हटा दें, जैसे "mypath/myfile.txt" -> "mypath/myfile"।
     * @param path फ़ाइल का पथ (यह <code>null</code> हो सकता है)
     * @return फ़ाइल नाम के एक्सटेंशन के बिना पथ, या <code>null</code> यदि कोई नहीं है
     */
    public static String stripFilenameExtension(String path) {
        if (path == null) {
            return null;
        }
        
        int lastSeparatorIndex = path.lastIndexOf('/');
        int lastDotIndex = path.lastIndexOf('.');

        // यदि कोई डॉट नहीं है या डॉट अंतिम सेपरेटर से पहले है, तो एक्सटेंशन नहीं है
        if (lastDotIndex == -1 || (lastSeparatorIndex != -1 && lastDotIndex < lastSeparatorIndex)) {
            return path;
        }

        // एक्सटेंशन को हटा दें
        return path.substring(0, lastDotIndex);
    }

    public static void main(String[] args) {
        System.out.println(stripFilenameExtension("mypath/myfile.txt")); // "mypath/myfile"
        System.out.println(stripFilenameExtension("myfile.txt"));       // "myfile"
        System.out.println(stripFilenameExtension("mypath/myfile"));    // "mypath/myfile"
        System.out.println(stripFilenameExtension(null));               // null
    }
}