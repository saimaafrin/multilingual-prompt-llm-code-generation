import java.io.File;
import java.net.URL;
import java.util.Vector;

public class ClassPathAdder {

    /** 
     * Add all the jar files in a dir to the classpath, represented as a Vector of URLs.
     */
    @SuppressWarnings("unchecked") 
    public static void addToClassPath(Vector<URL> cpV, String dir) {
        File directory = new File(dir);
        if (directory.exists() && directory.isDirectory()) {
            File[] files = directory.listFiles((d, name) -> name.endsWith(".jar"));
            if (files != null) {
                for (File file : files) {
                    try {
                        cpV.add(file.toURI().toURL());
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        } else {
            System.out.println("The specified directory does not exist or is not a directory.");
        }
    }

    public static void main(String[] args) {
        Vector<URL> classpath = new Vector<>();
        addToClassPath(classpath, "path/to/your/jar/directory");
        // Print the classpath URLs
        classpath.forEach(System.out::println);
    }
}