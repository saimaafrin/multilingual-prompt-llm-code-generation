import java.io.File;
import java.net.URL;
import java.util.Vector;

public class ClassPathUtils {

    /**
     * Add all the jar files in a dir to the classpath, represented as a Vector of URLs.
     */
    @SuppressWarnings("unchecked")
    public static void addToClassPath(Vector<URL> cpV, String dir) {
        File directory = new File(dir);
        
        // Check if directory exists and is actually a directory
        if (!directory.exists() || !directory.isDirectory()) {
            return;
        }

        // Get all files in the directory
        File[] files = directory.listFiles();
        if (files == null) {
            return;
        }

        // Loop through files and add jar files to classpath vector
        for (File file : files) {
            if (file.isFile() && file.getName().toLowerCase().endsWith(".jar")) {
                try {
                    URL jarUrl = file.toURI().toURL();
                    if (!cpV.contains(jarUrl)) {
                        cpV.add(jarUrl);
                    }
                } catch (Exception e) {
                    // Skip files that can't be converted to URL
                    continue;
                }
            }
        }
    }
}