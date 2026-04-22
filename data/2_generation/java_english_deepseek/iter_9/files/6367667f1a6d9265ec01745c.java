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
        if (!directory.isDirectory()) {
            throw new IllegalArgumentException("The provided path is not a directory: " + dir);
        }

        File[] files = directory.listFiles((dir1, name) -> name.endsWith(".jar"));
        if (files != null) {
            for (File file : files) {
                try {
                    URL url = file.toURI().toURL();
                    cpV.add(url);
                } catch (MalformedURLException e) {
                    System.err.println("Failed to convert file to URL: " + file.getAbsolutePath());
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
        Vector<URL> classpath = new Vector<>();
        String directoryPath = "path/to/your/jar/directory";
        addToClassPath(classpath, directoryPath);

        // Print the URLs to verify
        for (URL url : classpath) {
            System.out.println(url);
        }
    }
}