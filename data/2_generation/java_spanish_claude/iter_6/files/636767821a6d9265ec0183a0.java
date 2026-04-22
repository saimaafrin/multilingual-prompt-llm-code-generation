import java.io.File;

public class FileUtils {

    /**
     * Elimina el archivo especificado si existe
     */
    protected static void deleteFile(String fileName) {
        File file = new File(fileName);
        if (file.exists()) {
            file.delete();
        }
    }

}