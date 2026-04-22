import java.util.Objects;

public class PathUtils {

    /**
     * Strip the filename extension from the given path, e.g. "mypath/myfile.txt" -> "mypath/myfile".
     * @param path the file path (may be <code>null</code>)
     * @return the path with stripped filename extension,or <code>null</code> if none
     */
    public static String stripFilenameExtension(String path) {
        if (path == null) {
            return null;
        }
        
        int extIndex = path.lastIndexOf('.');
        if (extIndex == -1) {
            return path;
        }

        int sepIndex = path.lastIndexOf('/');
        if (sepIndex > extIndex) {
            return path;
        }
        
        return path.substring(0, extIndex);
    }
}