import java.nio.file.Path;
import java.nio.file.Paths;

public class PathUtils {

    /**
     * 将给定的相对路径应用于给定路径，假设使用标准的Java文件夹分隔符（即“/”分隔符）。
     * @param path 起始路径（通常是完整的文件路径）
     * @param relativePath 要应用的相对路径（相对于上述完整文件路径）
     * @return 应用相对路径后得到的完整文件路径
     */
    public static String applyRelativePath(String path, String relativePath) {
        // 将路径转换为Path对象
        Path basePath = Paths.get(path);
        // 解析相对路径
        Path resolvedPath = basePath.resolve(relativePath);
        // 返回规范化后的路径字符串
        return resolvedPath.normalize().toString();
    }

    public static void main(String[] args) {
        String path = "/usr/local/bin";
        String relativePath = "../lib/java";
        System.out.println(applyRelativePath(path, relativePath)); // 输出: /usr/local/lib/java
    }
}