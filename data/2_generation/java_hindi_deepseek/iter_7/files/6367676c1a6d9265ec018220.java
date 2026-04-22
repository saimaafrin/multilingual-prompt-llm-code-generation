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
        int extensionIndex = path.lastIndexOf('.');
        
        // यदि कोई एक्सटेंशन नहीं है या एक्सटेंशन पथ के अंत में नहीं है
        if (extensionIndex == -1 || (lastSeparatorIndex != -1 && extensionIndex < lastSeparatorIndex)) {
            return path;
        }
        
        return path.substring(0, extensionIndex);
    }

    public static void main(String[] args) {
        System.out.println(stripFilenameExtension("mypath/myfile.txt")); // "mypath/myfile"
        System.out.println(stripFilenameExtension("mypath/myfile"));      // "mypath/myfile"
        System.out.println(stripFilenameExtension("myfile.txt"));        // "myfile"
        System.out.println(stripFilenameExtension("myfile"));            // "myfile"
        System.out.println(stripFilenameExtension(null));                // null
    }
}