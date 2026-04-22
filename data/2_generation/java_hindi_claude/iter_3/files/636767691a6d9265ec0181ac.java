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

        // Build new path
        StringBuilder result = new StringBuilder();

        // Add path components minus the number of ".." references
        int pathComponentsToKeep = Math.max(0, pathParts.length - backCount);
        for (int i = 0; i < pathComponentsToKeep; i++) {
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