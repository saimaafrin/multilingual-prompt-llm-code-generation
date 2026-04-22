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
     * Devuelve el siguiente objeto {@link java.io.File} o {@code null} si no hay más archivos disponibles.
     */
    public InputStream next() throws IOException {
        if (currentIndex < files.length) {
            File file = files[currentIndex++];
            return new FileInputStream(file);
        }
        return null;
    }
}