import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Vector;

public class ClassPathUtil {

    /**
     * Add all the jar files in a dir to the classpath, represented as a Vector of URLs.
     */
    @SuppressWarnings("unchecked")
    public static void addToClassPath(Vector<URL> cpV, String dir) {
        File directory = new File(dir);
        if (!directory.exists() || !directory.isDirectory()) {
            throw new IllegalArgumentException("The provided path is not a valid directory: " + dir);
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
        String directoryPath = "path/to/your/jar/directory";
        addToClassPath(classPath, directoryPath);

        // Print the URLs to verify
        for (URL url : classPath) {
            System.out.println(url);
        }
    }
}