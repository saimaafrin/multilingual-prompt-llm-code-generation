import java.io.File;
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
        // Normalize path separators
        path = path.replace('\\', '/');
        relativePath = relativePath.replace('\\', '/');
        
        // Handle empty cases
        if (path == null || path.isEmpty()) {
            return relativePath;
        }
        if (relativePath == null || relativePath.isEmpty()) {
            return path;
        }

        // Convert to Path objects for proper resolution
        Path basePath = Paths.get(path);
        Path relPath = Paths.get(relativePath);
        
        // If relativePath is absolute, return it directly
        if (relPath.isAbsolute()) {
            return relativePath;
        }
        
        // Resolve the paths and normalize
        Path resolvedPath = basePath.resolveSibling(relPath).normalize();
        
        // Convert back to string with forward slashes
        return resolvedPath.toString().replace(File.separatorChar, '/');
    }
}