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
        
        // Count how many levels to go up
        int upCount = 0;
        int relativeStartIndex = 0;
        
        for (String part : relativeParts) {
            if (part.equals("..")) {
                upCount++;
                relativeStartIndex++;
            } else if (!part.equals(".")) {
                break;
            } else {
                relativeStartIndex++;
            }
        }

        // Calculate new path length
        int newPathLength = Math.max(0, pathParts.length - upCount);
        
        // Build new path
        StringBuilder result = new StringBuilder();
        
        // Add remaining path parts
        for (int i = 0; i < newPathLength; i++) {
            result.append(pathParts[i]);
            result.append('/');
        }
        
        // Add remaining relative parts
        for (int i = relativeStartIndex; i < relativeParts.length; i++) {
            if (!relativeParts[i].equals(".") && !relativeParts[i].isEmpty()) {
                result.append(relativeParts[i]);
                if (i < relativeParts.length - 1) {
                    result.append('/');
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