public class FileExtensionUtil {

    /**
     * Returns the index of the last extension separator character, which is a dot. <p> This method also checks that there is no directory separator after the last dot. To do this it uses  {@link #indexOfLastSeparator(String)} which will handle a file in either Unix or Windows format. <p> The output will be the same irrespective of the machine that the code is running on.
     * @param filename  the filename to find the last path separator in, null returns -1
     * @return the index of the last separator character, or -1 if there is no such character
     */
    public static int indexOfExtension(String filename) {
        if (filename == null) {
            return -1;
        }

        int lastDotIndex = filename.lastIndexOf('.');
        if (lastDotIndex == -1) {
            return -1; // No dot found
        }

        // Check for directory separators after the last dot
        int lastSeparatorIndex = indexOfLastSeparator(filename);
        if (lastSeparatorIndex > lastDotIndex) {
            return -1; // There is a directory separator after the last dot
        }

        return lastDotIndex;
    }

    private static int indexOfLastSeparator(String filename) {
        int lastUnixSeparator = filename.lastIndexOf('/');
        int lastWindowsSeparator = filename.lastIndexOf('\\');
        return Math.max(lastUnixSeparator, lastWindowsSeparator);
    }

    public static void main(String[] args) {
        // Test cases
        System.out.println(indexOfExtension("example.txt")); // Should return 7
        System.out.println(indexOfExtension("folder/example.txt")); // Should return 7
        System.out.println(indexOfExtension("folder/example.")); // Should return 7
        System.out.println(indexOfExtension("folder/example")); // Should return -1
        System.out.println(indexOfExtension("folder/example.txt/")); // Should return -1
        System.out.println(indexOfExtension(null)); // Should return -1
    }
}