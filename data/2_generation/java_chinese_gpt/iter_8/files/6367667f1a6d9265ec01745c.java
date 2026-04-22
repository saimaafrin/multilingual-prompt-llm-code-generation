import java.io.File;
import java.net.URL;
import java.util.Vector;

public class ClassPathAdder {

    /** 
     * 将目录中的所有jar文件添加到类路径中，表示为URL的Vector。
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
        Vector<URL> classPathVector = new Vector<>();
        addToClassPath(classPathVector, "path/to/your/directory");
        // Print the URLs added to the classpath
        classPathVector.forEach(System.out::println);
    }
}