import java.util.Objects;

public class FileUtils {

    /**
     * 从给定路径中去除文件名扩展名，例如 "mypath/myfile.txt" -> "mypath/myfile"。
     * @param path 文件路径（可能为 <code>null</code>）
     * @return 去除文件名扩展名后的路径，如果没有扩展名则返回 <code>null</code>
     */
    public static String stripFilenameExtension(String path) {
        if (path == null) {
            return null;
        }
        
        int lastDotIndex = path.lastIndexOf('.');
        int lastSeparatorIndex = path.lastIndexOf('/');
        
        // 如果路径中没有点，或者点在路径分隔符之前（即不是文件名的一部分），则返回null
        if (lastDotIndex == -1 || (lastSeparatorIndex != -1 && lastDotIndex < lastSeparatorIndex)) {
            return null;
        }
        
        return path.substring(0, lastDotIndex);
    }

    public static void main(String[] args) {
        System.out.println(stripFilenameExtension("mypath/myfile.txt")); // 输出: mypath/myfile
        System.out.println(stripFilenameExtension("mypath/myfile"));     // 输出: null
        System.out.println(stripFilenameExtension("myfile.txt"));        // 输出: myfile
        System.out.println(stripFilenameExtension(null));                // 输出: null
    }
}