import java.io.File;
import java.util.Queue;
import java.util.LinkedList;

public class FileIterator {
    private Queue<File> fileQueue = new LinkedList<>();
    
    /**
     * Return the next {@link java.io.File} object or {@code null} if no more files are available.
     * @return next File object, or null if none remain
     */
    public File getNextFile() {
        if (fileQueue.isEmpty()) {
            return null;
        }
        return fileQueue.poll();
    }
    
    // Helper method to add files to the queue
    public void addFile(File file) {
        if (file != null) {
            fileQueue.offer(file);
        }
    }
}