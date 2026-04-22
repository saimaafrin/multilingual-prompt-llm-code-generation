import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Vector;

public class ClassPathUtil {

    /**
     * Agrega todos los archivos jar de un directorio al classpath, representado como un Vector de URLs.
     */
    @SuppressWarnings("unchecked")
    public static void addToClassPath(Vector<URL> cpV, String dir) {
        File directory = new File(dir);
        if (!directory.exists() || !directory.isDirectory()) {
            throw new IllegalArgumentException("El directorio proporcionado no existe o no es un directorio válido.");
        }

        File[] files = directory.listFiles((d, name) -> name.endsWith(".jar"));
        if (files != null) {
            for (File file : files) {
                try {
                    URL url = file.toURI().toURL();
                    cpV.add(url);
                } catch (MalformedURLException e) {
                    throw new RuntimeException("Error al convertir el archivo a URL: " + file.getAbsolutePath(), e);
                }
            }
        }
    }
}