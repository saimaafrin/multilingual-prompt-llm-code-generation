import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.IOException;
import java.util.Iterator;

public class FileIterator implements Iterator<File> {
    private File[] files;
    private int currentIndex;

    public FileIterator(File directory) {
        if (!directory.isDirectory()) {
            throw new IllegalArgumentException("Provided file is not a directory");
        }
        this.files = directory.listFiles();
        this.currentIndex = 0;
    }

    @Override
    public boolean hasNext() {
        return currentIndex < files.length;
    }

    @Override
    public File next() {
        if (!hasNext()) {
            return null;
        }
        return files[currentIndex++];
    }

    public InputStream nextInputStream() throws IOException {
        File nextFile = next();
        if (nextFile == null) {
            return null;
        }
        return new FileInputStream(nextFile);
    }
}