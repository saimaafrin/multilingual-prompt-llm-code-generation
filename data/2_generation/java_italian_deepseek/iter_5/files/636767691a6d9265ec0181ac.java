import java.nio.file.Path;
import java.nio.file.Paths;

public class PathUtils {

    /**
     * Applica il percorso relativo fornito al percorso dato, assumendo la separazione standard delle cartelle Java (cioè i separatori "/").
     * @param path il percorso da cui partire (di solito un percorso di file completo)
     * @param relativePath il percorso relativo da applicare (rispetto al percorso di file completo sopra)
     * @return il percorso di file completo che risulta dall'applicazione del percorso relativo
     */
    public static String applyRelativePath(String path, String relativePath) {
        // Convert the base path to a Path object
        Path basePath = Paths.get(path);
        
        // Convert the relative path to a Path object
        Path relative = Paths.get(relativePath);
        
        // Resolve the relative path against the base path
        Path resolvedPath = basePath.resolve(relative);
        
        // Normalize the path to remove any redundant elements
        Path normalizedPath = resolvedPath.normalize();
        
        // Return the normalized path as a string
        return normalizedPath.toString();
    }

    public static void main(String[] args) {
        // Example usage
        String basePath = "/usr/local/bin";
        String relativePath = "../lib/java";
        String result = applyRelativePath(basePath, relativePath);
        System.out.println(result);  // Output: /usr/local/lib/java
    }
}