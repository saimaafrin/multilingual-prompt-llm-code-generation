import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;
import java.util.Queue;
import java.util.LinkedList;

public class FileIterator implements Iterator<InputStream> {
    private Queue<File> files;
    
    public FileIterator() {
        this.files = new LinkedList<>();
    }

    /** 
     * Restituisce il prossimo oggetto {@link java.io.File} oppure {@code null} se non ci sono più file disponibili.
     */
    public InputStream next() throws IOException {
        if (files.isEmpty()) {
            return null;
        }
        File nextFile = files.poll();
        return new FileInputStream(nextFile);
    }

    public boolean hasNext() {
        return !files.isEmpty();
    }

    public void addFile(File file) {
        if (file != null) {
            files.offer(file);
        }
    }
}