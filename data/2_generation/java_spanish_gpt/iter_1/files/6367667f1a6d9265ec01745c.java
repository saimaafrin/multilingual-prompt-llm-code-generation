import java.io.File;
import java.net.URL;
import java.net.MalformedURLException;
import java.util.Vector;

public class ClassPathAdder {

    /** 
     * Agrega todos los archivos jar de un directorio al classpath, representado como un Vector de URLs.
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
            System.out.println("El directorio no existe o no es un directorio válido.");
        }
    }

    public static void main(String[] args) {
        Vector<URL> classpath = new Vector<>();
        addToClassPath(classpath, "ruta/al/directorio/de/jars");
        // Imprimir el classpath para verificar
        classpath.forEach(System.out::println);
    }
}