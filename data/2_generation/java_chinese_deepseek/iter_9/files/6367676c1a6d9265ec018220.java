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
        int extIndex = path.lastIndexOf(".");
        if (extIndex == -1) {
            return path;
        }
        int lastSeparatorIndex = path.lastIndexOf("/");
        if (lastSeparatorIndex > extIndex) {
            return path;
        }
        return path.substring(0, extIndex);
    }

    public static void main(String[] args) {
        System.out.println(stripFilenameExtension("mypath/myfile.txt")); // 输出: mypath/myfile
        System.out.println(stripFilenameExtension("mypath/myfile"));     // 输出: mypath/myfile
        System.out.println(stripFilenameExtension(null));                // 输出: null
    }
}