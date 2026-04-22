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
        Vector<URL> classpathVector = new Vector<>();
        addToClassPath(classpathVector, "path/to/your/jar/directory");
        // Print the URLs added to the classpath
        classpathVector.forEach(System.out::println);
    }
}