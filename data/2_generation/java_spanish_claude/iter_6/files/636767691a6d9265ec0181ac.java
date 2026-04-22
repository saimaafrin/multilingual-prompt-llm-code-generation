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
        
        // Si la ruta relativa comienza con /, la tratamos como ruta absoluta
        if (relativePath.startsWith("/")) {
            return relativePath;
        }
        
        // Dividir la ruta en componentes
        String[] pathComponents = path.split("/");
        String[] relativeComponents = relativePath.split("/");
        
        // Crear una lista para almacenar los componentes finales
        java.util.ArrayList<String> finalComponents = new java.util.ArrayList<>();
        
        // Agregar los componentes de la ruta base
        for (String component : pathComponents) {
            if (!component.isEmpty()) {
                finalComponents.add(component);
            }
        }
        
        // Procesar los componentes relativos
        for (String component : relativeComponents) {
            if (component.equals("..")) {
                if (!finalComponents.isEmpty()) {
                    finalComponents.remove(finalComponents.size() - 1);
                }
            } else if (!component.equals(".") && !component.isEmpty()) {
                finalComponents.add(component);
            }
        }
        
        // Construir la ruta final
        StringBuilder result = new StringBuilder();
        
        // Agregar el separador inicial si la ruta original comenzaba con uno
        if (path.startsWith("/")) {
            result.append("/");
        }
        
        // Unir los componentes con separadores
        for (int i = 0; i < finalComponents.size(); i++) {
            result.append(finalComponents.get(i));
            if (i < finalComponents.size() - 1) {
                result.append("/");
            }
        }
        
        return result.toString();
    }
}