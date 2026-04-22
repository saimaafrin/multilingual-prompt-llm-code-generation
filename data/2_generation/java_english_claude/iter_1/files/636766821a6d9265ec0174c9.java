import java.io.File;

public class ClassPathUtil {
    /**
     * Returns the class path of the current JVM instance as an array of {@link File} objects.
     */
    private static File[] classPath() {
        String classPath = System.getProperty("java.class.path");
        String pathSeparator = System.getProperty("path.separator");
        String[] pathElements = classPath.split(pathSeparator);
        
        File[] result = new File[pathElements.length];
        for (int i = 0; i < pathElements.length; i++) {
            result[i] = new File(pathElements[i]);
        }
        
        return result;
    }
}