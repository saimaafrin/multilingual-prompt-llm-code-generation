import java.io.File;

public class FileUtils {

    /**
     * अंतिम एक्सटेंशन सेपरेटर कैरेक्टर का इंडेक्स लौटाता है, जो कि एक डॉट है। <p> यह मेथड यह भी जांचता है कि अंतिम डॉट के बाद कोई डायरेक्टरी सेपरेटर नहीं है। ऐसा करने के लिए यह {@link #indexOfLastSeparator(String)} का उपयोग करता है, जो कि Unix या Windows फॉर्मेट में फाइल को संभालेगा। <p> आउटपुट उस मशीन के अनुसार समान होगा जिस पर कोड चल रहा है।
     * @param filename  वह फाइल का नाम जिसमें अंतिम पथ सेपरेटर को खोजना है, null पर -1 लौटाता है
     * @return अंतिम सेपरेटर कैरेक्टर का इंडेक्स, या -1 यदि ऐसा कोई कैरेक्टर नहीं है
     */
    public static int indexOfExtension(String filename) {
        if (filename == null) {
            return -1;
        }

        int lastSeparatorIndex = indexOfLastSeparator(filename);
        int extensionIndex = filename.lastIndexOf('.');

        if (lastSeparatorIndex > extensionIndex) {
            return -1;
        }

        return extensionIndex;
    }

    private static int indexOfLastSeparator(String filename) {
        if (filename == null) {
            return -1;
        }

        int lastUnixPos = filename.lastIndexOf('/');
        int lastWindowsPos = filename.lastIndexOf('\\');

        return Math.max(lastUnixPos, lastWindowsPos);
    }

    public static void main(String[] args) {
        String filename = "path/to/file.txt";
        System.out.println(indexOfExtension(filename)); // Output: 13
    }
}