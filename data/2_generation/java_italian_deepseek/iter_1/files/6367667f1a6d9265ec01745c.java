import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Vector;

public class ClassPathUtil {

    /**
     * Aggiunge tutti i file jar in una directory al classpath, rappresentato come un Vector di URL.
     */
    @SuppressWarnings("unchecked")
    public static void addToClassPath(Vector<URL> cpV, String dir) {
        File directory = new File(dir);
        if (!directory.exists() || !directory.isDirectory()) {
            throw new IllegalArgumentException("La directory specificata non esiste o non è una directory valida.");
        }

        File[] files = directory.listFiles((dir1, name) -> name.endsWith(".jar"));
        if (files != null) {
            for (File file : files) {
                try {
                    URL url = file.toURI().toURL();
                    cpV.add(url);
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
        Vector<URL> classPath = new Vector<>();
        String directoryPath = "path/to/your/jar/directory";
        addToClassPath(classPath, directoryPath);

        // Stampa gli URL aggiunti al classpath
        for (URL url : classPath) {
            System.out.println(url);
        }
    }
}