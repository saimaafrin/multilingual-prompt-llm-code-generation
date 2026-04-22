import java.io.File;
import java.net.URL;
import java.net.URLClassLoader;

public class ClassPathExample {

    /**
     * 以 {@link File} 对象数组的形式返回当前 JVM 实例的类路径。
     */
    private static File[] classPath() {
        URL[] urls = ((URLClassLoader) ClassLoader.getSystemClassLoader()).getURLs();
        File[] files = new File[urls.length];
        
        for (int i = 0; i < urls.length; i++) {
            files[i] = new File(urls[i].getFile());
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