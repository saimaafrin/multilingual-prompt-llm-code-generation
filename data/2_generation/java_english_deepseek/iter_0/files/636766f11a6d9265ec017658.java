public class FileUtils {

    /**
     * Returns the index of the last directory separator character. <p> This method will handle a file in either Unix or Windows format. The position of the last forward or backslash is returned. <p> The output will be the same irrespective of the machine that the code is running on.
     * @param filename  the filename to find the last path separator in, null returns -1
     * @return the index of the last separator character, or -1 if there is no such character
     */
    public static int indexOfLastSeparator(String filename) {
        if (filename == null) {
            return -1;
        }
        int lastUnixPos = filename.lastIndexOf('/');
        int lastWindowsPos = filename.lastIndexOf('\\');
        return Math.max(lastUnixPos, lastWindowsPos);
    }

    public static void main(String[] args) {
        // Example usage
        String filename1 = "C:\\Users\\John\\Documents\\file.txt";
        String filename2 = "/home/user/documents/file.txt";
        String filename3 = "file.txt";

        System.out.println(indexOfLastSeparator(filename1)); // Output: 20
        System.out.println(indexOfLastSeparator(filename2)); // Output: 18
        System.out.println(indexOfLastSeparator(filename3)); // Output: -1
    }
}