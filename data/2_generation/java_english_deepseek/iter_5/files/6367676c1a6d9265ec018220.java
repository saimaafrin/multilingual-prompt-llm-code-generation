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
        int lastDotIndex = path.lastIndexOf('.');

        // If there is no dot or the dot is before the last separator, return the original path
        if (lastDotIndex == -1 || (lastSeparatorIndex != -1 && lastDotIndex < lastSeparatorIndex)) {
            return path;
        }

        // Return the substring up to the last dot
        return path.substring(0, lastDotIndex);
    }

    public static void main(String[] args) {
        System.out.println(stripFilenameExtension("mypath/myfile.txt")); // Output: mypath/myfile
        System.out.println(stripFilenameExtension("mypath/myfile"));    // Output: mypath/myfile
        System.out.println(stripFilenameExtension("myfile.txt"));        // Output: myfile
        System.out.println(stripFilenameExtension(null));                // Output: null
    }
}