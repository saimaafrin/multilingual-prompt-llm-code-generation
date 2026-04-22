import java.nio.file.Path;
import java.nio.file.Paths;

public class PathUtil {
    /** 
     * Apply the given relative path to the given path, assuming standard Java folder separation (i.e. "/" separators).
     * @param path the path to start from (usually a full file path)
     * @param relativePath the relative path to apply(relative to the full file path above)
     * @return the full file path that results from applying the relative path
     */
    public static String applyRelativePath(String path, String relativePath) {
        Path basePath = Paths.get(path);
        Path resolvedPath = basePath.resolveSibling(relativePath);
        return resolvedPath.toString();
    }

    public static void main(String[] args) {
        String path = "/home/user/documents";
        String relativePath = "../pictures/image.jpg";
        String result = applyRelativePath(path, relativePath);
        System.out.println(result); // Output: /home/user/pictures/image.jpg
    }
}