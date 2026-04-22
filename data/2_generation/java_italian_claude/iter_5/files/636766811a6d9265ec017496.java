import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;
import java.util.List;

public class FileIterator implements Iterator<InputStream> {
    private List<File> files;
    private int currentIndex = 0;

    public FileIterator(List<File> files) {
        this.files = files;
    }

    /** 
     * Restituisce il prossimo oggetto {@link java.io.File} oppure {@code null} se non ci sono più file disponibili.
     */
    public InputStream next() throws IOException {
        if (currentIndex >= files.size()) {
            return null;
        }
        
        File nextFile = files.get(currentIndex);
        currentIndex++;
        
        if (nextFile != null && nextFile.exists() && nextFile.isFile()) {
            return new FileInputStream(nextFile);
        }
        
        return null;
    }

    @Override
    public boolean hasNext() {
        return currentIndex < files.size();
    }
}