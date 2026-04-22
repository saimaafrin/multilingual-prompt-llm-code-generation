import java.io.File;

public class FileUtils {
    /**
     * 如果指定的文件存在，则删除该文件
     */
    protected static void deleteFile(String fileName) {
        if (fileName == null || fileName.isEmpty()) {
            return;
        }
        
        File file = new File(fileName);
        if (file.exists() && file.isFile()) {
            file.delete();
        }
    }
}