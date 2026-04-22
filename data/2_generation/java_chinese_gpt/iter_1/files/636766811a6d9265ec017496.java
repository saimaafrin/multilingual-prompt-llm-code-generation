import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class FileIterator {
    private File[] files;
    private int currentIndex;

    public FileIterator(File directory) {
        if (directory.isDirectory()) {
            this.files = directory.listFiles();
        } else {
            this.files = new File[0];
        }
        this.currentIndex = 0;
    }

    /**
     * 返回下一个 {@link java.io.File} 对象，如果没有更多文件可用，则返回 {@code null}。
     */
    public InputStream next() throws IOException {
        if (currentIndex < files.length) {
            File file = files[currentIndex++];
            return new FileInputStream(file);
        }
        return null;
    }
}