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

        file.deleteOnExit();

        if (file.isDirectory()) {
            File[] files = file.listFiles();
            if (files != null) {
                for (File subFile : files) {
                    forceDeleteOnExit(subFile);
                }
            }
        }
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