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
        // Converti il percorso di base in un oggetto Path
        Path basePath = Paths.get(path);
        
        // Converti il percorso relativo in un oggetto Path
        Path relative = Paths.get(relativePath);
        
        // Risolvi il percorso relativo rispetto al percorso di base
        Path resolvedPath = basePath.resolve(relative);
        
        // Normalizza il percorso per rimuovere eventuali ridondanze
        Path normalizedPath = resolvedPath.normalize();
        
        // Restituisci il percorso come stringa
        return normalizedPath.toString();
    }

    public static void main(String[] args) {
        String basePath = "/usr/local/bin";
        String relativePath = "../lib/java";
        String result = applyRelativePath(basePath, relativePath);
        System.out.println(result);  // Output: /usr/local/lib/java
    }
}