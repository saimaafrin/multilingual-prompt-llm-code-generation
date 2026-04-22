import java.io.File;
import java.net.URL;
import java.util.Vector;

public class ClassPathUtils {
    
    /**
     * 将目录中的所有jar文件添加到类路径中，表示为URL的Vector。
     */
    @SuppressWarnings("unchecked")
    public static void addToClassPath(Vector<URL> cpV, String dir) {
        File directory = new File(dir);
        
        // 检查目录是否存在且是目录
        if (!directory.exists() || !directory.isDirectory()) {
            return;
        }
        
        // 获取目录中所有文件
        File[] files = directory.listFiles();
        if (files == null) {
            return;
        }
        
        try {
            // 遍历所有文件
            for (File file : files) {
                // 如果是jar文件
                if (file.getName().toLowerCase().endsWith(".jar")) {
                    // 将jar文件转换为URL并添加到Vector中
                    URL url = file.toURI().toURL();
                    if (!cpV.contains(url)) {
                        cpV.add(url);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}