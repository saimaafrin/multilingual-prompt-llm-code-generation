import java.nio.file.Path;
import java.nio.file.Paths;

public class PathUtil {
    /** 
     * Aplica la ruta relativa dada a la ruta proporcionada, asumiendo la separación estándar de carpetas en Java (es decir, separadores "/").
     * @param path la ruta desde la cual comenzar (generalmente una ruta de archivo completa)
     * @param relativePath la ruta relativa a aplicar (en relación con la ruta de archivo completa anterior)
     * @return la ruta de archivo completa que resulta de aplicar la ruta relativa
     */
    public static String applyRelativePath(String path, String relativePath) {
        Path basePath = Paths.get(path);
        Path resolvedPath = basePath.resolveSibling(relativePath);
        return resolvedPath.toString();
    }

    public static void main(String[] args) {
        String path = "/home/user/documents";
        String relativePath = "projects/java";
        String result = applyRelativePath(path, relativePath);
        System.out.println(result); // Output: /home/user/projects/java
    }
}