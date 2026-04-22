public class FileExtensionUtil {

    /**
     * अंतिम एक्सटेंशन सेपरेटर कैरेक्टर का इंडेक्स लौटाता है, जो कि एक डॉट है। <p> 
     * यह मेथड यह भी जांचता है कि अंतिम डॉट के बाद कोई डायरेक्टरी सेपरेटर नहीं है। 
     * ऐसा करने के लिए यह {@link #indexOfLastSeparator(String)} का उपयोग करता है, 
     * जो कि Unix या Windows फॉर्मेट में फाइल को संभालेगा। <p> 
     * आउटपुट उस मशीन के अनुसार समान होगा जिस पर कोड चल रहा है।
     * @param filename  वह फाइल का नाम जिसमें अंतिम पथ सेपरेटर को खोजना है, null पर -1 लौटाता है
     * @return अंतिम सेपरेटर कैरेक्टर का इंडेक्स, या -1 यदि ऐसा कोई कैरेक्टर नहीं है
     */
    public static int indexOfExtension(String filename) {
        if (filename == null) {
            return -1;
        }

        int lastDotIndex = filename.lastIndexOf('.');
        int lastSeparatorIndex = indexOfLastSeparator(filename);

        // Check if the last dot is after the last separator
        if (lastDotIndex > lastSeparatorIndex) {
            return lastDotIndex;
        }

        return -1;
    }

    /**
     * अंतिम पथ सेपरेटर का इंडेक्स लौटाता है। 
     * यह Unix और Windows दोनों फॉर्मेट के लिए काम करता है।
     * @param path  वह पथ जिसमें अंतिम सेपरेटर को खोजना है
     * @return अंतिम सेपरेटर का इंडेक्स, या -1 यदि ऐसा कोई सेपरेटर नहीं है
     */
    public static int indexOfLastSeparator(String path) {
        if (path == null) {
            return -1;
        }

        int lastUnixSeparator = path.lastIndexOf('/');
        int lastWindowsSeparator = path.lastIndexOf('\\');

        return Math.max(lastUnixSeparator, lastWindowsSeparator);
    }

    public static void main(String[] args) {
        // Example usage
        String filename = "example/path/to/file.txt";
        int index = indexOfExtension(filename);
        System.out.println("Last extension separator index: " + index);
    }
}