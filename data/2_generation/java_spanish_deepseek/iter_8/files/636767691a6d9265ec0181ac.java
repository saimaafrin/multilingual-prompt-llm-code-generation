import java.nio.file.Path;
import java.nio.file.Paths;

public class RelativePathApplier {

    /**
     * Aplica la ruta relativa dada a la ruta proporcionada, asumiendo la separación estándar de carpetas en Java (es decir, separadores "/").
     * @param path la ruta desde la cual comenzar (generalmente una ruta de archivo completa)
     * @param relativePath la ruta relativa a aplicar (en relación con la ruta de archivo completa anterior)
     * @return la ruta de archivo completa que resulta de aplicar la ruta relativa
     */
    public static String applyRelativePath(String path, String relativePath) {
        // Convertir la ruta base a un objeto Path
        Path basePath = Paths.get(path);
        
        // Aplicar la ruta relativa a la ruta base
        Path resolvedPath = basePath.resolve(relativePath);
        
        // Normalizar la ruta resultante para eliminar redundancias como ".." o "."
        Path normalizedPath = resolvedPath.normalize();
        
        // Convertir la ruta normalizada de vuelta a una cadena
        return normalizedPath.toString();
    }

    public static void main(String[] args) {
        // Ejemplo de uso
        String basePath = "/usr/local/bin";
        String relativePath = "../lib/java";
        String result = applyRelativePath(basePath, relativePath);
        System.out.println(result);  // Imprime: /usr/local/lib/java
    }
}