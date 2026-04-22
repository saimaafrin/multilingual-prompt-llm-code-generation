import java.io.File;

public class ClassPathUtil {

    /**
     * Devuelve la ruta de clases de la instancia actual de la JVM como un arreglo de objetos {@link File}.
     */
    private static File[] classPath() {
        String classPath = System.getProperty("java.class.path");
        String[] pathElements = classPath.split(System.getProperty("path.separator"));
        File[] files = new File[pathElements.length];
        
        for (int i = 0; i < pathElements.length; i++) {
            files[i] = new File(pathElements[i]);
        }
        
        return files;
    }

    public static void main(String[] args) {
        File[] classPathFiles = classPath();
        for (File file : classPathFiles) {
            System.out.println(file.getAbsolutePath());
        }
    }
}