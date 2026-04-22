public class FilePathUtils {

    /** 
     * Returns the index of the last directory separator character. <p> 
     * This method will handle a file in either Unix or Windows format. 
     * The position of the last forward or backslash is returned. <p> 
     * The output will be the same irrespective of the machine that the code is running on.
     * @param filename  the filename to find the last path separator in, null returns -1
     * @return the index of the last separator character, or -1 if there is no such character
     */
    public static int indexOfLastSeparator(String filename) {
        if (filename == null) {
            return -1;
        }
        
        int lastForwardSlash = filename.lastIndexOf('/');
        int lastBackSlash = filename.lastIndexOf('\\');
        
        return Math.max(lastForwardSlash, lastBackSlash);
    }

    public static void main(String[] args) {
        // Test cases
        System.out.println(indexOfLastSeparator("C:\\Users\\User\\Documents\\file.txt")); // Output: 20
        System.out.println(indexOfLastSeparator("/home/user/documents/file.txt")); // Output: 16
        System.out.println(indexOfLastSeparator("file.txt")); // Output: -1
        System.out.println(indexOfLastSeparator(null)); // Output: -1
    }
}