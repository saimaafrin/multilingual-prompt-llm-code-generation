import java.io.File;

public class ClassPathUtil {
    /**
     * Returns the class path of the current JVM instance as an array of {@link File} objects.
     */
    private static File[] classPath() {
        // Get the class path string from system property
        String classPathString = System.getProperty("java.class.path");
        
        // Split the class path string by path separator
        String[] paths = classPathString.split(File.pathSeparator);
        
        // Convert string paths to File objects
        File[] classPathFiles = new File[paths.length];
        for (int i = 0; i < paths.length; i++) {
            classPathFiles[i] = new File(paths[i]);
        }
        
        return classPathFiles;
    }
}