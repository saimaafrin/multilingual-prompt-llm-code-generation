import java.nio.file.Path;
import java.nio.file.Paths;

public class RelativePathApplier {
    public static String applyRelativePath(String path, String relativePath) {
        // Convertir la ruta base a un objeto Path
        Path basePath = Paths.get(path);
        
        // Convertir la ruta relativa a un objeto Path
        Path relative = Paths.get(relativePath);
        
        // Resolver la ruta relativa contra la ruta base
        Path resolvedPath = basePath.resolve(relative);
        
        // Normalizar la ruta para eliminar redundancias como ".." o "."
        Path normalizedPath = resolvedPath.normalize();
        
        // Convertir la ruta normalizada de vuelta a una cadena
        return normalizedPath.toString();
    }

    public static void main(String[] args) {
        String basePath = "/usr/local/bin";
        String relativePath = "../lib/java";
        String result = applyRelativePath(basePath, relativePath);
        System.out.println(result);  // Output: /usr/local/lib/java
    }
}