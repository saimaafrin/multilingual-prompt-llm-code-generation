import java.io.File;

public class FilenameUtils {
    
    public static int indexOfExtension(String filename) {
        if (filename == null) {
            return -1;
        }
        
        int extensionPos = filename.lastIndexOf('.');
        int lastSeparator = indexOfLastSeparator(filename);
        
        if (lastSeparator > extensionPos) {
            return -1;
        }
        return extensionPos;
    }
    
    public static int indexOfLastSeparator(String filename) {
        if (filename == null) {
            return -1;
        }
        
        int lastUnixPos = filename.lastIndexOf('/');
        int lastWindowsPos = filename.lastIndexOf('\\');
        
        return Math.max(lastUnixPos, lastWindowsPos);
    }
}