import java.io.File;

public class ClassPathUtils {
    /**
     * Returns the class path of the current JVM instance as an array of {@link File} objects.
     * @return Array of File objects representing the classpath entries
     */
    public static File[] getClassPath() {
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