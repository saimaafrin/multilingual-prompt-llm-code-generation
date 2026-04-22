import java.io.File;
import java.io.IOException;

public class FileDeleter {

    /**
     * 安排在JVM退出时删除指定文件。如果文件是目录，则删除该目录及所有子目录。
     * @param file 要删除的文件或目录，不能为空 {@code null}
     * @throws NullPointerException 如果文件为 {@code null}
     * @throws IOException 如果删除不成功
     */
    public static void forceDeleteOnExit(File file) throws IOException {
        if (file == null) {
            throw new NullPointerException("File cannot be null");
        }
        
        // Register a shutdown hook to delete the file on JVM exit
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            try {
                deleteRecursively(file);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }));
    }

    private static void deleteRecursively(File file) throws IOException {
        if (file.isDirectory()) {
            File[] children = file.listFiles();
            if (children != null) {
                for (File child : children) {
                    deleteRecursively(child);
                }
            }
        }
        if (!file.delete()) {
            throw new IOException("Failed to delete file: " + file.getAbsolutePath());
        }
    }
}