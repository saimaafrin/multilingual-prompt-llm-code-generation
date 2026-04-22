public class FilePathUtil {

    /** 
     * 从给定路径中去除文件名扩展名，例如 "mypath/myfile.txt" -&gt; "mypath/myfile"。
     * @param path 文件路径（可能为 <code>null</code>）
     * @return 去除文件名扩展名后的路径，如果没有扩展名则返回 <code>null</code>
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
        
        return null;
    }

    public static void main(String[] args) {
        System.out.println(stripFilenameExtension("mypath/myfile.txt")); // Output: mypath/myfile
        System.out.println(stripFilenameExtension("mypath/myfile"));     // Output: null
        System.out.println(stripFilenameExtension(null));                // Output: null
    }
}