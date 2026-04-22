import java.io.File;

public class ClassPathRetriever {

    /** 
     * Returns the class path of the current JVM instance as an array of  {@link File} objects.
     */
    private static File[] classPath() {
        String classPath = System.getProperty("java.class.path");
        String[] paths = classPath.split(System.getProperty("path.separator"));
        File[] files = new File[paths.length];
        
        for (int i = 0; i < paths.length; i++) {
            files[i] = new File(paths[i]);
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