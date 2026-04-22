import java.io.File;

public class PathUtils {
    /**
     * Strip the filename extension from the given path, e.g. "mypath/myfile.txt" -> "mypath/myfile".
     * @param path the file path (may be <code>null</code>)
     * @return the path with stripped filename extension,or <code>null</code> if none
     */
    public static String stripFileExtension(String path) {
        if (path == null) {
            return null;
        }
        
        int lastDot = path.lastIndexOf('.');
        int lastSeparator = Math.max(path.lastIndexOf('/'), path.lastIndexOf(File.separator));
        
        // If dot is in the last path element
        if (lastDot > lastSeparator) {
            return path.substring(0, lastDot);
        }
        
        return path;
    }
}