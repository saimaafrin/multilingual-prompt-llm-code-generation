import java.io.File;

public class ClassPathRetriever {

    /**
     * Restituisce il percorso delle classi dell'istanza JVM corrente come un array di oggetti {@link File}.
     */
    private static File[] classPath() {
        String classPath = System.getProperty("java.class.path");
        String[] paths = classPath.split(File.pathSeparator);
        File[] classPathFiles = new File[paths.length];

        for (int i = 0; i < paths.length; i++) {
            classPathFiles[i] = new File(paths[i]);
        }

        return classPathFiles;
    }

    public static void main(String[] args) {
        File[] classPathFiles = classPath();
        for (File file : classPathFiles) {
            System.out.println(file.getAbsolutePath());
        }
    }
}