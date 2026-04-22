import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

public class PathUtils {
    
    public static String applyRelativePath(String path, String relativePath) {
        if (path == null || relativePath == null) {
            return null;
        }

        // Convert backslashes to forward slashes
        path = path.replace('\\', '/');
        relativePath = relativePath.replace('\\', '/');

        // Remove trailing slashes
        if (path.endsWith("/")) {
            path = path.substring(0, path.length() - 1);
        }

        // Handle empty relative path
        if (relativePath.isEmpty()) {
            return path;
        }

        // Handle absolute relative path
        if (relativePath.startsWith("/")) {
            return relativePath;
        }

        // Split the paths into components
        String[] pathParts = path.split("/");
        String[] relativeParts = relativePath.split("/");

        // Count number of "../" at start of relative path
        int backCount = 0;
        for (String part : relativeParts) {
            if (part.equals("..")) {
                backCount++;
            } else {
                break;
            }
        }

        // Build result path
        StringBuilder result = new StringBuilder();
        
        // Add path components minus the number of "../"
        for (int i = 0; i < pathParts.length - backCount; i++) {
            result.append(pathParts[i]).append("/");
        }

        // Add remaining relative path components
        for (int i = backCount; i < relativeParts.length; i++) {
            if (!relativeParts[i].equals(".") && !relativeParts[i].isEmpty()) {
                result.append(relativeParts[i]);
                if (i < relativeParts.length - 1) {
                    result.append("/");
                }
            }
        }

        // Remove trailing slash if present
        if (result.length() > 0 && result.charAt(result.length() - 1) == '/') {
            result.setLength(result.length() - 1);
        }

        return result.toString();
    }
}