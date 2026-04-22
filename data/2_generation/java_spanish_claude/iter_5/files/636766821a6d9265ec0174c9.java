import java.io.File;

public class ClassPathUtils {

    /**
     * Devuelve la ruta de clases de la instancia actual de la JVM como un arreglo de objetos {@link File}.
     */
    private static File[] classPath() {
        String classPath = System.getProperty("java.class.path");
        String pathSeparator = System.getProperty("path.separator");
        String[] paths = classPath.split(pathSeparator);
        
        File[] files = new File[paths.length];
        for (int i = 0; i < paths.length; i++) {
            files[i] = new File(paths[i]);
        }
        
        return files;
    }
}