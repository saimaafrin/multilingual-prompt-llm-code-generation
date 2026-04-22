import java.io.File;
import java.io.IOException;

/**
 * 如果指定的文件存在，则删除该文件
 */
protected static void deleteFile(String fileName) {
    File file = new File(fileName);
    if (file.exists()) {
        if (file.delete()) {
            System.out.println("文件删除成功: " + fileName);
        } else {
            System.out.println("文件删除失败: " + fileName);
        }
    } else {
        System.out.println("文件不存在: " + fileName);
    }
}