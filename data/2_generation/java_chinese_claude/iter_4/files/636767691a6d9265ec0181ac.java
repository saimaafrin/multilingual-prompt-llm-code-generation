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

        // 移除开头的./
        if (relativePath.startsWith("./")) {
            relativePath = relativePath.substring(2);
        }

        // 如果是绝对路径，直接返回
        if (relativePath.startsWith("/")) {
            return relativePath;
        }

        // 处理父目录引用 ../
        Path basePath = Paths.get(path);
        Path resolvedPath = basePath.getParent();
        if (resolvedPath == null) {
            resolvedPath = basePath;
        }
        
        resolvedPath = resolvedPath.resolve(relativePath).normalize();
        
        // 转换为标准的正斜杠格式
        return resolvedPath.toString().replace(File.separatorChar, '/');
    }
}