import java.io.File;

public class FileUtils {

    /** 
     * 如果指定的文件存在，则删除该文件 
     */
    protected static void deleteFile(String fileName) {
        File file = new File(fileName);
        if (file.exists()) {
            if (file.delete()) {
                System.out.println("文件已成功删除: " + fileName);
            } else {
                System.out.println("无法删除文件: " + fileName);
            }
        } else {
            System.out.println("文件不存在: " + fileName);
        }
    }

    public static void main(String[] args) {
        // 示例用法
        deleteFile("test.txt");
    }
}