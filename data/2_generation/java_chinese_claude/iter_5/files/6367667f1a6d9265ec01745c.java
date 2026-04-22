import java.io.File;
import java.net.URL;
import java.util.Vector;

public class ClassPathUtils {
    
    /**
     * 将目录中的所有jar文件添加到类路径中，表示为URL的Vector。
     */
    @SuppressWarnings("unchecked")
    public static void addToClassPath(Vector<URL> cpV, String dir) {
        try {
            File directory = new File(dir);
            if (!directory.exists() || !directory.isDirectory()) {
                return;
            }

            File[] files = directory.listFiles();
            if (files != null) {
                for (File file : files) {
                    if (file.isFile() && file.getName().toLowerCase().endsWith(".jar")) {
                        URL url = file.toURI().toURL();
                        if (!cpV.contains(url)) {
                            cpV.add(url);
                        }
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}