import java.util.Objects;

public class FileUtils {

    /**
     * Strip the filename extension from the given path, e.g. "mypath/myfile.txt" -> "mypath/myfile".
     * @param path the file path (may be <code>null</code>)
     * @return the path with stripped filename extension, or <code>null</code> if none
     */
    public static String stripFilenameExtension(String path) {
        if (path == null) {
            return null;
        }
        
        int lastSeparatorIndex = path.lastIndexOf('/');
        int lastExtensionIndex = path.lastIndexOf('.');

        if (lastExtensionIndex == -1 || (lastSeparatorIndex != -1 && lastExtensionIndex < lastSeparatorIndex)) {
            return path;
        }

        return path.substring(0, lastExtensionIndex);
    }

    public static void main(String[] args) {
        System.out.println(stripFilenameExtension("mypath/myfile.txt")); // Output: mypath/myfile
        System.out.println(stripFilenameExtension("myfile.txt"));       // Output: myfile
        System.out.println(stripFilenameExtension("mypath/myfile"));    // Output: mypath/myfile
        System.out.println(stripFilenameExtension(null));               // Output: null
    }
}