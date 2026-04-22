public class FilePathUtil {
    
    /** 
     * दिए गए पथ से फ़ाइल नाम का एक्सटेंशन हटा दें, जैसे "mypath/myfile.txt" -&gt; "mypath/myfile"।
     * @param path फ़ाइल का पथ (यह <code>null</code> हो सकता है)
     * @return फ़ाइल नाम के एक्सटेंशन के बिना पथ, या <code>null</code> यदि कोई नहीं है
     */
    public static String stripFilenameExtension(String path) {
        if (path == null) {
            return null;
        }
        
        int lastDotIndex = path.lastIndexOf('.');
        int lastSlashIndex = Math.max(path.lastIndexOf('/'), path.lastIndexOf('\\'));
        
        if (lastDotIndex > lastSlashIndex) {
            return path.substring(0, lastDotIndex);
        }
        
        return path; // No extension found
    }

    public static void main(String[] args) {
        String path = "mypath/myfile.txt";
        String result = stripFilenameExtension(path);
        System.out.println(result); // Output: mypath/myfile
    }
}