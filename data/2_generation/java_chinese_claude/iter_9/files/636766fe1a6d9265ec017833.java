import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileUtils {

    private static final List<File> deleteOnExitFiles = new ArrayList<>();
    
    static {
        Runtime.getRuntime().addShutdownHook(new Thread() {
            @Override
            public void run() {
                synchronized (deleteOnExitFiles) {
                    for (File file : deleteOnExitFiles) {
                        forceDelete(file);
                    }
                }
            }
        });
    }

    /**
     * 安排在JVM退出时删除指定文件。如果文件是目录，则删除该目录及所有子目录。
     * @param file 要删除的文件或目录，不能为空 {@code null}
     * @throws NullPointerException 如果文件为 {@code null}
     * @throws IOException 如果删除不成功
     */
    public static void forceDeleteOnExit(File file) throws IOException {
        if (file == null) {
            throw new NullPointerException("File must not be null");
        }

        synchronized (deleteOnExitFiles) {
            if (!deleteOnExitFiles.contains(file)) {
                deleteOnExitFiles.add(file);
            }
        }
    }

    private static void forceDelete(File file) {
        if (file.isDirectory()) {
            File[] files = file.listFiles();
            if (files != null) {
                for (File child : files) {
                    forceDelete(child);
                }
            }
        }
        file.delete();
    }
}