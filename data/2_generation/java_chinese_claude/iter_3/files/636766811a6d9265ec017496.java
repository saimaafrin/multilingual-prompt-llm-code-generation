import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class FileIterator {
    private Queue<File> fileQueue = new LinkedList<>();
    private File currentFile;
    
    /**
     * 返回下一个 {@link java.io.File} 对象，如果没有更多文件可用，则返回 {@code null}。
     */
    public InputStream next() throws IOException {
        if (fileQueue.isEmpty()) {
            return null;
        }
        
        currentFile = fileQueue.poll();
        if (currentFile != null && currentFile.exists() && currentFile.isFile()) {
            return new FileInputStream(currentFile);
        }
        
        return next(); // Skip invalid files and try next
    }
}