import java.nio.file.Path;
import java.nio.file.Paths;

public class PathUtils {

    /**
     * Apply the given relative path to the given path, assuming standard Java folder separation (i.e. "/" separators).
     * @param path the path to start from (usually a full file path)
     * @param relativePath the relative path to apply(relative to the full file path above)
     * @return the full file path that results from applying the relative path
     */
    public static String applyRelativePath(String path, String relativePath) {
        // Convert the base path to a Path object
        Path basePath = Paths.get(path);
        // Resolve the relative path against the base path
        Path resolvedPath = basePath.resolve(relativePath);
        // Normalize the path to remove any redundant elements
        Path normalizedPath = resolvedPath.normalize();
        // Convert the normalized path back to a string
        return normalizedPath.toString();
    }

    public static void main(String[] args) {
        // Example usage
        String basePath = "/usr/local/bin";
        String relativePath = "../lib/java";
        String fullPath = applyRelativePath(basePath, relativePath);
        System.out.println("Full Path: " + fullPath);
    }
}