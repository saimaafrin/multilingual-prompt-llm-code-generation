import java.io.File;
import java.io.IOException;

public class FileUtils {

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

        if (!file.exists()) {
            return;
        }

        if (file.isDirectory()) {
            deleteDirectoryOnExit(file);
        } else {
            file.deleteOnExit();
        }
    }

    private static void deleteDirectoryOnExit(File directory) throws IOException {
        if (!directory.isDirectory()) {
            throw new IllegalArgumentException("Not a directory: " + directory);
        }

        File[] files = directory.listFiles();
        if (files == null) {
            throw new IOException("Failed to list contents of " + directory);
        }

        for (File file : files) {
            if (file.isDirectory()) {
                deleteDirectoryOnExit(file);
            } else {
                file.deleteOnExit();
            }
        }

        directory.deleteOnExit();
    }

    public static void main(String[] args) {
        try {
            File file = new File("path/to/your/file_or_directory");
            forceDeleteOnExit(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}