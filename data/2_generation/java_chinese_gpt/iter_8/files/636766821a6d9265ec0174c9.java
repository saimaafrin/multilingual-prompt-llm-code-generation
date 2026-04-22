import java.io.File;
import java.net.URL;
import java.net.URLClassLoader;

public class ClassPathRetriever {

    /**
     * 以 {@link File} 对象数组的形式返回当前 JVM 实例的类路径。
     */
    private static File[] classPath() {
        URL[] urls = ((URLClassLoader) ClassLoader.getSystemClassLoader()).getURLs();
        File[] classPathFiles = new File[urls.length];
        
        for (int i = 0; i < urls.length; i++) {
            classPathFiles[i] = new File(urls[i].getFile());
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