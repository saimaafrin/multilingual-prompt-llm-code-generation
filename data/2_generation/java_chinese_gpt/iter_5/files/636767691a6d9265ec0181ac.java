import java.nio.file.Path;
import java.nio.file.Paths;

public class PathUtil {
    /** 
     * 将给定的相对路径应用于给定路径，假设使用标准的Java文件夹分隔符（即“/”分隔符）。
     * @param path 起始路径（通常是完整的文件路径）
     * @param relativePath 要应用的相对路径（相对于上述完整文件路径）
     * @return 应用相对路径后得到的完整文件路径
     */
    public static String applyRelativePath(String path, String relativePath) {
        Path basePath = Paths.get(path);
        Path resolvedPath = basePath.resolveSibling(relativePath);
        return resolvedPath.toString();
    }

    public static void main(String[] args) {
        String path = "/home/user/documents";
        String relativePath = "../pictures/image.png";
        String result = applyRelativePath(path, relativePath);
        System.out.println(result); // Output: /home/user/pictures/image.png
    }
}