public class FilenameStripper {

    /** 
     * Strip the filename extension from the given path, e.g. "mypath/myfile.txt" -&gt; "mypath/myfile".
     * @param path the file path (may be <code>null</code>)
     * @return the path with stripped filename extension, or <code>null</code> if none
     */
    public static String stripFilenameExtension(String path) {
        if (path == null) {
            return null;
        }
        
        int lastDotIndex = path.lastIndexOf('.');
        int lastSlashIndex = Math.max(path.lastIndexOf('/'), path.lastIndexOf('\\'));
        
        if (lastDotIndex > lastSlashIndex) {
            return path.substring(0, lastDotIndex);
        }
        
        return path; // No extension found
    }

    public static void main(String[] args) {
        System.out.println(stripFilenameExtension("mypath/myfile.txt")); // Output: mypath/myfile
        System.out.println(stripFilenameExtension("mypath/myfile")); // Output: mypath/myfile
        System.out.println(stripFilenameExtension(null)); // Output: null
        System.out.println(stripFilenameExtension("mypath/myfile.")); // Output: mypath/myfile
        System.out.println(stripFilenameExtension("mypath/myfile.tar.gz")); // Output: mypath/myfile.tar
    }
}