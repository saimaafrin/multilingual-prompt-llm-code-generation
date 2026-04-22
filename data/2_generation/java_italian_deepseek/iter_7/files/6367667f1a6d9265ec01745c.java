import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Vector;

public class ClassPathUtil {

    /**
     * Aggiunge tutti i file jar in una directory al classpath, rappresentato come un Vector di URL.
     */
    @SuppressWarnings("unchecked")
    public static void addToClassPath(Vector<URL> cpV, String dir) {
        File directory = new File(dir);
        if (!directory.isDirectory()) {
            throw new IllegalArgumentException("Provided path is not a directory: " + dir);
        }

        File[] files = directory.listFiles((d, name) -> name.endsWith(".jar"));
        if (files != null) {
            for (File file : files) {
                try {
                    cpV.add(file.toURI().toURL());
                } catch (MalformedURLException e) {
                    throw new RuntimeException("Failed to convert file to URL: " + file.getAbsolutePath(), e);
                }
            }
        }
    }

    public static void main(String[] args) {
        Vector<URL> classPath = new Vector<>();
        addToClassPath(classPath, "path/to/your/directory");

        // Print the URLs added to the classpath
        for (URL url : classPath) {
            System.out.println(url);
        }
    }
}