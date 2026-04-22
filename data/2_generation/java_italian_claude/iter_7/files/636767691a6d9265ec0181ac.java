import java.io.File;
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
        // Normalizza i separatori di percorso
        path = path.replace('\\', '/');
        relativePath = relativePath.replace('\\', '/');
        
        // Rimuovi eventuali separatori finali
        if (path.endsWith("/")) {
            path = path.substring(0, path.length() - 1);
        }
        
        // Gestisci il caso in cui il percorso relativo inizia con "/"
        if (relativePath.startsWith("/")) {
            relativePath = relativePath.substring(1);
        }

        // Usa Path per risolvere il percorso relativo
        Path basePath = Paths.get(path);
        Path resolvedPath = basePath.resolve(relativePath).normalize();
        
        // Converti il risultato in una stringa con separatori forward slash
        return resolvedPath.toString().replace('\\', '/');
    }
}