import java.util.Objects;

public class FileUtils {
    public static String stripFilenameExtension(String path) {
        if (path == null) {
            return null;
        }
        
        int lastSeparatorIndex = path.lastIndexOf('/');
        int lastDotIndex = path.lastIndexOf('.');

        // If there is no dot or the dot is before the last separator, return the original path
        if (lastDotIndex == -1 || (lastSeparatorIndex != -1 && lastDotIndex < lastSeparatorIndex)) {
            return path;
        }

        // Return the path without the extension
        return path.substring(0, lastDotIndex);
    }

    public static void main(String[] args) {
        System.out.println(stripFilenameExtension("mypath/myfile.txt")); // Output: mypath/myfile
        System.out.println(stripFilenameExtension("mypath/myfile"));    // Output: mypath/myfile
        System.out.println(stripFilenameExtension(null));               // Output: null
    }
}