import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;
import java.util.List;

public class FileIterator {
    private Iterator<File> fileIterator;
    
    public FileIterator(List<File> files) {
        this.fileIterator = files.iterator();
    }

    /** 
     * Devuelve el siguiente objeto {@link java.io.File} o {@code null} si no hay más archivos disponibles.
     */
    public InputStream next() throws IOException {
        if (fileIterator.hasNext()) {
            File nextFile = fileIterator.next();
            return new FileInputStream(nextFile);
        }
        return null;
    }
}