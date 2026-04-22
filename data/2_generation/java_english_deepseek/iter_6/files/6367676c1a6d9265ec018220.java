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

        // If there's no dot or the dot is before the last separator, return the original path
        if (lastDotIndex == -1 || (lastSeparatorIndex != -1 && lastDotIndex < lastSeparatorIndex)) {
            return path;
        }

        // Otherwise, strip the extension
        return path.substring(0, lastDotIndex);
    }

    public static void main(String[] args) {
        String path1 = "mypath/myfile.txt";
        String path2 = "mypath/myfile";
        String path3 = null;

        System.out.println(stripFilenameExtension(path1)); // Output: mypath/myfile
        System.out.println(stripFilenameExtension(path2)); // Output: mypath/myfile
        System.out.println(stripFilenameExtension(path3)); // Output: null
    }
}