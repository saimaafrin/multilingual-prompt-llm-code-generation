import java.io.File;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.Vector;

public class ClassPathUtil {

    /**
     * किसी निर्देशिका में सभी जार फ़ाइलों को क्लासपाथ में जोड़ें, जिसे URL के एक वेक्टर के रूप में दर्शाया गया है।
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
                    URL url = file.toURI().toURL();
                    cpV.add(url);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
        Vector<URL> classPath = new Vector<>();
        String directoryPath = "path/to/your/directory";
        addToClassPath(classPath, directoryPath);

        // Example of using the class loader with the updated classpath
        URLClassLoader classLoader = new URLClassLoader(classPath.toArray(new URL[0]));
        Thread.currentThread().setContextClassLoader(classLoader);

        // Now you can load classes from the added JAR files
    }
}