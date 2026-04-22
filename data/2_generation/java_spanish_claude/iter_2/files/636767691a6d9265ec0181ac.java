import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

public class PathUtils {

    /**
     * Aplica la ruta relativa dada a la ruta proporcionada, asumiendo la separación estándar de carpetas en Java (es decir, separadores "/").
     * @param path la ruta desde la cual comenzar (generalmente una ruta de archivo completa)
     * @param relativePath la ruta relativa a aplicar (en relación con la ruta de archivo completa anterior)
     * @return la ruta de archivo completa que resulta de aplicar la ruta relativa
     */
    public static String applyRelativePath(String path, String relativePath) {
        // Normalizar los separadores de ruta
        path = path.replace('\\', '/');
        relativePath = relativePath.replace('\\', '/');
        
        // Eliminar el separador final si existe
        if (path.endsWith("/")) {
            path = path.substring(0, path.length() - 1);
        }
        
        // Si la ruta relativa comienza con /, tratarla como ruta absoluta
        if (relativePath.startsWith("/")) {
            return relativePath;
        }
        
        // Dividir la ruta relativa en componentes
        String[] components = relativePath.split("/");
        
        // Convertir la ruta base a Path
        Path basePath = Paths.get(path);
        
        // Procesar cada componente de la ruta relativa
        for (String component : components) {
            if (component.equals("..")) {
                basePath = basePath.getParent();
                if (basePath == null) {
                    return "/";
                }
            } else if (!component.equals(".") && !component.isEmpty()) {
                basePath = basePath.resolve(component);
            }
        }
        
        // Convertir el resultado final a String y normalizar los separadores
        return basePath.toString().replace('\\', '/');
    }
}