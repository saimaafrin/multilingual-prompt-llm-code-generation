import java.io.File;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;
import java.util.List;

public class ClassPathUtil {

    /**
     * 以 {@link File} 对象数组的形式返回当前 JVM 实例的类路径。
     */
    private static File[] classPath() {
        ClassLoader classLoader = ClassLoader.getSystemClassLoader();
        List<File> classPathFiles = new ArrayList<>();

        if (classLoader instanceof URLClassLoader) {
            URLClassLoader urlClassLoader = (URLClassLoader) classLoader;
            for (URL url : urlClassLoader.getURLs()) {
                classPathFiles.add(new File(url.getFile()));
            }
        } else {
            String classPath = System.getProperty("java.class.path");
            String[] paths = classPath.split(System.getProperty("path.separator"));
            for (String path : paths) {
                classPathFiles.add(new File(path));
            }
        }

        return classPathFiles.toArray(new File[0]);
    }

    public static void main(String[] args) {
        File[] classPath = classPath();
        for (File file : classPath) {
            System.out.println(file.getAbsolutePath());
        }
    }
}