import java.io.File;
import java.net.URL;
import java.net.MalformedURLException;
import java.util.Vector;

public class ClassPathAdder {

    /** 
     * Aggiunge tutti i file jar in una directory al classpath, rappresentato come un Vector di URL.
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
                    } catch (MalformedURLException e) {
                        e.printStackTrace();
                    }
                }
            }
        } else {
            System.out.println("Directory does not exist or is not a directory: " + dir);
        }
    }

    public static void main(String[] args) {
        Vector<URL> classpath = new Vector<>();
        addToClassPath(classpath, "path/to/your/jar/directory");
        // Print the classpath URLs
        classpath.forEach(System.out::println);
    }
}