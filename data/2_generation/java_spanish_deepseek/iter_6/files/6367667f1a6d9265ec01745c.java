import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Vector;

public class ClassPathUtil {

    /**
     * Agrega todos los archivos jar de un directorio al classpath, representado como un Vector de URLs.
     * 
     * @param cpV Vector de URLs que representa el classpath.
     * @param dir Directorio que contiene los archivos jar a agregar.
     */
    @SuppressWarnings("unchecked")
    public static void addToClassPath(Vector<URL> cpV, String dir) {
        File directory = new File(dir);
        if (!directory.isDirectory()) {
            throw new IllegalArgumentException("El parámetro 'dir' debe ser un directorio válido.");
        }

        File[] files = directory.listFiles((d, name) -> name.endsWith(".jar"));
        if (files != null) {
            for (File file : files) {
                try {
                    URL url = file.toURI().toURL();
                    cpV.add(url);
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
        Vector<URL> classPath = new Vector<>();
        String directoryPath = "path/to/your/jar/directory";
        addToClassPath(classPath, directoryPath);

        // Imprimir las URLs agregadas al classpath
        for (URL url : classPath) {
            System.out.println(url);
        }
    }
}