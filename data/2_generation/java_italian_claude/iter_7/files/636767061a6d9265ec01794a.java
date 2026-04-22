import java.io.File;

public class FilenameUtils {

    private static final char EXTENSION_SEPARATOR = '.';
    private static final char UNIX_SEPARATOR = '/';
    private static final char WINDOWS_SEPARATOR = '\\';

    public static int indexOfExtension(String filename) {
        if (filename == null) {
            return -1;
        }

        // Get last directory separator position
        int lastDirSeparator = indexOfLastSeparator(filename);
        
        // Get last dot position
        int lastDotPos = filename.lastIndexOf(EXTENSION_SEPARATOR);
        
        // Return -1 if:
        // - No dot found
        // - Dot is first char
        // - Dot is after last directory separator
        if (lastDotPos == -1 || lastDotPos == 0 || 
            (lastDirSeparator > -1 && lastDirSeparator > lastDotPos)) {
            return -1;
        }
        
        return lastDotPos;
    }

    public static int indexOfLastSeparator(String filename) {
        if (filename == null) {
            return -1;
        }
        
        // Find last occurrence of either separator
        int lastUnixPos = filename.lastIndexOf(UNIX_SEPARATOR);
        int lastWindowsPos = filename.lastIndexOf(WINDOWS_SEPARATOR);
        
        return Math.max(lastUnixPos, lastWindowsPos);
    }
}