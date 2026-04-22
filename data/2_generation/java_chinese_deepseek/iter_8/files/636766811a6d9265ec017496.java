import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;

public class FileIterator implements Iterator<InputStream> {
    private File[] files;
    private int currentIndex;

    public FileIterator(File directory) {
        if (!directory.isDirectory()) {
            throw new IllegalArgumentException("Provided path is not a directory");
        }
        this.files = directory.listFiles();
        this.currentIndex = 0;
    }

    @Override
    public boolean hasNext() {
        return currentIndex < files.length;
    }

    @Override
    public InputStream next() throws IOException {
        if (!hasNext()) {
            return null;
        }
        File nextFile = files[currentIndex++];
        return new FileInputStream(nextFile);
    }
}