import java.io.File;
import java.net.URL;
import java.net.MalformedURLException;
import java.util.Vector;

@SuppressWarnings("unchecked") 
public static void addToClassPath(Vector<URL> cpV, String dir) {
    File directory = new File(dir);
    if (!directory.exists() || !directory.isDirectory()) {
        System.err.println("Provided path is not a valid directory: " + dir);
        return;
    }

    File[] files = directory.listFiles();
    if (files != null) {
        for (File file : files) {
            if (file.isFile() && file.getName().endsWith(".jar")) {
                try {
                    URL jarUrl = file.toURI().toURL();
                    cpV.add(jarUrl);
                } catch (MalformedURLException e) {
                    System.err.println("Malformed URL for file: " + file.getName());
                }
            }
        }
    }
}