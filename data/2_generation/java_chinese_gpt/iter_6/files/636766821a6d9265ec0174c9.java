import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class ClassPathUtil {

    /**
     * 以 {@link File} 对象数组的形式返回当前 JVM 实例的类路径。
     */
    private static File[] classPath() {
        String classPath = System.getProperty("java.class.path");
        String[] paths = classPath.split(File.pathSeparator);
        List<File> fileList = new ArrayList<>();

        for (String path : paths) {
            fileList.add(new File(path));
        }

        return fileList.toArray(new File[0]);
    }

    public static void main(String[] args) {
        File[] classPathFiles = classPath();
        for (File file : classPathFiles) {
            System.out.println(file.getAbsolutePath());
        }
    }
}