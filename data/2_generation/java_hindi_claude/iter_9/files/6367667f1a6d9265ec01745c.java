import java.io.File;
import java.net.URL;
import java.util.Vector;

public class ClasspathUtils {
    /**
     * Add all the jar files in a dir to the classpath, represented as a Vector of URLs.
     * @param dir The directory containing jar files to add
     * @param classpath The Vector of URLs representing the classpath
     */
    public static void addJarsFromDirectory(File dir, Vector<URL> classpath) {
        if (dir == null || !dir.isDirectory() || classpath == null) {
            return;
        }

        File[] files = dir.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isFile() && file.getName().toLowerCase().endsWith(".jar")) {
                    try {
                        classpath.add(file.toURI().toURL());
                    } catch (Exception e) {
                        // Skip files that can't be converted to URLs
                        continue;
                    }
                }
            }
        }
    }
}