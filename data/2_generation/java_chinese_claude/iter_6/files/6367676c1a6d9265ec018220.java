import java.util.Objects;

public class PathUtils {
    /**
     * 从给定路径中去除文件名扩展名，例如 "mypath/myfile.txt" -> "mypath/myfile"。
     * @param path 文件路径（可能为 <code>null</code>）
     * @return 去除文件名扩展名后的路径，如果没有扩展名则返回 <code>null</code>
     */
    public static String stripFilenameExtension(String path) {
        if (path == null) {
            return null;
        }
        
        int extIndex = path.lastIndexOf('.');
        if (extIndex == -1) {
            return null;
        }
        
        int folderIndex = path.lastIndexOf('/');
        if (folderIndex > extIndex) {
            return null;
        }
        
        return path.substring(0, extIndex);
    }
}