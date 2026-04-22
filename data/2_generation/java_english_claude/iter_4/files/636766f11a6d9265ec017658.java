import java.io.File;

public class FilenameUtils {
    
    public static int indexOfLastSeparator(String filename) {
        if (filename == null) {
            return -1;
        }
        
        // Check for both forward and back slashes
        int lastUnixPos = filename.lastIndexOf('/');
        int lastWindowsPos = filename.lastIndexOf('\\');
        
        // Return the greater of the two positions
        return Math.max(lastUnixPos, lastWindowsPos);
    }
}