import java.io.File;
import java.net.URL;
import java.util.Vector;

public class ClassPathUtils {

    /** 
     * Agrega todos los archivos jar de un directorio al classpath, representado como un Vector de URLs.
     */
    @SuppressWarnings("unchecked")
    public static void addToClassPath(Vector<URL> cpV, String dir) {
        File directory = new File(dir);
        
        if (!directory.exists() || !directory.isDirectory()) {
            return;
        }

        File[] files = directory.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isFile() && file.getName().toLowerCase().endsWith(".jar")) {
                    try {
                        URL jarUrl = file.toURI().toURL();
                        if (!cpV.contains(jarUrl)) {
                            cpV.add(jarUrl);
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}