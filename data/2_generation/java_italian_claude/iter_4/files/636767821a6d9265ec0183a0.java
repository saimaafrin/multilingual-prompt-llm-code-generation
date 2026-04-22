import java.io.File;

public class FileUtils {

    /**
     * Elimina il file specificato se esiste
     */
    protected static void deleteFile(String fileName) {
        if (fileName != null) {
            File file = new File(fileName);
            if (file.exists()) {
                file.delete();
            }
        }
    }
}