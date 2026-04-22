import java.io.File;
import java.io.IOException;

public class FileUtils {

    public static void forceDeleteOnExit(final File file) throws IOException {
        if (file == null) {
            throw new NullPointerException("File must not be null");
        }

        if (!file.exists()) {
            return;
        }

        file.deleteOnExit();
        
        if (!file.isDirectory()) {
            return;
        }

        // Delete contents recursively for directories
        final File[] files = file.listFiles();
        if (files == null) {
            throw new IOException("Failed to list contents of " + file);
        }

        for (final File f : files) {
            forceDeleteOnExit(f);
        }
    }
}