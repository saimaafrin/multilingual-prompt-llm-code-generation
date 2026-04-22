import java.io.File;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;
import java.util.List;

public class ClassPathUtil {
    /**
     * 以 {@link File} 对象数组的形式返回当前 JVM 实例的类路径。
     */
    private static File[] classPath() {
        List<File> files = new ArrayList<>();
        
        // Get system class loader
        ClassLoader systemClassLoader = ClassLoader.getSystemClassLoader();
        
        // Check if it's URLClassLoader
        if (systemClassLoader instanceof URLClassLoader) {
            URLClassLoader urlClassLoader = (URLClassLoader) systemClassLoader;
            
            // Get all URLs from class loader
            URL[] urls = urlClassLoader.getURLs();
            
            // Convert URLs to File objects
            for (URL url : urls) {
                try {
                    files.add(new File(url.toURI()));
                } catch (Exception e) {
                    // Skip invalid URLs
                    continue;
                }
            }
        }
        
        // Get additional classpath entries from system property
        String classPath = System.getProperty("java.class.path");
        if (classPath != null) {
            String[] paths = classPath.split(File.pathSeparator);
            for (String path : paths) {
                files.add(new File(path));
            }
        }
        
        return files.toArray(new File[0]);
    }
}