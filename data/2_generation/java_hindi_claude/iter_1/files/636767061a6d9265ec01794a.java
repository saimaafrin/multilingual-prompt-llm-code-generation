import java.io.File;

public class FilenameUtils {
    
    public static int indexOfLastSeparator(String filename) {
        if (filename == null) {
            return -1;
        }
        int lastUnixPos = filename.lastIndexOf('/');
        int lastWindowsPos = filename.lastIndexOf('\\');
        return Math.max(lastUnixPos, lastWindowsPos);
    }

    public static int indexOfExtension(String filename) {
        if (filename == null) {
            return -1;
        }
        
        int extensionPos = filename.lastIndexOf('.');
        int lastSeparator = indexOfLastSeparator(filename);
        
        // Return -1 if there is no dot, or if the dot appears before the last directory separator
        if (extensionPos == -1 || lastSeparator > extensionPos) {
            return -1;
        }
        return extensionPos;
    }
}