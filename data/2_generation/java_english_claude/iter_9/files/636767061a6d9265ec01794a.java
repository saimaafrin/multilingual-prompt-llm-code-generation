package org.apache.commons.io;

public class FilenameUtils {

    private static final char EXTENSION_SEPARATOR = '.';
    private static final char UNIX_SEPARATOR = '/';
    private static final char WINDOWS_SEPARATOR = '\\';

    public static int indexOfExtension(String filename) {
        if (filename == null) {
            return -1;
        }

        // Get the last directory separator position
        int lastDirSeparator = indexOfLastSeparator(filename);
        
        // Find last dot
        int lastDot = filename.lastIndexOf(EXTENSION_SEPARATOR);
        
        // If no dot found or dot is before last directory separator, return -1
        if (lastDot == -1 || lastDot < lastDirSeparator) {
            return -1;
        }
        
        return lastDot;
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