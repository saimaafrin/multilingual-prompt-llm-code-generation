import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class FileIterator {
    private File[] files;
    private int currentIndex;

    public FileIterator(File[] files) {
        this.files = files;
        this.currentIndex = 0;
    }

    /**
     * अगला {@link java.io.File} ऑब्जेक्ट लौटाएं या {@code null} लौटाएं यदि कोई और फ़ाइल उपलब्ध नहीं है।
     */
    public InputStream next() throws IOException {
        if (currentIndex < files.length) {
            File file = files[currentIndex++];
            return new FileInputStream(file);
        }
        return null;
    }
}