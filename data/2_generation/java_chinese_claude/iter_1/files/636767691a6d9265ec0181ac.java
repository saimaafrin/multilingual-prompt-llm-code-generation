import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

public class PathUtils {
    /**
     * 将给定的相对路径应用于给定路径，假设使用标准的Java文件夹分隔符（即"/"分隔符）。
     * @param path 起始路径（通常是完整的文件路径）
     * @param relativePath 要应用的相对路径（相对于上述完整文件路径）
     * @return 应用相对路径后得到的完整文件路径
     */
    public static String applyRelativePath(String path, String relativePath) {
        if (path == null || relativePath == null) {
            return null;
        }

        // 标准化路径分隔符
        path = path.replace('\\', '/');
        relativePath = relativePath.replace('\\', '/');

        // 如果relativePath是绝对路径，直接返回
        if (relativePath.startsWith("/")) {
            return relativePath;
        }

        // 使用Path API处理路径
        Path basePath = Paths.get(path);
        
        // 如果path是文件，获取其父目录
        if (!path.endsWith("/")) {
            basePath = basePath.getParent();
        }

        if (basePath == null) {
            basePath = Paths.get("");
        }

        // 解析并规范化路径
        Path resolvedPath = basePath.resolve(relativePath).normalize();
        
        // 转换为字符串并确保使用正斜杠
        return resolvedPath.toString().replace('\\', '/');
    }
}